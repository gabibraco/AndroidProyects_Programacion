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


public class PerfilFragment extends Fragment implements View.OnClickListener {
    Button boton;
    private OnFragmentBotonListener mListener;
    EditText nombre;
    EditText edad;
    String NOMBRE;
    String ANYO;

    public PerfilFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_perfil, container, false);
         nombre = (EditText) v.findViewById(R.id.editTextNombre);
         edad = (EditText) v.findViewById(R.id.editTextEdad);



        Button boton = (Button) v.findViewById(R.id.BotonJugar);

        boton.setOnClickListener(this);


        // Inflate the layout for this fragment
        return v;

    }

    // TODO: Rename method, update argument and hook method into UI event


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentBotonListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }

    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }
    /**
     * ESTE ES EL LISTENER DEL BOTON
     *
     */
    @Override
    public void onClick(View v) {

        String NOMBRE = nombre.getText().toString();
        String ANYO = edad.getText().toString();
        mListener.onFragmentInteraction(NOMBRE, ANYO);
    }

    /**
     * ESTE ES EL INTERFAZ QUE EL ACTIVITY SUPOERIOR DEBE IMPLEMENTAR
     */
    public interface OnFragmentBotonListener {

        public void onFragmentInteraction(String a, String b);


    }
}
