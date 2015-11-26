package com.example.gabi.mathicefragment;

import android.app.*;
import android.os.Bundle;
import android.widget.Toast;
/*Este Activity contendra los dos ffragment el estatico y el dinamico extiende de activity
*A ser una activity y le implementamos el fragment ListFragment para pasarle nuestro Listener
*Y nuestros datos*/
public class ActivityFragment extends Activity implements ListFragment.ListFragmentListener{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_fragment);
       //Recojo los datos que he enviado con el intent y se lo asigno a 2 variables
        Bundle bundle=getIntent().getExtras();
        String nombre=bundle.getString("nombre");
        String edad = bundle.getString("anyo");

        //Añado el perfil fragment en el contenedor
        PerfilFragment perfil =new PerfilFragment();
        getFragmentManager().beginTransaction().add(R.id.fragment_container,perfil).commit();

        }

    //Nuestro listener
    public void onListSelected(int position,String item){
        //Definimos lo que haran
        if (item=="PERFIL"){
            PerfilFragment perfil = new PerfilFragment();
            //Creamos un objeto fragment manager y inicia la transaccion
            FragmentTransaction transaction=getFragmentManager().beginTransaction();
            //Reempazamos el conteniddo de nuestro contenedor
            transaction.replace(R.id.fragment_container,perfil);
            //Lo cargamos
            transaction.commit();

        }else if(item=="JUEGO"){
            // Create fragment and give it an argument specifying the article it should show
            //Creamos un nuevo fragment
            TextFragment textFragment = new TextFragment();
            //Creamos un objeto fragment manager y inicia la transaccion
            FragmentTransaction FT = getFragmentManager().beginTransaction();
            //L añande al text fragment
            FT.add(R.id.fragment_container, textFragment);
            //Lanzamos la FragmentTransaction
            FT.commit();
        }else if (item=="INSTRUCCIONES"){
            Toast.makeText(this, "Danos tiempo para implementar " + item, Toast.LENGTH_SHORT).show();
        }else if (item == "INFO" ){
            Toast.makeText(this, "Danos tiempo para implementar " + item, Toast.LENGTH_SHORT).show();
        }
    }
}
