package com.example.gabi.rdiabeticos;

import android.app.Activity;
import android.app.FragmentTransaction;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.Window;
import android.widget.Toast;

import static com.example.gabi.rdiabeticos.R.id.fragment_container;


/*Este Activity contendra los dos fragment el estatico y el dinamico extiende de activity
*A ser una activity y le implementamos el fragment FragmentList para pasarle nuestro Listener
*Y nuestros datos*/
public class ActivityRecetas extends Activity implements FragmentList.ListFragmentListener ,FragmentPerfil.OnFragmentBotonListener {
//    private MyDBAdapter myDBAdapter;
    String name = "";
    String apellido = "";
    String path = "";
    private MenuItem item;
    final static String TAG = "P05_FINAL";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.onCreate(savedInstanceState);
        // con esto quitamos el titulo
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //Checkamos si estamos en un dispositivo grande o no
        setContentView(R.layout.activity_fragment);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        //Checkamos si estamos en un dispositivo grande o no
        if (findViewById(fragment_container) != null) {
            //Coloco el fragment lista en su contenedor estatico
           // ListFragment lf = (ListFragment) getFragmentManager().findFragmentById(R.id.list_fragment);
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
            Log.v(TAG, "recibido nombre: " + nombre + " y edad: " + edad);
            //Declaramos nuestro FragmentVacio
            FragmentVacio vacio = new FragmentVacio();
            //LLamamos al manager para comenzar la transaccion
            getFragmentManager().beginTransaction().add(R.id.fragment_container,vacio).commit();
        }else{
          //  Toast.makeText(this, "ERES PEQUEÑO", Toast.LENGTH_LONG).show();
        }
    }
    //Nuestro listener
    public void onListSelected(int position) {

        //Definimos lo que haran
        // si es tableta
        if (position == 0) {
            if (findViewById(fragment_container) != null) {
                //Informacion
                Toast.makeText(this, "Recetas Tartas ", Toast.LENGTH_SHORT).show();
                //Creamos un nuevo fragment
                FragmentTarta Ftarta = new FragmentTarta();
                //Creamos un objeto fragment manager y inicia la transaccion
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(fragment_container,Ftarta);
                //Limpiamos el contenedor
                transaction.addToBackStack(null);
                //Lo cargamos
                transaction.commit();
            } else {
                Intent intent = new Intent(this, ActivityTarta.class);
                   startActivity(intent);
            }

        }else if (position == 1) {
            //Si fragment_container no es nulo
            if (findViewById(fragment_container) != null) {
                //Informacion
                Toast.makeText(this, "Recetas Batidos " , Toast.LENGTH_SHORT).show();
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
            } else {
                //Si es nulo pasara a una pantalla pequeña , por lo tanto  una activity
                Intent intent = new Intent(this, ActivityBatidos.class);
                startActivity(intent);
            }
        } else if (position == 2) {
            //Si fragment_container no es nulo
            if (findViewById(fragment_container) != null) {
                //Informacion
                Toast.makeText(this, "Recetas Bolleria " , Toast.LENGTH_SHORT).show();
                //Declaramos nuestro fragment
                FragmentBolleria Fbolleria = new FragmentBolleria();
                //Creamos un objeto fragment manager y inicia la transaccion
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                //Reempazamos el conteniddo de nuestro contenedor
                transaction.replace(fragment_container, Fbolleria);
                //Limpiamos el contenedor
                transaction.addToBackStack(null);
                //Lo cargamos
                transaction.commit();
            } else {
            //Si es nulo pasara a una pantalla pequeña , por lo tanto  una activity
                Intent intent = new Intent(this, ActivityBolleria.class);
                startActivity(intent);
                }

        } else if (position == 3) {
            //Si fragment_container no es nulo
            if (findViewById(fragment_container) != null) {
                //Informacion
                Toast.makeText(this, "Recetas Frutas ", Toast.LENGTH_SHORT).show();
                //Declaramos nuestro fragment
                FragmentFrutas FFrutas = new FragmentFrutas();
                //Creamos un objeto fragment manager y inicia la transaccion
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                //Reempazamos el conteniddo de nuestro contenedor
                transaction.replace(fragment_container, FFrutas);
                //Limpiamos el contenedor
                transaction.addToBackStack(null);
                //Lo cargamos
                transaction.commit();
            } else {
            //Si es nulo pasara a una pantalla pequeña , por lo tanto  una activity
                Intent intent = new Intent(this, ActivityFrutas.class);
                startActivity(intent);
            }
        }
    }
    //Este es el interfaz definido en nuestro interface
    public void onFragmentInteraction(String A, String B) {
        // Comprobación del paso correcto de los parametros desde actividad Perfil a act Main:
        Toast.makeText(this,"Pasamos bien la info del Fragment a la Act Main " + A + B , Toast.LENGTH_SHORT).show();
    }
}
