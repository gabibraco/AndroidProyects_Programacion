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

public class ActivityPerfil extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_activity_perfil);

            //Comprobamos que la activity este usando un fragment container que no sea null
            if (findViewById(R.id.perfil_container) != null) {
                //Comprobamos que no volvamos de un estado anterior donde no sea necesario crear esto de nuevo
                if (savedInstanceState != null) {
                    return;
                }

                //Creamos un nuevo fragment
              PerfilFragment perfil = new  PerfilFragment();


                //Añadimos el fragment creado en nuestro contenedor de fragments dinamicos y lo lanzamos
                getFragmentManager().beginTransaction().add(R.id.perfil_container, perfil).commit();
            }

        }
    }
