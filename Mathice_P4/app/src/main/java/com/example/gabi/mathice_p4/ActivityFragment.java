package com.example.gabi.mathice_p4;

import android.app.*;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.widget.Toast;
/*Este Activity contendra los dos fragment el estatico y el dinamico extiende de activity
*A ser una activity y le implementamos el fragment ListFragment para pasarle nuestro Listener
*Y nuestros datos*/
public class ActivityFragment extends Activity implements ListFragment.ListFragmentListener,PerfilFragment.OnFragmentBotonListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_fragment);
        //Checkamos si estamos en un dispositivo grande o no
        if (findViewById(R.id.fragment_container) != null) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
            //Recojo los datos que he enviado con el intent del activity perfil y se lo asigno a 2 variables
            Bundle bundle = getIntent().getExtras();
            String nombre = bundle.getString("nombre");
            String edad = bundle.getString("anyo");

            //Añado el perfil fragment en el contenedor
            PerfilFragment perfil = new PerfilFragment();
            getFragmentManager().beginTransaction().add(R.id.fragment_container, perfil).commit();

        }
    }
    //Nuestro listener
    public void onListSelected(int position,String item) {
        //Definimos lo que haran
        if (findViewById(R.id.fragment_container) != null) {
            if (position == 0) {
                PerfilFragment secondFragment = new PerfilFragment();
                //Creamos un objeto fragment manager y inicia la transaccion
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                //Reempazamos el conteniddo de nuestro contenedor
                transaction.replace(R.id.fragment_container, secondFragment);
                //Lo cargamos
                transaction.commit();

            } else if (position == 1) {
                // Create fragment and give it an argument specifying the article it should show
                //Creamos un nuevo fragment
                TextFragment firstFragment = new TextFragment();
                //Creamos un objeto fragment manager y inicia la transaccion
                FragmentTransaction FT = getFragmentManager().beginTransaction();
                //L añande al text fragment
                FT.replace(R.id.fragment_container, firstFragment);
                //Lanzamos la FragmentTransaction
                FT.commit();
            } else if (item == "INSTRUCCIONES") {
                Toast.makeText(this, "Danos tiempo para implementar " + item, Toast.LENGTH_SHORT).show();
            } else if (item == "INFO") {
                Toast.makeText(this, "Danos tiempo para implementar " + item, Toast.LENGTH_SHORT).show();
            }
        }else{
            // si es movil

            //  meto al intent la info que quiero pasar entre actv. (de Act Perfil a Act Main)
            if (position == 0) {
                //Si el dispositivo es pequeño dara paso a la main2activity al que le pasamos la posicion
                Intent mainIntent = new Intent(getApplicationContext(), Main2Activity.class);
                //posicion clickada , intent para pasar la info al main activity 2
                mainIntent.putExtra("posicion", position);
                startActivity(mainIntent); }else
            if(position == 1) {
                Intent mainIntent = new Intent(getApplicationContext(), Main2Activity.class);
                //posicion clickada , intent para pasar la info al main activity 2
                mainIntent.putExtra("posicion", position);
                startActivity(mainIntent);
            }
        }

    }
    //Interfaza del FragmentPerfil, aqui recogemos la informacion pasada por la interfaz y el
    //Activity se encarga de procesarla o utilizarla en este caso lo muestra en un toast
    @Override
    public void onFragmentInteraction(String a, String b) {
        Toast.makeText(this," Paso correctamente la info del Fragment a la Act Main " + a + b , Toast.LENGTH_SHORT).show();
        //Aquicuando pulsamos damos paso al textfragment en la posicion
        TextFragment firstFragment = new TextFragment();
        //Creamos un objeto fragment manager y inicia la transaccion
        FragmentTransaction FT = getFragmentManager().beginTransaction();
        //L añande al text fragment
        FT.replace(R.id.fragment_container, firstFragment);
        //Lanzamos la FragmentTransaction
        FT.commit();
    }
}
