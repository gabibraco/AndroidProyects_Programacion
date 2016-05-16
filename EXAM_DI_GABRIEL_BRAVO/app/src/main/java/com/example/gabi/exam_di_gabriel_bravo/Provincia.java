package com.example.gabi.exam_di_gabriel_bravo;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class Provincia extends AppCompatActivity {

    private ListView listViewContact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_provincia);
        /*
        EN PRIMER LUGAR DEFINIMOS EL ARRAY DE STRINGS Y LO CONVERTIMOS A UNA LISTA
        EN ESTE CASO ARRAYLIST
       */
        //DATOS
        String[] contactos = new String[]{"Valencia", "Castellon", "Alicante"};
        ArrayList<String> listaContact = new ArrayList<String>(Arrays.asList(contactos));
        //En segundo Lugar enchufamos la lista al adaptador
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listaContact);

        //Por ultimo enchufamos el Adapter a la Vista que es ListView
        //Interfaz o Vision
        final ListView listViewContact = (ListView) findViewById(R.id.listView);
        listViewContact.setAdapter(adapter);
        //Registramos el context menu y le pasamos la lista
        listViewContact.setOnItemClickListener(new nuestroListener());

    }

    private class nuestroListener implements AdapterView.OnItemClickListener {
        public void onItemClick(AdapterView<?>parent,View view,int position,long id) {
            //String de la posicion
            String item = (String) parent.getItemAtPosition(position);
            Toast.makeText(getApplicationContext(),"Se ha seleccionado "+item, Toast.LENGTH_LONG).show();
        }
    }
}
