package com.coffe.aguardad.coffetime;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

public class ChatActivity extends AppCompatActivity implements Runnable{

    EditText nombre;

    public ChatActivity(EditText nombre){
        this.nombre = nombre;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        /*Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);*/
    }

    @Override
    public void run() {

    }
}
