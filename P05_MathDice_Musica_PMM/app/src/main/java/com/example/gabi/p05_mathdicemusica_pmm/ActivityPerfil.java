package com.example.gabi.p05_mathdicemusica_pmm;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static com.example.gabi.p05_mathdicemusica_pmm.R.layout.activity_activity_perfil;
<<<<<<< HEAD
    /*
    Generamos esta activity porqu en el caso de que el fragment_container sea nulo
    se debera cargar solo el fragment perfil en una pantalla
    */
=======

>>>>>>> a7d5ad622879e5833adeca8ae2b958866b88a44b
public class ActivityPerfil extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_activity_perfil);
<<<<<<< HEAD
=======

>>>>>>> a7d5ad622879e5833adeca8ae2b958866b88a44b
            //Comprobamos que la activity este usando un fragment container que no sea null
            if (findViewById(R.id.perfil_container) != null) {
                //Comprobamos que no volvamos de un estado anterior donde no sea necesario crear esto de nuevo
                if (savedInstanceState != null) {
                    return;
                }
<<<<<<< HEAD
                //Creamos un nuevo fragment
                PerfilFragment perfil = new  PerfilFragment();
=======

                //Creamos un nuevo fragment
              PerfilFragment perfil = new  PerfilFragment();


>>>>>>> a7d5ad622879e5833adeca8ae2b958866b88a44b
                //Añadimos el fragment creado en nuestro contenedor de fragments dinamicos y lo lanzamos
                getFragmentManager().beginTransaction().add(R.id.perfil_container, perfil).commit();
            }

        }
    }
