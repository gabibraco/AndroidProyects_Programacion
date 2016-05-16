package com.example.franprimo.syp_p2;

import android.util.Log;

/**
 * Created by FranPrimo on 18/12/15.
 */
public class TareaMuyCostosa extends Thread implements Runnable{
    private String TAG = "Practica 2 SYP: ";
    private static volatile boolean threadStoped = false;

    public void stopThread(){
        threadStoped = true;
    }

    @Override
    public void run(){
        Log.i(TAG, "Tarea muy costosa iniciada");
        try{
            for(int i=0; i<100; i++) {
                Log.i(TAG, "Tarea muy costosa en marcha");
                Thread.sleep(1000);
                if(threadStoped) break;
            }
        }catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        Log.i(TAG, "Tarea muy costosa finalizada");
    }
}
