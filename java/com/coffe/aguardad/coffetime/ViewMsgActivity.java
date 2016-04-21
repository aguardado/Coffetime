package com.coffe.aguardad.coffetime;

import android.content.Intent;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;


public class ViewMsgActivity extends AppCompatActivity {

    private String nombreUsuarioOnline;
    private Button refreshButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_msg);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        refreshButton = (Button) findViewById(R.id.buttonrefresh) ;

        Bundle userBundle = getIntent().getExtras();
        nombreUsuarioOnline = userBundle.getString("usuarioOnline");

        refreshButton.setOnClickListener(new ShowMsgs(nombreUsuarioOnline, this));

        //mostrar mensajes del fichero
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
            case R.id.chatsMenu:
                intent = new Intent(this.getApplicationContext(),ChatActivity.class);
                intent.putExtra("usuarioOnline", nombreUsuarioOnline);
                this.startActivity(intent);//para conectar una activity con la otra
                break;

            default:
                break;
        }


        return super.onOptionsItemSelected(item);
    }

}
