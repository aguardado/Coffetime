package com.coffe.aguardad.coffetime;

import android.util.Log;
import android.view.View;
import android.app.Activity;
import android.widget.EditText;

public class PressLogin implements View.OnClickListener{

    private EditText nombre;
    private EditText password;
    private Activity activity;

    public PressLogin(EditText nombre, EditText password, Activity activity){
        this.nombre = nombre;
        this.password = password;
        this.activity = activity;
    }

    @Override
    public void onClick(View view) {
        String nombre = this.nombre.getText().toString();
        String password = this.password.getText().toString();
        new Thread(new Loger(this.nombre, this.password, view, this.activity)).start();
    }
}
