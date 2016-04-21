package com.coffe.aguardad.coffetime;


import android.app.Activity;
import android.view.View;
import android.widget.EditText;

public class PressSendMsg implements View.OnClickListener{

    private EditText nameDest;
    private EditText msg;
    private String nameUser;
    private Activity activity;

    public PressSendMsg(String nameUser, EditText msg, EditText nameDest, Activity activity){
        this.nameUser = nameUser;
        this.nameDest = nameDest;
        this.msg = msg;
        this.activity = activity;
    }

    @Override
    public void onClick(View view) {
        String userDest = this.nameDest.getText().toString();
        String msgToSend = this.msg.getText().toString();
        nameDest.setText("");
        msg.setText("");

        new Thread(new MsgChat(this.nameUser, userDest, msgToSend, view, this.activity)).start();

    }
}
