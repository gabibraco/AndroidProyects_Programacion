package es.florida_uni.dam.practica2;


import android.util.Log;

public class TareaMuyCostosa extends Thread implements Runnable {

        private final static String TAG = "Practica 2 SYP: ";
        static volatile boolean threadStoped = false;
        static boolean finwhile = true;

        public void stopThread(){
            Log.i(TAG, "Pasa por aqui");
            threadStoped = true;


        }
        @Override
        public void run(){
            Log.i(TAG, "Tarea muy costosa iniciada");
            while(finwhile){
                try{
                    for(int i=0; i<100; i++) {
                        //Introducimos la variable flag dentro del if
                        if(!threadStoped){
                            Log.i(TAG, "Tarea muy costosa en marcha");
                            Thread.sleep(1000);
                            break;
                        }
                        //La variable que hemos definido para el while para detener el while
                        finwhile=false;
                    }
                } catch (InterruptedException e) {

                }
            }
            Log.i(TAG, "Tarea muy costosa finalizada");
        }
    }