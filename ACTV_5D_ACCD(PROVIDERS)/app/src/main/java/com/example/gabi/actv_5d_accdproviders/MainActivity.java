package com.example.gabi.actv_5d_accdproviders;

import android.Manifest;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.support.v4.app.ActivityCompat;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import java.util.TimeZone;

import static android.provider.CalendarContract.ACCOUNT_TYPE_LOCAL;
import static android.provider.CalendarContract.Events;


public class MainActivity extends Activity {
    //Generammos nuestra Uri para accededer a nuestro contenedor
    static final String PROVIDER_NAME = "com.android.calendar";
    static final String URL = "content://" + PROVIDER_NAME + "/events";
    static final Uri CONTENT_URI = Uri.parse(URL);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Obtenemos nuestro objeto ContentResolver
        ContentResolver cr = getContentResolver();
        //Definimos nuestro cursor y le pasamos la query al cual le pasamos nuestra URI
        final Cursor cursor = cr.query(CONTENT_URI, null, null, null, null);
        //Creamos nuestro button Consultar para obtener la informacion de nuestro contenedor
        final Button Consultar = (Button) findViewById(R.id.BtnConsultar);
        Consultar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                /*
                Con la accion de este boton lo que hacemos es recuperar la informacion que tenemos de los elementos
                o eventos que tenemos del calendario.
                 */

                if (cursor != null && cursor.moveToFirst()) {
                    //Obtenemoos nuestros elementos a traves de nuestro cursor el cual los recorrera y los guardara
                    int indice_nombre = cursor.getColumnIndex(Events.TITLE);//devuelve el titulo
                    int Cuenta = cursor.getColumnIndex(Events.ACCOUNT_NAME);//La cuenta del calendario
                    int display =cursor.getColumnIndex(Events.CALENDAR_DISPLAY_NAME);//El numbre
                    int localizacion = cursor.getColumnIndex(Events.EVENT_LOCATION);//Localizacion
                    int descripcion=cursor.getColumnIndex(Events.DESCRIPTION);//Descripcion
                    String[] values = new String[cursor.getCount()];
                    do {
                        //Recuperamos el nombre
                        String name = cursor.getString(indice_nombre);
                        String local = cursor.getString(Cuenta);
                        String lugar = cursor.getString(localizacion);
                        String dis = cursor.getString(display);
                        String desc = cursor.getString(descripcion);
                        //Guardamos en el Array
                        values[cursor.getPosition()] = cursor.getCount()  +"\n "+"Nombre: " + name + "\n"+"Cuenta: " + local + "\n"
                                                        +"Lugar: "+ lugar+"\n"+"Descripcion: " +desc+ "\n"+"Display: "+ dis;
                    } while (cursor.moveToNext());
                    //Instanciamos nuestro objeto ListView
                    ListView lv = (ListView) findViewById(R.id.listView);
                    //Se lo pasammos a nuestro adapter
                    ArrayAdapter<String> adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, values);
                    lv.setAdapter(adapter);

                }
            }
        });
        /*
        Con este boton introducimos los datos en el calendario pero no los puedo recuperar en la cunsulta
        para poder ver que se insertan es necesario verlos con adb en com.android.providers.calentar/databases/Events
         */
        final Button Insertar = (Button) findViewById(R.id.BtnInsertar);
        Insertar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Declaramos los views con los que vamos a trabajar y los instanciamos
                EditText ID = (EditText) findViewById(R.id.Edit_Id);
                EditText Titulo = (EditText) findViewById(R.id.EditTitulo);
                String id = ID.getText().toString();
                String title = Titulo.getText().toString();
                //Generamos nuestro objeto Content Resolver
                ContentResolver cr = getContentResolver();
                ContentValues values = new ContentValues();



                //Introducimos nuestros valores
                values.put(CalendarContract.Events.CALENDAR_ID, id);
                values.put(CalendarContract.Events.DTSTART,20151231);
                values.put(CalendarContract.Events.DTEND,20151231);
                values.put(CalendarContract.Events.TITLE,title);
                values.put(CalendarContract.Events.DESCRIPTION,"felicidades");
                values.put(CalendarContract.Events.CUSTOM_APP_PACKAGE, getApplicationContext().getPackageName());
                values.put(CalendarContract.Events.EVENT_TIMEZONE, TimeZone.getDefault().getID());
                //Chekeamos los permisos de entrada
                if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.WRITE_CALENDAR) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                //Utilizamos la funcion insert para insertarlos
                cr.insert(CalendarContract.Events.CONTENT_URI, values);
                Toast.makeText(MainActivity.this,"Insertado",Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}