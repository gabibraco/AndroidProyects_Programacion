package com.example.gabi.mathicefragment;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ActivityPerfil extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_perfil);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //CARGAMOS EL FRAGMENTO EN SU CONTENEDOR EESTATICO
        PerfilFragment perfil = (PerfilFragment)getFragmentManager().findFragmentById(R.id.fragment_Perfil);

        final EditText nombre =(EditText)findViewById(R.id.editTextNombre);
        final EditText edad = (EditText)findViewById(R.id.editTextEdad);

        final TextView nombrePerfil = (TextView)findViewById(R.id.TextoNombrePerfil);
        final TextView edadPerfil = (TextView)findViewById(R.id.TextoEdadPerfil);

        //Introducimos el Listener del Boton

        Button boton (Button)findViewById(R.id.BotonJugar);
        boton.setOnClickListener(new View.OnClickListener(){
            public void onClick(view v){
                // Recojo los datos introducidos en el EditText y los almaceno
                String nombre = nombre.GetText().toString();
                String anyo = anyo.GetText().toString();
                Intent i = new Intent(getApplicationContext(),ActivityFragment.class);
                i.putExtra("nombre",nombre);
                i.putExtra("anyo",anyo);
                startActivity(i);


            }



        }



    }

}
