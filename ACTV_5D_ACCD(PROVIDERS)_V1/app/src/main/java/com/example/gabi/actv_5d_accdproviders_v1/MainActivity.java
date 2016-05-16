package com.example.gabi.actv_5d_accdproviders_v1;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.CalendarContract;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class MainActivity extends AppCompatActivity {
    //Generammos nuestra Uri para accededer a nuestro contenedor
    static final String PROVIDER_NAME = "com.android.calendar";
    static final String URL = "content://" + PROVIDER_NAME + "/events";
    static final Uri CONTENT_URI = Uri.parse(URL);



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Instanciamos los botones
        Button btnListar = (Button) findViewById(R.id.buttonLeer);
        Button btnInsertar = (Button) findViewById(R.id.buttonInsertar);


        //Boton de insertar evento
        btnInsertar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Creamos un intent con la accion de insertar
                Intent calIntent = new Intent(Intent.ACTION_INSERT);
                //Le asignamos un tipo al intent (tipo event)
                calIntent.setType("vnd.android.cursor.item/event");
                //Le damos los extras como "titulo" "localizacion" y "descripccion" (extras basicos)
                calIntent.putExtra(CalendarContract.Events.TITLE, "Fiesta");
                calIntent.putExtra(CalendarContract.Events.EVENT_LOCATION, " pueblo");
                calIntent.putExtra(CalendarContract.Events.DESCRIPTION, "Concierto");

                //Le asignamos una fecha a un tipo de calendario concreto
                GregorianCalendar calDate = new GregorianCalendar(2015, 12, 15);
                //Le damos mas extras que indican la duracion, hora de inicio y hora de finalizacion
                calIntent.putExtra(CalendarContract.EXTRA_EVENT_ALL_DAY, true);
                calIntent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, calDate.getTimeInMillis());
                calIntent.putExtra(CalendarContract.EXTRA_EVENT_END_TIME, calDate.getTimeInMillis());

                //Iniciamos la activity con nuestro intent
                startActivity(calIntent);
            }
        });

        //Boton que lee todos los eventos
        btnListar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                //Creamos un ContentResolver, le asignamos la URI y otra informacion y se lo asignamos a un cursor
                ContentResolver cr = getContentResolver();
                Cursor cursor = cr.query(CONTENT_URI, null, null, null, null);

                //Comprobamos que el cursor no sea null y que sea posible moverlo al primer lugar
                if (cursor != null && cursor.moveToFirst()) {

                    //Variable indice para el cursor, que recorrera los elementos, cogiendo la columna "Tittle"
                    int indice = cursor.getColumnIndex(CalendarContract.Events.TITLE);
                    int Cuenta = cursor.getColumnIndex(CalendarContract.Events.ACCOUNT_NAME);//La cuenta del calendario
                    int display =cursor.getColumnIndex(CalendarContract.Events.CALENDAR_DISPLAY_NAME);//El numbre
                    int localizacion = cursor.getColumnIndex(CalendarContract.Events.EVENT_LOCATION);//Localizacion
                    int descripcion=cursor.getColumnIndex(CalendarContract.Events.DESCRIPTION);//Descripcion
                    //Creamos un Array de Strings que reciba el contador del cursor
                    String[] values = new String[cursor.getCount()];
                    //Realizaremos este "do" mientras el cursor tenga siguiente
                    do {
                        String name = cursor.getString(indice);
                        String local = cursor.getString(Cuenta);
                        String lugar = cursor.getString(localizacion);
                        String dis = cursor.getString(display);
                        String desc = cursor.getString(descripcion);
                        //Guardamos en el Array
                        values[cursor.getPosition()] =  "Nombre: " + name + "\n"+"Cuenta: " + local + "\n"
                                +"Lugar: "+ lugar+"\n"+"Descripcion: " +desc+ "\n"+"Display: "+ dis;
                    }
                    while (cursor.moveToNext());
                    //Añadimos los resultados del Array a un listView
                    ListView lv = (ListView) findViewById(R.id.listView);
                    //Creamos nuestro ArrayAdapter
                    ArrayAdapter<String> adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, values);
                    //Enchufamos a nuestra lista nuestro adapter
                    lv.setAdapter(adapter);

                }
            }
        });
    }

}