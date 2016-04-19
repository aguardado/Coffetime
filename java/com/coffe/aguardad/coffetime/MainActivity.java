package com.coffe.aguardad.coffetime;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText nameBut = (EditText) findViewById(R.id.editTextUsuario);
        EditText passBut = (EditText) findViewById(R.id.editTextContraseña);

        Button logger = (Button) findViewById(R.id.buttonLog);
        logger.setOnClickListener(new PressLogin(nameBut, passBut, this));
    }

}
