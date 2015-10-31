package com.example.gabi.list_view;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class List_View_PMM extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list__view__pmm);
      /*
      EN PRIMER LUGAR DEFINIMOS EL ARRAY DE STRINGS Y LO CONVERTIMOS A UNA LISTA
      EN ESTE CASO ARRAYLIST
       */
        //DATOS
        String[] sistemasOperatvos = new String[]{"Android", "iPhone", "WindowsMobile",
                "Blackberry", "WebOs", "Ubuntu", "Windows", "Max Os X", "Linux", "OS/2",
                "Ubuntu", "Windows7", "Max Os X", "Linux", "OS/2", "Android", "iPhone",
                "WindowsMobile"
        };
        ArrayList<String> listaSO = new ArrayList<String>(Arrays.asList(sistemasOperatvos));
        //En segundo Lugar enchufamos la lista al adaptador
        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listaSO);

        //Utilizamos nuestro AdapterCustomizado
        MenuAdapter adapter = new MenuAdapter(this, listaSO);

        //Por ultimo enchufamos el Adapter a la Vista que es ListView
        //Interfaz o Vision
        final ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);
        //InterActuando
        listView.setOnItemClickListener(new nuestroListener());



    }

        //implementamos el listener para nuestro listView
        //INNERCLASS
        private class nuestroListener implements AdapterView.OnItemClickListener{
            public void onItemClick(AdapterView<?>parent,View view,int position,long id){
                //String de la posicion
                String item = (String)parent.getItemAtPosition(position);
               // Toast.makeText(List_View_PMM.this,item,Toast.LENGTH_LONG).show();
               // Paso de Informacion
                Intent intent =new Intent(List_View_PMM.this,List_View_PMM_02.class);
                intent.putExtra("so",item);
                startActivity(intent);


            }


        }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_list__view__pmm, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        //int id = item.getItemId();

        //noinspection SimplifiableIfStatement
       // if (id == R.id.action_settings) {
            //return true;
        //}

        return super.onOptionsItemSelected(item);
    }
}
