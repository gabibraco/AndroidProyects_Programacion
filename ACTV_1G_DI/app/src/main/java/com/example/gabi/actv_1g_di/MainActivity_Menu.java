package com.example.gabi.actv_1g_di;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity_Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity__menu);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //En este metodo, en inflate le pasamos nuestro menu
        getMenuInflater().inflate(R.menu.my_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        /*
        En este metodo declararemos las funciones de nuestros item
         */
        switch(item.getItemId()){
            case R.id.checkbox://Declaramos nuestro Objeto checkbox
                item.setChecked(true);//Decimos que es chequeable
                //Una vez que hemos clickado nos mostrara por pantalla el Toast
                Toast.makeText(getApplicationContext(),"Impreso",Toast.LENGTH_LONG).show();
                return true;
            case R.id.Copiar:
                Toast.makeText(getApplicationContext(),"Copiado",Toast.LENGTH_LONG).show();
                return true;
            case R.id.Pegar:
                Toast.makeText(getApplicationContext(),"Pegado",Toast.LENGTH_LONG).show();
                return true;
            case R.id.Cortar:
                Toast.makeText(getApplicationContext(),"Cortado",Toast.LENGTH_LONG).show();
                return true;
            case R.id.Seleccionar:
                Toast.makeText(getApplicationContext(),"Selecciona una opción",Toast.LENGTH_LONG).show();
                return true;
            case R.id.Submenu1:
                item.setChecked(true);
                Toast.makeText(getApplicationContext(),"Seleccionado todo",Toast.LENGTH_LONG).show();
                return true;
            case R.id.Submenu2:
                item.setChecked(true);
                Toast.makeText(getApplicationContext(),"Selecciona una parte",Toast.LENGTH_LONG).show();
                return true;
            case R.id.Submenu3:
                item.setChecked(true);
                Toast.makeText(getApplicationContext(),"Adios",Toast.LENGTH_LONG).show();
                finish();//Aqui ademas de mostrar el texto nos salremos de la aplicacion
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
