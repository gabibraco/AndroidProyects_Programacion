package es.florida_uni.dam.examensegundaevaluacin;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    final static String TAG = "SYP-examensegunda";

    Button btnComenzar;
    Button btnVelocidades;
    Button btnSaludar;

    public ProgressBar progresoLiebre;
    public ProgressBar progresoTortuga;

    private Spinner velocidadTortuga;
    private Spinner velocidadLiebre;

    public static final int MSG_ACTUALIZAR_TORTUGA = 10;
    public static final int MSG_TERMINAR_CARRERA = 20;

    Carrera carrera;


    public ReceptorMensajes handler = new ReceptorMensajes();

    class ReceptorMensajes extends Handler {
        @Override
        public void handleMessage(Message mensaje) {
            switch (mensaje.what){
                case MSG_ACTUALIZAR_TORTUGA:
                    progresoTortuga.setProgress(mensaje.arg1);
                    break;
                case MSG_TERMINAR_CARRERA:
                    terminarCarrera();
                    break;
                default:
                    Log.e(TAG,"La actividad principal ha recibido un mensaje extraño");
            }
            super.handleMessage(mensaje);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        velocidadTortuga = (Spinner) findViewById(R.id.velocidadTortuga);
        velocidadTortuga.setSelection(1);
        progresoTortuga = (ProgressBar) findViewById(R.id.progresoTortuga);

        velocidadLiebre = (Spinner) findViewById(R.id.velocidadLiebre);
        velocidadLiebre.setSelection(1);
        progresoLiebre = (ProgressBar) findViewById(R.id.progresoLiebre);

        instalarManejadores();

    }

    private void instalarManejadores(){
        btnComenzar = (Button) findViewById(R.id.btnComenzar);
        btnVelocidades = (Button) findViewById(R.id.btnVelocidades);
        btnSaludar = (Button) findViewById(R.id.btnSaludar);


        // Manejador del botón de saludar
        btnSaludar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Log.i(TAG, "Saludando");
                Toast.makeText(
                        MainActivity.this, "Hola", Toast.LENGTH_SHORT
                ).show();
            }
        });

        // Manejador del botón que comienza la carrera
        btnComenzar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Log.i(TAG, "Comenzando la carrera");
                comenzarCarrera();
            }
        });


        // Manejador del botón que actualiza las velocidades
        btnVelocidades.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Log.i(TAG, "ACtualizando velocidades");
                actualizarVelocidades();
            }
        });
    }

    private void comenzarCarrera(){
        btnComenzar.setEnabled(false);
        btnVelocidades.setEnabled(true);

        int prioridadLiebre = calcularPrioridad(String.valueOf(velocidadLiebre.getSelectedItem()));
        int prioridadTortuga = calcularPrioridad(String.valueOf(velocidadTortuga.getSelectedItem()));

        carrera = new Carrera(this, prioridadLiebre, prioridadTortuga);
        carrera.start();
    }

    private void terminarCarrera(){
        btnComenzar.setEnabled(true);
        btnVelocidades.setEnabled(false);

        Toast.makeText(
                MainActivity.this, "La carrera ha terminado", Toast.LENGTH_SHORT
        ).show();

    }


    private void actualizarVelocidades(){
        int prioridadLiebre = calcularPrioridad(String.valueOf(velocidadLiebre.getSelectedItem()));
        int prioridadTortuga = calcularPrioridad(String.valueOf(velocidadTortuga.getSelectedItem()));
        carrera.actualizarVelocidades(prioridadLiebre, prioridadTortuga);
    }

    private int calcularPrioridad(String texto){
        if(texto == getString(R.string.lenta)) return Thread.MIN_PRIORITY;
        if(texto == getString(R.string.normal)) return Thread.NORM_PRIORITY;
        if(texto == getString(R.string.rapida)) return Thread.MAX_PRIORITY;
        return Thread.NORM_PRIORITY;

    }

}
