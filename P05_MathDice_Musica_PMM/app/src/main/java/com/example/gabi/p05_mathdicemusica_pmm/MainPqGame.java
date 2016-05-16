package com.example.gabi.p05_mathdicemusica_pmm;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class MainPqGame extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainpqgame);
        JuegoFragment gameFragment = new JuegoFragment();
        //Creamos un objeto "transaction" que recoge el fragment manager y inicia la transaccion
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        //Remplaza lo que haya en el contenedor por el "gameFragment"
        transaction.replace(R.id.fragment_container_entero, gameFragment);
        //Esto permite que el usuario pueda volver atras
        //Esta parte es un problema ya que manda todos los fragments creados detras de forma que
        //si inicias 20 juegos nuevos, tienes 21 fragments escondidos detras
        transaction.addToBackStack(null);
        //Lanzamos la transaccion
        transaction.commit();
    }
}




