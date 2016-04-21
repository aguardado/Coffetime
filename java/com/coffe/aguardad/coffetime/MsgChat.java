package com.coffe.aguardad.coffetime;


import android.app.Activity;
import android.view.View;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.net.UnknownHostException;

public class MsgChat implements Runnable{

    String nameUser;
    String userDest;
    String msg;
    View view;
    Activity activity;

    public MsgChat(String nameUser, String userDest, String msg, View view, Activity activity){
        this.nameUser = nameUser;
        this.userDest = userDest;
        this.msg = msg;
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

            out.writeByte(Msg.CHAT);
            longitud = this.nameUser.length();
            out.writeInt(longitud);
            out.write(this.nameUser.getBytes("UTF-8"));

            longitud = this.userDest.length();
            out.writeInt(longitud);
            out.write(this.userDest.getBytes("UTF-8"));

            longitud = this.msg.length();
            out.writeInt(longitud);
            out.write(this.msg.getBytes("UTF-8"));


            byte request = in.readByte();
            switch (request){
                case Msg.OK:
                    view.post(new MostrarToast("Mensaje enviado correctamente!", this.activity));
                    break;
                case Msg.ERROR:
                    view.post(new MostrarToast("Error al enviar mensaje, compruebe que el nombre del destinatario es correcto", this.activity));
                    break;
                case Msg.USERS_EQUALS:
                    view.post(new MostrarToast("Error al enviar el mensaje, no es posible enviar un mensaje a uno mismo", this.activity));
                    break;
                default:
                    System.err.println("ERROR: this mesage dont exist");
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
