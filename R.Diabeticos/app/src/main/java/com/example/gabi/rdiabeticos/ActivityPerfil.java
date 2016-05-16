package com.example.gabi.rdiabeticos;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

/*****************************************************************
 **EN ESTA ACTIVITY IMPLEMENTAMOS LA INTERFAZ DE NUESTRO FRAGMENT**
 ******************************************************************/
public class ActivityPerfil extends Activity implements FragmentPerfil.OnFragmentBotonListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);
        //Comprobamos que la activity este usando un fragment container que no sea null
        if (findViewById(R.id.fragment_container) != null) {
            //Comprobamos que no volvamos de un estado anterior donde no sea necesario crear esto de nuevo
            if (savedInstanceState != null) {
                return;
            }
            //Creamos un nuevo fragment
            FragmentPerfil perfil = new FragmentPerfil();
            //Añadimos el fragment creado en nuestro contenedor de fragments dinamicos y lo lanzamos
            getFragmentManager().beginTransaction().add(R.id.fragment_container, perfil).commit();
        }

    }
    //Declaramos la interfaz de nuestro fragment , donde recojo la informacion y la puedo almacear
    public void onFragmentInteraction(String uno, String dos) {
        //Declaramos un Toast para comprobar que llega hasta donde quiero la informacion
        Toast.makeText(this, "Aqui llega la info del FRAGMENT_PERFIL a la ACTIVITY_PERFIL " + uno
                + " " + dos, Toast.LENGTH_SHORT).show();
        //INTENT PARA PASAR AL LA ATIVITY_FRAGMENT QUE ES NUESTRO MAIN ACTIVITY
        Intent mainIntent = new Intent(getApplicationContext(), ActivitySeleccion.class);
        // Aqui pasamos la inormacion entre las dos Activitys (de Act_Perfil a Act_fragment)
        mainIntent.putExtra("nombre", uno); //nombre
        mainIntent.putExtra("apellido", dos);  //edad
        startActivity(mainIntent);

    }

}
