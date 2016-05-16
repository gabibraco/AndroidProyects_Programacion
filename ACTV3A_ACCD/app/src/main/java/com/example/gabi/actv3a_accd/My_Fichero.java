package com.example.gabi.actv3a_accd;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
//Declaraos nuestra clase y immplementamos el Listener
public class My_Fichero extends AppCompatActivity implements View.OnClickListener {
    //Declaraos nuestros Objetos
    private final EditText editText = null;
    private final String File_Name = "fichero2.txt";
    private final TextView textView = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my__fichero);

        //Definicion de id
        Button btnAñadir = (Button) findViewById(R.id.button);
        Button btnMostrar = (Button) findViewById(R.id.button2);

        //Añadimos nuestros Listener a los botones
        btnAñadir.setOnClickListener(this);
        btnMostrar.setOnClickListener(this);

    }
    //Comprobammos a traves del metodo exist si el archivo  existe y si es asi nos devuelve true
    private boolean exist(String[] files, String filebusca) {
        for (int f = 0; f < files.length; f++)
            if (filebusca.equals(files[f]))
                return true;
        return false;
    }

    @Override
    public void onClick(View v) {
        String[] files = fileList();
        //Ponemoc como condicion que el archivo exista dento de nuestro vector
        if (exist(files ,File_Name)) {

        switch (v.getId()) {
            //Si accionamos nuestro boton Añadir  hara lo siguinete y esto lo realizamos mediante un
            //case porque implementar dos listener a la vez vez nos da error
            case R.id.button:
                EditText editText = (EditText) findViewById(R.id.editText);
                try {
                    //Creamos nuestro Archivo a partir de un String que sera el nombre
                    FileOutputStream file = openFileOutput(File_Name, Context.MODE_APPEND);
                    //Recogemos nuestro contenido del EditText
                    String Contenido = editText.getText().toString();
                    DataOutputStream dil = new DataOutputStream(file);
                    //Escribimos el contenido en nuestro fichero
                    dil.writeBytes(Contenido + "\n");
                    //Limpiamos nnuestro EditText
                    editText.setText("");
                    file.close();//Cerramos el file
                //Tratamos la excepcion
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            //La accion de nuestro boton Mostrar
            case R.id.button2:
                TextView textView = (TextView) findViewById(R.id.textView);
                try {
                    //Creamos nuestro Archivo a partir de un String que sera el nombre
                    FileInputStream fin = openFileInput(File_Name);
                    InputStreamReader isr = new InputStreamReader(fin);
                    char[] buff = new char[1000];//Creamos un bufffer de char
                    //Creamos una variable vacia para pasarle la lectura dentro del while
                    String str = "";
                    int charRead;//Generamos una variable de tipo int
                    //Creamos un bucle while para ir leyendo linea a linea mmientras sea mayor de 0
                    while ((charRead = isr.read(buff)) > 0) {
                        //Se coia en la variable string la lectura del buff
                        String strRead = String.copyValueOf(buff);
                        str = strRead;
                    }
                    textView.setText(str);//Pasamos la lectura al textview
                    isr.close();//Cerraos isr
                    //Tratamos la excepcion
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;

        }
    }else {
            //Sino existe mostraremos un error por el Toast
            Toast.makeText(getApplicationContext(),"El archivo no existe",Toast.LENGTH_LONG);
        }
    }


}