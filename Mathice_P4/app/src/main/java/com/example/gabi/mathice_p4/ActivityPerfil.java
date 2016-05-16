package com.example.gabi.mathice_p4;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static com.example.gabi.mathice_p4.R.layout.activity_activity_perfil;

public class ActivityPerfil extends Activity implements PerfilFragment.OnFragmentBotonListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_activity_perfil);


        //CARGAMOS EL FRAGMENTO EN SU CONTENEDOR ESTATICO
        PerfilFragment perfil = (PerfilFragment) getFragmentManager().findFragmentById(R.id.fragment_Perfil);
        TextView nombrePerfil = (TextView) findViewById(R.id.TextoNombrePerfil);
        TextView edadPerfil = (TextView) findViewById(R.id.TextoEdadPerfil);
    }

    /*
    Definimos la interfaz del perfilfragment
     */
    @Override
    public void onFragmentInteraction(String a, String b) {
        // Recojo los datos introducidos en el EditText y los almaceno
        Intent i = new Intent(getApplicationContext(), ActivityFragment.class);
        i.putExtra("nombre", a);
        i.putExtra("anyo", b);
        startActivity(i);
    }
}

