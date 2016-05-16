package com.example.gabi.actv_1h_di;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.ContextMenu;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private ListView listViewContact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*
        EN PRIMER LUGAR DEFINIMOS EL ARRAY DE STRINGS Y LO CONVERTIMOS A UNA LISTA
        EN ESTE CASO ARRAYLIST
       */
        //DATOS
        String[] contactos = new String[]{"Jose", "Pepe", "Manolo",
                "Ramon", "Gloria", "Lidia", "Susana", "Antonio", "Ana", "Alvaro",
                "Iker", "Merche", "Pedro", "David", "Alex", "Laura", "Teresa",
                "Daniel"};
        ArrayList<String> listaContact = new ArrayList<String>(Arrays.asList(contactos));
        //En segundo Lugar enchufamos la lista al adaptador
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listaContact);

        //Por ultimo enchufamos el Adapter a la Vista que es ListView
        //Interfaz o Vision
        final ListView listViewContact = (ListView) findViewById(R.id.listView);
        listViewContact.setAdapter(adapter);
        //Registramos el context menu y le pasamos la lista
        registerForContextMenu(listViewContact);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        ListView listViewContact = (ListView) findViewById(R.id.listView);
        int mPosition;
        // Se comprueba si se ha pulsado algún elemento del ListView
        if (v.getId() == R.id.listView){
            // Obtenemos la posición del elemento que ha sido pulsado.
            mPosition = ((AdapterView.AdapterContextMenuInfo) menuInfo).position;
            // Establecemos como título del submenú la opción pulsado del ListView
            menu.setHeaderTitle(listViewContact.getAdapter().getItem(mPosition).toString());
            // Inflamos el submenú
            this.getMenuInflater().inflate(R.menu.context_menu, menu);
        }
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        //Generar acciones del context menu
        switch (item.getItemId()) {
            case R.id.mostrar:
               // Intent llamar = new Intent(Intent.ACTION_VIEW);
                Toast.makeText(getApplicationContext(),"Mostrando", Toast.LENGTH_LONG).show();
                //startActivity(llamar);
                return true;
            case R.id.eliminar:
                //Intent mensage = new Intent(Intent.ACTION_VIEW);
                Toast.makeText(getApplicationContext(),"Eliminando", Toast.LENGTH_LONG).show();
                //startActivity(mensage);
                return true;
        }
        return super.onContextItemSelected(item);
    }
}