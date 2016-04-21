package com.coffe.aguardad.coffetime;

import android.app.Activity;
import android.util.Log;
import android.view.View;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ShowMyMsgs implements Runnable{

    String user;
    View view;
    Activity activity;

    public ShowMyMsgs(String user, View view, Activity activity){
        this.user = user;
        this.view = view;
        this.activity = activity;
    }

    @Override
    public void run() {
        DataOutputStream out = null;
        DataInputStream in = null;
        int longitud;

        try {
            Socket clientSocket = new Socket("10.0.2.2", 9999);
            in = new DataInputStream(clientSocket.getInputStream());
            out = new DataOutputStream(clientSocket.getOutputStream());

            out.writeByte(Msg.GET_MSGS);
            longitud = this.user.length();
            out.writeInt(longitud);
            out.write(user.getBytes("UTF-8"));

            byte header = in.readByte();
            switch (header){
                case Msg.OK:
                    view.post(new MostrarToast("Los mensajes se han refrescado correctamente",
                            this.activity));
                    int numMsgs = in.readInt();
                    Log.d("alba", "numero de mensajes: " + numMsgs);
                    for (int i = 0; i < numMsgs; i++) {
                        int sizeMsg  = in.readInt();
                        byte[] bufMsg = new byte[sizeMsg];
                        in.read(bufMsg);
                        String newMsg = new String(bufMsg, "UTF-8");
                        Log.d("alba", "Mensaje: " + newMsg);
                        //escribir en fichero
                        activity.runOnUiThread(new ScreenWrite(newMsg, activity));
                    }

                    break;
                case Msg.ERROR:
                    view.post(new MostrarToast("No tiene mensajes nuevos", this.activity));
                    break;
                default:
                    Log.d("ALBA", "(ShowMyMsgs.java)El tipo de mensaje no existe");
                    break;
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
