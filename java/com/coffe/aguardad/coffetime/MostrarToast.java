package com.coffe.aguardad.coffetime;


import android.widget.Toast;
import android.app.Activity;

public class MostrarToast implements Runnable{

    String msgToast;
    Activity activity;

    public MostrarToast(String msg, Activity activity){
        this.msgToast = msg;
        this.activity = activity;
    }

    @Override
    public void run() {
        Toast msg = Toast.makeText(activity.getApplicationContext(), msgToast, Toast.LENGTH_LONG);
        msg.show();
    }
}
