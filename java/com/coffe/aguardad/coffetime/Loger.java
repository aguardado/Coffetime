package com.coffe.aguardad.coffetime;


import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Loger implements Runnable {

    EditText nombre;
    EditText pass;
    View view;
    Activity activity;

    public Loger (EditText nombre, EditText pass, View view, Activity activity){
        this.nombre = nombre;
        this.pass = pass;
        this.view = view;
        this.activity = activity;
    }

    @Override
    public void run() {
        DataOutputStream out = null;
        DataInputStream in = null;
        int loginOk;
        int longitud;
        try {
            Socket clientSocket = new Socket("10.0.2.2", 9999);
            in = new DataInputStream(clientSocket.getInputStream());
            out = new DataOutputStream(clientSocket.getOutputStream());

            out.writeByte(Msg.LOG);
            longitud = this.nombre.length();
            out.writeInt(longitud);
            out.write(nombre.getText().toString().getBytes("UTF-8"));
            longitud = this.pass.length();
            out.writeInt(longitud);
            out.write(pass.getText().toString().getBytes("UTF-8"));

            loginOk = in.readInt();
            if(loginOk == 0){
                view.post(new MostrarToast("Error al introducir usuraio o contraseña, prueba de nuevo", this.activity));
            }else{
                view.post(new GoChatUsers(this.nombre, this.activity));
            }

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
}
