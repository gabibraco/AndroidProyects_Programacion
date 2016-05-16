package com.example.gabi.actv3b_accd;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Instanciamos nuestros botones
        final Button btnalmacenar = (Button) findViewById(R.id.button);
        final Button btnactivity = (Button) findViewById(R.id.button2);
        //Le asignamos el listener
        btnalmacenar.setOnClickListener(this);
        btnactivity.setOnClickListener(this);
    }
    //Metodo para nuestro Listener
    public void onClick(View v) {
        switch (v.getId()) {
            /*
            Con este primer boton lo que se pretende es capturar lo que escribimos en el EditText
            Y almacenarlo mediante preferencias
             */
            case R.id.button:
                //Creamos nuestro objeto preferencia compartida, al cual le pasamos nuestropaquete, y un modo privadosolo
                // visible para la aplicacion
                SharedPreferences Preferencia = getSharedPreferences("com.example.gabi.actv3b_accd",Activity.MODE_PRIVATE);
                //Obtenemos un editor para mmodificar las preferencias
                SharedPreferences.Editor editor = Preferencia.edit();
                //Instanciamos nuestros EditText
                EditText Enombre = (EditText) findViewById(R.id.editText);
                EditText Edni = (EditText) findViewById(R.id.editText2);
                EditText Efecha = (EditText) findViewById(R.id.editText3);
                EditText Esexo = (EditText) findViewById(R.id.editText4);
                //Creamos las variables que tomaran el valor del EditText
                String getnombre = Enombre.getText().toString();
                String getdni = String.valueOf(Edni.getText().toString());
                String getfecha = Efecha.getText().toString();
                String getsexo = Esexo.getText().toString();
                //Guardamos nuestros valores con el campo clave y lo que recibimos
                editor.putString("Nombre",getnombre);
                editor.putString("DNI", getdni);
                editor.putString("Fecha", getfecha);
                editor.putString("Sexo", getsexo);
                //Guardamos los cambios
                editor.commit();
                //Limpiamos nuestros EditText
                Enombre.setText("");
                Edni.setText("");
                Efecha.setText("");
                Esexo.setText("");
            break;
            /*
            Con este segundo Boton lo que hacemos es un Intent para pasar a la otra  Activity
             */
            case R.id.button2:
                Intent llamada = new Intent(MainActivity.this,Main2Activity.class);
                startActivity(llamada);
            break;
        }
    }
}