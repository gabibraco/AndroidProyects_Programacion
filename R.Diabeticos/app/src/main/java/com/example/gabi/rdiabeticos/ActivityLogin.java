package com.example.gabi.rdiabeticos;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.gabi.rdiabeticos.R.id.fragment_container;

public class ActivityLogin extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //DECLARAMOS NUESTROS VIEWS
        final EditText Edad = (EditText)findViewById(R.id.editTextEdad);
        final EditText Nombre = (EditText)findViewById(R.id.editTextNombre);

        TextView TEdad =(TextView)findViewById(R.id.TextoEdadPerfil);
        TextView TNombre = (TextView)findViewById(R.id.TextoNombrePerfil);

        Button BtnEntrar = (Button)findViewById(R.id.BotonEntrar);
        BtnEntrar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String name = Nombre.getText().toString();
                String edad = Edad.getText().toString();
                Intent i = new Intent(getApplicationContext(),ActivityRecetas.class);
                i.putExtra("nombre", name);
                i.putExtra("edad", edad);
                startActivity(i);
            }
        });
        Button BtnRegitrar = (Button)findViewById(R.id.buttonRegistro);
        BtnRegitrar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (findViewById(fragment_container) != null) {
                    Toast.makeText(getApplicationContext(),"Vamos a Registrarnos ", Toast.LENGTH_LONG).show();
                    //Creamos un nuevo fragment
                    FragmentPerfil perfil = new FragmentPerfil();
                    //Creamos un objeto fragment manager y inicia la transaccion
                    FragmentTransaction transaction = getFragmentManager().beginTransaction();
                    transaction.replace(fragment_container, perfil);
                    //Limpiamos el contenedor
                    transaction.addToBackStack(null);
                    //Lo cargamos
                    transaction.commit();
                } else {
                    Intent intent = new Intent(getApplicationContext(), ActivityPerfil.class);
                    startActivity(intent);
                }
           }
        });

    }

}
