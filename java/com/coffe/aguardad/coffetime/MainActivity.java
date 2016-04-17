package com.coffe.aguardad.coffetime;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.net.UnknownHostException;

public class MainActivity extends AppCompatActivity {
    private static final int NMAX = 2;

    private static Socket clientSocket;
    private static DataOutputStream out;
    private static DataInputStream in;
    private TextView[] myTextView = new TextView[NMAX];
    private EditText[] myEditText = new EditText[NMAX];

    private Button buttonLogin;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        sendIfoToServer();
    }

    public void sendMsg(String msg){
        try{
            int longitud = msg.length();
            out.writeInt(longitud);
            byte buf[] = msg.getBytes("UTF-8");

            out.write(buf, 0, buf.length);
            out.flush();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void sendNameUser(){
        try{
            String msg = myEditText[0].getText().toString();
            out.writeByte(Msg.USER);
            sendMsg(msg);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void sendPasswordUser(){
        try{
            String msg = myEditText[1].getText().toString();
            out.writeByte(Msg.PSWD);
            Log.d("PASWORD ALBA", "COFFE");
            sendMsg(msg);
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public void sendIfoToServer()  {
        int time = Toast.LENGTH_SHORT;
        Toast msg = Toast.makeText(this, "Coffe Time", time);
        msg.show();

        this.myTextView[0] = (TextView)this.findViewById(R.id.textViewUsuario);
        this.myTextView[1] = (TextView)this.findViewById(R.id.textViewConstraseña);

        this.myEditText[0] = (EditText)this.findViewById(R.id.editTextUsuario);
        this.myEditText[1] = (EditText)this.findViewById(R.id.editTextContraseña);

        this.buttonLogin = (Button)this.findViewById(R.id.buttonLog);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Thread threadCoffe = new Thread() {
                    @Override
                    public void run() {
                        out = null;
                        try {
                            clientSocket = new Socket("10.0.2.2", 8080);
                            in = new DataInputStream(clientSocket.getInputStream());
                            out = new DataOutputStream(clientSocket.getOutputStream());

                            sendNameUser();
                            sendPasswordUser();

                        } catch (UnsupportedEncodingException e) {
                            e.printStackTrace();
                        } catch (UnknownHostException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        } finally {
                            if (out != null) {
                                try {
                                    out.close();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }
                };
                threadCoffe.start();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        /*switch (id){
            case R.id.loginMenu:
                Intent goRgbActivity = new Intent(MainActivity.this, LoginActivity.class);
                this.startActivity(goRgbActivity);//para conectar una activity con la otra
                break;

            default:
                break;
        }*/
        return super.onOptionsItemSelected(item);
    }

}
