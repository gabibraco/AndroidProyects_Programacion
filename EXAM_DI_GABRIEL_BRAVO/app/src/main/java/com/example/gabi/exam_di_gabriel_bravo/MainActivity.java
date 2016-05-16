package com.example.gabi.exam_di_gabriel_bravo;

import android.content.Intent;
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
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Declaramos nuestros Views
        EditText Enombre = (EditText)findViewById(R.id.editTextNombre);
        EditText Eprofesion = (EditText)findViewById(R.id.editTextProfesion);

        RadioButton hombre =(RadioButton)findViewById(R.id.radioButtonHombre);
        RadioButton mujer =(RadioButton)findViewById(R.id.radioButtonMujer);

        Button botonProvincia =(Button)findViewById(R.id.button);

        botonProvincia.setOnClickListener(this);



        registerForContextMenu(Enombre);
        registerForContextMenu(Eprofesion);

    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        // Inflamos el submenú
        this.getMenuInflater().inflate(R.menu.context_menu, menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        //Generar acciones del context menu
        switch (item.getItemId()) {
            case R.id.copiar:
                // Intent llamar = new Intent(Intent.ACTION_VIEW);
                Toast.makeText(getApplicationContext(), "copiar", Toast.LENGTH_LONG).show();
                //startActivity(llamar);
                return true;
            case R.id.Pegar:
                //Intent mensage = new Intent(Intent.ACTION_VIEW);
                Toast.makeText(getApplicationContext(),"Pegar", Toast.LENGTH_LONG).show();
                //startActivity(mensage);
                return true;
        }
        return super.onContextItemSelected(item);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()){
            case R.id.Configuracion:
                Toast.makeText(getApplicationContext(),"Configuracion",Toast.LENGTH_LONG).show();
                return true;
            case R.id.Preferencias:
                Intent i =new Intent(this,Preferencias.class);
                startActivity(i);
                Toast.makeText(getApplicationContext(),"Preferencias",Toast.LENGTH_LONG).show();
                return true;
            case R.id.Datos:
                Toast.makeText(getApplicationContext(),"Seleciona un Dato",Toast.LENGTH_LONG).show();
                return true;
            case R.id.Anteriores:
                Toast.makeText(getApplicationContext(),"Anteriores",Toast.LENGTH_LONG).show();
                return true;
            case R.id.Actuales:
                Toast.makeText(getApplicationContext(),"Configuracion",Toast.LENGTH_LONG).show();
                return true;

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        Intent intent =new Intent(MainActivity.this,Provincia.class);
        startActivity(intent);
    }
}
