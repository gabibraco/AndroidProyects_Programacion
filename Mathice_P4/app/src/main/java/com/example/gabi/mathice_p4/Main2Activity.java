package com.example.gabi.mathice_p4;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

/*
Esta activyti se cargara en caso de que el dispositivo sea pequeño e implementa o recoge los
datos que introducimos en el fragmentPeril, que actua con este activity a traves de su interfaz
 */
public class Main2Activity extends Activity implements PerfilFragment.OnFragmentBotonListener {
    int posicoion =0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        // aqui  recojo la info pasada con el intent  desde la act MainActivity,
        Bundle bundlemain = getIntent().getExtras();
        // la asigno a variables
        Integer posicion = bundlemain.getInt("posicion",0);
        // Comprobación del paso correcto de los parametros desde actividad Perfil a act Main:
        Toast.makeText(this, "Compruebo que paso correctamente la info  entre Activityes" + posicion, Toast.LENGTH_SHORT).show();

    }
    //Interfaz del perfilfragment
    @Override
    public void onFragmentInteraction(String a, String b) {
        //Muestro en un Toast la informacion introducida en el fragmentPerfil
        Toast.makeText(this,"Paso a pequeño"+a+b,Toast.LENGTH_LONG).show();
        //Al pulsar el boton vuelvo al ACTIVITY fRAGMENT
        Intent i =new Intent(getApplication(),ActivityFragment.class);
        startActivity(i);
    }
}
