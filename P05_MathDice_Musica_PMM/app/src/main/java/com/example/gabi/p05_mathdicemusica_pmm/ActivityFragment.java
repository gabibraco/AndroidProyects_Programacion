package com.example.gabi.p05_mathdicemusica_pmm;

import android.app.*;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.Window;
import android.widget.Toast;
/*Este Activity contendra los dos fragment el estatico y el dinamico extiende de activity
*A ser una activity y le implementamos el fragment ListFragment para pasarle nuestro Listener
*Y nuestros datos*/
public class ActivityFragment extends Activity implements ListFragment.ListFragmentListener {
    private MenuItem item;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // con esto quitamos el titulo
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //Checkamos si estamos en un dispositivo grande o no
        setContentView(R.layout.activity_activity_fragment);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        //Checkamos si estamos en un dispositivo grande o no
        if (findViewById(R.id.fragment_container) != null) {
            //Coloco el fragment lista en su contenedor estatico
           PerfilFragment perfilFragment = new PerfilFragment();

            /*
            * Recojo los datos que he enviado con el intent que pasaba a esta activity y se los asigno
            *a dos variables.(Los datos los envio a traves de un intent creado en el perfil fragment)
            *Aqui en el ACTIVITY nos encargamos de hacer la logica que consideemos con los datos.
            */
            Bundle bundle = getIntent().getExtras();
            //Recojo los datos y los asignoo a dos variables
            String nombre = bundle.getString("nombre");
            String edad = bundle.getString("edad");
            //Muestro en consola los datos recibidos con el intent
            Log.i("Nombre:", nombre);
            Log.i("Edad:", edad);

            //LLamamos al manager para comenzar la transaccion
            getFragmentManager().beginTransaction().add(R.id.fragment_container, perfilFragment).commit();
            //Dispositivo pequeño
        }else{
            Toast.makeText(this,"ERES PEQUEÑO", Toast.LENGTH_LONG).show();
        }
    }

    //Nuestro listener
    public void onListSelected(int position) {

        //Definimos lo que haran
        // si es tableta
        //Perfil
        if (position == 0) {
            if (findViewById(R.id.fragment_container) != null) {
                Toast.makeText(this, " perfil no esta implementado", Toast.LENGTH_LONG).show();
                //Creamos un nuevo fragment
                PerfilFragment perfil = new PerfilFragment();
                //Creamos un objeto fragment manager y inicia la transaccion
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container, perfil);
                //Limpiamos el contenedor
                transaction.addToBackStack(null);
                //Lo cargamos
                transaction.commit();
            } else {
                Intent intent = new Intent(this, ActivityPerfil.class);
                startActivity(intent);
            }

                // si la posición es cero , cargamos el Fragment Perfil.
                //Cragamos el fragment juego
                }else if (position == 1) {
                    //Si fragment_container no es nulo
                    if (findViewById(R.id.fragment_container) != null) {
                        //Declaramos nuestro fragment
                        JuegoFragment juego = new JuegoFragment();
                        //Creamos un objeto fragment manager y inicia la transaccion
                        FragmentTransaction transaction = getFragmentManager().beginTransaction();
                        //Reempazamos el conteniddo de nuestro contenedor
                        transaction.replace(R.id.fragment_container, juego);
                        //Limpiamos el contenedor
                        //transaction.addToBackStack(null);
                        //Lo cargamos
                        transaction.commit();
                    } else {
                        //Si es nulo pasara a una pantalla pequeña , por lo tanto  una activity
                        Intent intent = new Intent(this, MainPqGame.class);
                        startActivity(intent);
                    }
                } else if (position == 2) {
                    //Instrucciones
                    Toast.makeText(this, "Danos tiempo para implementar " + item, Toast.LENGTH_SHORT).show();
                } else if (position == 3) {
                    //Informacion
                    Toast.makeText(this, "Danos tiempo para implementar " + item, Toast.LENGTH_SHORT).show();
                }
            }
        }




