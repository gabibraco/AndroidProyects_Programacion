package com.example.gabi.actv_6a_accd_v1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Declaramos nuestros views
        TextView Titulo = (TextView) findViewById(R.id.textView3);
        TextView label1 = (TextView) findViewById(R.id.textView);
        TextView label2 = (TextView) findViewById(R.id.textView2);

        final Button boton = (Button) findViewById(R.id.button);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final EditText number1 = (EditText) findViewById(R.id.PrimerNumero);
                final EditText number2 = (EditText) findViewById(R.id.SegundoNumero);
                int uno = Integer.parseInt(number1.getText().toString());
                int dos =Integer.parseInt(number2.getText().toString());
                if (uno>0 && dos>0) {
                    int suma = uno+dos;
                    String resu = String.valueOf(suma);
                    final TextView resultado = (TextView) findViewById(R.id.Resultado);
                    resultado.setText(resu);
                    Toast.makeText(MainActivity.this, "Los numeros son positivos" + suma, Toast.LENGTH_LONG).show();
                } else {
                    Button boton = (Button) findViewById(R.id.button);
                    boton.setEnabled(false);
                    Toast.makeText(MainActivity.this, "Los numeros son negativos o no son numeros", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}


