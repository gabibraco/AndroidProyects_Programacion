package com.example.gabi.p05_mathdicemusica_pmm;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class PerfilFragment extends Fragment {
    Button boton;
    String nombre=null;
    String edad=null;

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
       final EditText textnombre = (EditText) v.findViewById(R.id.editTextNombre);
       final EditText textedad = (EditText) v.findViewById(R.id.editTextEdad);



        Button boton = (Button) v.findViewById(R.id.BotonJugar);
        boton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String nombre = textnombre.getText().toString();
                String edad = textedad.getText().toString();

                Intent mainIntent = new Intent(getActivity(), ActivityFragment.class);
                mainIntent.putExtra("nombre", nombre);
                mainIntent.putExtra("edad", edad);
                startActivity(mainIntent);
            }
        });
        // Inflate the layout for this fragment
        return v;

    }

    // TODO: Rename method, update argument and hook method into UI event


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);


    }

    @Override
    public void onDetach() {
        super.onDetach();

    }



}
