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
            //Recojo los datos que he enviado con el intent que pasaba a esta activity y se los asigno
            //a dos variables.
            Bundle bundle = getIntent().getExtras();
            String nombre = bundle.getString("nombre");
            String edad = bundle.getString("edad");

            //Muestro en consola los datos recibidos con el intent
            Log.i("Nombre:", nombre);
            Log.i("Edad:", edad);


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
        if (position == 0){
            Toast.makeText(this," perfil no esta implementado", Toast.LENGTH_LONG).show();
        }else
            // si la posición es cero , cargamos el Fragment Perfil.
            if (position == 1) {
                if (findViewById(R.id.fragment_container) != null) {
                    JuegoFragment juego = new JuegoFragment();
                    //Creamos un objeto fragment manager y inicia la transaccion
                    FragmentTransaction transaction = getFragmentManager().beginTransaction();
                    //Reempazamos el conteniddo de nuestro contenedor
                    transaction.replace(R.id.fragment_container, juego);
                    //Limpiamos el contenedor
                    transaction.addToBackStack(null);
                    //Lo cargamos
                    transaction.commit();

                } else {
                    Intent intent = new Intent(this, MainPqGame.class);

                    startActivity(intent);
                }
            }else if (position == 2) {
                Toast.makeText(this, "Danos tiempo para implementar " + item, Toast.LENGTH_SHORT).show();
            }else if (position == 3) {
                Toast.makeText(this, "Danos tiempo para implementar " + item, Toast.LENGTH_SHORT).show();
            }
    }
}




