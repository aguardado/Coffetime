package com.coffe.aguardad.coffetime;

import android.app.Activity;
import android.content.Intent;
import android.widget.EditText;

public class GoChatUsers implements Runnable{

    EditText nombre;
    Activity activity;

    public GoChatUsers(EditText nombre, Activity activity){
        this.nombre = nombre;
        this.activity = activity;
    }

    @Override
    public void run() {
        Intent goChatActivity = new Intent(activity.getApplicationContext(), ChatActivity.class);
        String usuarioOnline = this.nombre.getText().toString();
        goChatActivity.putExtra("usuarioOnline", usuarioOnline);
        activity.startActivity(goChatActivity);//para conectar una activity con la otra
    }
}
