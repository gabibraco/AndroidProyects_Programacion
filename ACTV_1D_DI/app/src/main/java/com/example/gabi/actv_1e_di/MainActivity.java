package com.example.gabi.actv_1e_di;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Inicio de declaracion de objetos
         final LinearLayout Abajo = (LinearLayout) findViewById(R.id.LayoutAbajo);

         final CheckBox MsgOculto = (CheckBox) findViewById(R.id.CheckBox);

         //Declaracion de objeto Toast y su variable
         int duration = Toast.LENGTH_SHORT;
         Context context = getApplicationContext();
         CharSequence text = "Gracias por el click largo";
         final Toast toast = Toast.makeText(context, text, duration);

         final ToggleButton togButton1 = (ToggleButton) findViewById(R.id.Button1);
         final ToggleButton togButton2 = (ToggleButton) findViewById(R.id.Button2);

         final TextView TxtOculto = (TextView) findViewById(R.id.TextViewOculto);
         final TextView longText = (TextView) findViewById(R.id.longClickTextView);
         final TextView ratingTV = (TextView) findViewById(R.id.ratingTV);

         final RatingBar rating = (RatingBar) findViewById(R.id.ratingBar);

        /*
        TogggleButton: Lo podemos definir como un interuptor on/of, es decir pulsado o  no
         */
        //Accion o Listener del primer ToggleButton para cambiar el color del fondo o del layoutabajo
        togButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(togButton1.isChecked()){
                    Abajo.setBackgroundColor(0xffff0000);
                }
                else {
                    Abajo.setBackgroundColor(0x00000000);
                }
            }
        });

        //ToggleButton2 realiza la segunda accion
        togButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (togButton2.isChecked()) {
                    togButton2.setTextColor(0xffffffff);
                } else {
                    togButton2.setTextColor(0xff000000);
                }
            }
        });

        //Accion del checkbox para ocultar textoculto o no
        MsgOculto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (MsgOculto.isChecked()) {
                    MsgOculto.setText("ocultar");
                    TxtOculto.setVisibility(View.VISIBLE);
                } else {
                    MsgOculto.setText("mostrar");
                    TxtOculto.setVisibility(View.INVISIBLE);
                }
            }
        });

        //Accion da la pulsacion larga al pulsar de forma larga en el text muesta el Toast
        longText.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                toast.show();
                return true;
            }
        });

        /*
        RatingBar:Se pude definr como un  control de seleccion numerico por parte del usuario en
        este caso son las estrellas las que se seleccionan o mejor dicho se rellenan
         */
        rating.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener(){
            @Override
            public void onRatingChanged (RatingBar ratingBar,float rating,boolean fromUser){
                //(int) rating sirve para cambiar el float a un integer para facilitar la lectura
                ratingTV.setText((int) rating +" / "+ ratingBar.getMax());
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
