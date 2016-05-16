package com.example.gabi.rdiabeticos;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import static com.example.gabi.rdiabeticos.R.id.fragment_container;

public class ActivityBatidos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_batidos);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Si fragment_container no es nulo
        if (findViewById(fragment_container) != null) {
            //Declaramos nuestro fragment
            FragmentBatidos Fbatidos = new FragmentBatidos();
            //Creamos un objeto fragment manager y inicia la transaccion
            FragmentTransaction transaction = getFragmentManager().beginTransaction();
            //Reempazamos el conteniddo de nuestro contenedor
            transaction.replace(fragment_container, Fbatidos);
            //Limpiamos el contenedor
            transaction.addToBackStack(null);
            //Lo cargamos
            transaction.commit();
        }
    }

}
