package com.example.gabi.p05_mathdicemusica_pmm;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class Main2Activity extends Activity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main2);
        // aqui  recojo la info pasada con el intent  desde la act MainActivity,

        Bundle bundlemain = getIntent().getExtras();

        // la asigno a variables
        Integer posicion = bundlemain.getInt("posicion",1);

        // Comprobación del paso correcto de los parametros desde actividad Perfil a act Main:

        Toast.makeText(this, "Compruebo que paso correctamente la info  entre Activityes" + posicion, Toast.LENGTH_SHORT).show();

    }


}