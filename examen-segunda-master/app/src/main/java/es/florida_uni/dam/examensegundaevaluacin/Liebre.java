package es.florida_uni.dam.examensegundaevaluacin;


import android.util.Log;


public class Liebre extends Thread {

    final static String TAG = "SYP-examensegunda";
    MainActivity actividadPadre;

    public Liebre(MainActivity actividadPadre) {
        this.actividadPadre = actividadPadre;
    }

    @Override
    public void run() {
        mostrarProgreso(0);
        for (int i = 0; i < Carrera.LONGITUD_CARRERA; i++) {
            Utils.consumeCPU();
            mostrarProgreso(i);
        }
    }

    private void mostrarProgreso(final int progreso) {
        Log.i(TAG, "Liebre ha corrido " + (progreso + 1) + " metros. Velocidad:" + Thread.currentThread().getPriority());

        // TODO: Mostrar el progreso en la barra principal
        // Debéis hacerlo utilizando runOnUIThread o enviando un runnable
        // Código para actualizar la barra de progreso: actividadPadre.barraProgreso.setProgress(progreso+1);
        // Aproximadamente 2/3 sentencias, aunque se puede hacer en una
        // TU CODIGO AQUI

        actividadPadre.runOnUiThread(new Runnable() {
            @Override
            //Creamos el metodo run
            public void run() {
                //Activamos la barraProgreso y le pasamos la variable
                actividadPadre.progresoLiebre.setProgress(progreso);
                //Comprobamos que se pone en marcha
                Log.i(TAG, "Iniamos la barra de progreso");


                // TU CODIGO HASTA AQUI
            }
        });

    }
}