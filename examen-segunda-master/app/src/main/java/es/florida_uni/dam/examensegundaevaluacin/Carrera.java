package es.florida_uni.dam.examensegundaevaluacin;


import android.os.Message;
import android.util.Log;

public class Carrera extends Thread{

    final static String TAG = "SYP-examensegunda";
    protected final static int LONGITUD_CARRERA = 100;

    Tortuga tortuga;
    Liebre liebre;

    int prioridadLiebre;
    int prioridadTortuga;

    MainActivity actividadPadre;

    public Carrera(MainActivity actividadPadre, int prioridadLiebre, int prioridadTortuga){
        super();
        this.prioridadLiebre = prioridadLiebre;
        this.prioridadTortuga = prioridadTortuga;
        this.actividadPadre = actividadPadre;
    }


    @Override
    public void run() {

        liebre = new Liebre(actividadPadre);
        tortuga = new Tortuga(actividadPadre.handler);

        // Ajusta la velocidad inicial
        actualizarVelocidades(prioridadLiebre,prioridadTortuga);

        liebre.start();
        tortuga.start();

        //Esperar a que acaben los dos
        // TODO: Espera a que acaben los dos threads
        // Aproximadamente 4 líneas de código
        // TU CODIGO AQUI



        // TU CODIGO HASTA AQUI


        Log.i(TAG, "Los dos corredores han llegado");


        //Notificar que la carrera ha acabado
        Message mensaje = actividadPadre.handler.obtainMessage(MainActivity.MSG_TERMINAR_CARRERA);
        actividadPadre.handler.sendMessage(mensaje);
    }

    public void actualizarVelocidades(int prioridadLiebre, int prioridadTortuga){
        // TODO: hacer que los corredores ajusten su prioridad
        // Aproximadamente 2 líneas de código
        // TU CODIGO AQUI
            liebre.setPriority(prioridadLiebre);
            tortuga.setPriority(prioridadTortuga);


        // TU CODIGO HASTA AQUI
    }


}
