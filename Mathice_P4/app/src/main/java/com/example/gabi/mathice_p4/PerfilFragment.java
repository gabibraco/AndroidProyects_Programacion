package com.example.gabi.mathice_p4;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import com.example.gabi.mathice_p4.R;

import static com.example.gabi.mathice_p4.R.id.editTextNombre;
import static com.example.gabi.mathice_p4.R.id.editTextEdad;

/*
En este fragment declaramos o mejor dicho implementamos la accion del boton
 */
public class PerfilFragment extends Fragment implements View.OnClickListener {

    //Declaro mis variables
    Button boton;
    EditText nombre;
    EditText edad;
    String NOMBRE;
    String ANYO;

    //nuestros callback(Comuniacion)
    private OnFragmentBotonListener mListener;

    //Constructor requerido de nuestro fragment
    public PerfilFragment() {
        // Required empty public constructor
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    //Creamos nuetras vistas
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //Inflamos nuestro view
        View v = inflater.inflate(R.layout.fragment_perfil, container, false);
        //Instanciamos nuestros EditText
        nombre = (EditText) v.findViewById(R.id.editTextNombre);
        edad = (EditText) v.findViewById(R.id.editTextEdad);
        //Instanciamos nuestro button
        Button boton = (Button) v.findViewById(R.id.BotonJugar);
        //Declarammos nuestro Listener del boton
        boton.setOnClickListener(this);
        // Inflate the layout for this fragment
        return v;

    }
//En este metodo comprobamos si el activity superior nos escucha en este caso el ActivityFragment
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            //Nuestro callback
            mListener = (OnFragmentBotonListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

//Matamos nuestro callback para evitar problemas en el caso de que el usuario cambien de aplicacion
    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }
    /**
     * ESTE ES EL LISTENER DEL BOTON, en este caso definimod o asignamos dos variables a la
     *informacion que existe en nuestro EditText
     */
    @Override
    public void onClick(View v) {
        String NOMBRE = nombre.getText().toString();
        String ANYO = edad.getText().toString();
        //LLamamos a nuestra interfaz , y le pasamos los string
        mListener.onFragmentInteraction(NOMBRE, ANYO);
    }

    /**
     * ESTE ES EL INTERFAZ QUE EL ACTIVITY SUPOERIOR DEBE IMPLEMENTAR
     * Implementamos la interfaz , le pasamos por parametros los string recogidos en la accion del
     * boton
     */
    public interface OnFragmentBotonListener {
        public void onFragmentInteraction(String a, String b);


    }
}
