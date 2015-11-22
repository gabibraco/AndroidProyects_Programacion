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
        //Condicion para comprobar que el fragment no es null que esta en uso
        if (findViewById(R.id.fragment_container) != null) {
            // However, if we're being restored from a previous state,
            // then we don't need to do anything and should return or else
            // we could end up with overlapping fragments.
            if (savedInstanceState != null) {
                return;
            }
        }
    }
    //Nuestro listener
    public void onListSelected(int position,String item){
        //Definimos lo que haran
        if (item=="PERFIL"){
            Toast.makeText(this, "Danos tiempo para implementar " + item, Toast.LENGTH_SHORT).show();
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
