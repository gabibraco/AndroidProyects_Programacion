package es.florida_uni.dam.practica3;


import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.Toast;

public class TareaMuyCostosa implements Runnable{

    public final static int MSG_TAREA_FINALIZADA = 1;

    final static String TAG = "SYP-practica3";

    volatile boolean interrumpido = false;

    MainActivity actividadPadre;
    Handler handler;

    public TareaMuyCostosa(MainActivity actividadPadre, Handler handler){
        this.actividadPadre = actividadPadre;
        this.handler = handler;
    }

    @Override
    public void run(){
        Log.i(TAG, "Tarea muy costosa iniciada");

        try {
            for(int i=0;i<100;i++){
                if(interrumpido) return;
                Log.i(TAG, "Tarea muy costosa en marcha...");
                mostrarProgreso(i);
                Thread.sleep(50);
            }
            Log.i(TAG, "Tarea muy costosa finalizada");
            notificarFinalizacion();
        }catch(InterruptedException e){
            return;
        }

        Log.i(TAG, "Tarea muy costosa finalizada");
    }

    // TODO: Mostrar el progreso en la barra principal
    // Debéis hacerlo utilizando runOnUIThread o enviando un runnable
    private void mostrarProgreso(final int progreso) {
     //Activamos el runOnUiThread con actividadPadre
     actividadPadre.runOnUiThread(new Runnable() {
         @Override
         //Creamos el metodo run
         public void run() {
             //Activamos la barraProgreso y le pasamos la variable
             actividadPadre.barraProgreso.setProgress(progreso);
             //Comprobamos que se pone en marcha
             Log.i(TAG, "Iniamos la barra de progreso");

         }
     });
    }

    // TODO: Avisar de la finalización de la tarea
    // Debéis hacerlo enviando un mensaje a la actividad principal
    // No utilices runnables aquí
    private void notificarFinalizacion(){
        //Creamos el mensaje
           Message mensaje = new Message();
        //Assignamos el valor de nuestra variable int al mensaje
           mensaje.what=MSG_TAREA_FINALIZADA;
        //Se lo enviamos al main a traves del handler
           handler.sendMessage(mensaje);
    }

    synchronized public void cancel(){
        if(interrumpido) return;
        interrumpido = true;
        Thread.currentThread().interrupt();
    }
}
