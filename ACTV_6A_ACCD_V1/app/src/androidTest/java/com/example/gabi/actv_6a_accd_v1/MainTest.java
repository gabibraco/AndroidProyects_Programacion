package com.example.gabi.actv_6a_accd_v1;

import android.test.ActivityInstrumentationTestCase2;
import android.test.TouchUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import junit.framework.Assert;

/**
 * Created by Gabi on 01/02/2016.
 */
public class MainTest extends ActivityInstrumentationTestCase2<MainActivity> {
    //Declaramos nuestro abjeto de tipo MainActivity de manera global
    MainActivity activity;


    //Generamos el constructor que nos lo pide la clase
    public MainTest() {
        super(MainActivity.class);
    }

    //Aqui podemos definir los view qque queremos testear
    public void setUp() throws Exception {
        //Hacemos referencia a la activity que queremos testear
        activity = getActivity();
        //Referenciamos los Views que queremoos testear
         View number1 = activity.findViewById(R.id.PrimerNumero);
         View number2 = activity.findViewById(R.id.SegundoNumero);

    }

    public void testPreconditions() {
        //Comprobamos que nuestra activity y nuestros Views no sean nulos
        assertNotNull(activity);
        assertNotNull(activity.findViewById(R.id.PrimerNumero));
        assertNotNull(activity.findViewById(R.id.SegundoNumero));
        assertNotNull(activity.findViewById(R.id.Resultado));
        assertNotNull(activity.findViewById(R.id.button));
    }

    public void testApp() {
        //Recuperamos nuestros Views
        final EditText number1 = (EditText) activity.findViewById(R.id.PrimerNumero);
        getInstrumentation().runOnMainSync(new Runnable() {
            @Override
            public void run() {
                number1.requestFocus();
            }
        });
        //Envio o inserto un nuero en el edit text
        getInstrumentation().sendStringSync("1");
        //Recuperamos nuestros Views
        final EditText number2 = (EditText) activity.findViewById(R.id.SegundoNumero);
        getInstrumentation().runOnMainSync(new Runnable() {
            @Override
            public void run() {
                number2.requestFocus();
            }
        });
        //Envio o inserto un nuero en el edit text
        getInstrumentation().sendStringSync("1");

        //Recupero mi boton
        final Button boton = (Button) activity.findViewById(R.id.button);

        //Declaro dos string que recoje los dos edit texto
        String two = number2.getText().toString();
        String one = number1.getText().toString();
        //Transformo y sumo lo recuperado en los edit texto
        int uno = Integer.parseInt(two);
        int dos = Integer.parseInt(one);

        //Pulsamos el boton
        TouchUtils.clickView(this, boton);
        //Compruebo que mis variables son mayores que 0
        try {
            Assert.assertTrue(uno > 0);
            Assert.assertTrue(dos > 0);
            //Declaro un int y sumo los dos valores
            int suma = uno + dos;
            //Tranformo el resultado en un String
            String resu = String.valueOf(suma);
            //Recupero mi textview
            final TextView resultado = (TextView) activity.findViewById(R.id.Resultado);
            //Le envio el String con el resultado
            getInstrumentation().sendStringSync(resu);
            //Creo un String para recuperar el resultado
            String actualText = resultado.getText().toString();
            //Comparo el resultado con resu
            Assert.assertEquals("el resultado ", resu, actualText);
        } catch (Exception e){
            //Comprobamos la otra condicion sino es igual a 0
            Assert.assertFalse(uno > 0);
            Assert.assertFalse(dos > 0);
            //Desactivamos el boton
            boton.setEnabled(false);
        }
    }
}