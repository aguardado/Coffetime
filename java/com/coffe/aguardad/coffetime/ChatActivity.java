package com.coffe.aguardad.coffetime;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

public class ChatActivity extends AppCompatActivity{

    private Button sendButton;
    private String nombreUsuarioOnline;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);


        EditText msgChat = (EditText) findViewById(R.id.editTextmsg);
        EditText userDest = (EditText) findViewById(R.id.editTextUserSendTo);
        sendButton = (Button) findViewById(R.id.buttonSend) ;

        Bundle userBundle = getIntent().getExtras();
        nombreUsuarioOnline = userBundle.getString("usuarioOnline");

        sendButton.setOnClickListener(new PressSendMsg(nombreUsuarioOnline, msgChat, userDest, this));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        Intent intent;
        switch (id){
            case R.id.myMsgs:
                intent = new Intent(this.getApplicationContext(), ViewMsgActivity.class);
                intent.putExtra("usuarioOnline", nombreUsuarioOnline);
                this.startActivity(intent);//para conectar una activity con la otra
                break;

            default:
                break;
        }


        return super.onOptionsItemSelected(item);
    }
}
