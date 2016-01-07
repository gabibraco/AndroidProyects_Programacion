package com.example.gabi.mathice_p4;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;


public class Main2Activity extends Activity implements PerfilFragment.OnFragmentBotonListener {

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

    @Override
    public void onFragmentInteraction(String a, String b) {

    }
}
