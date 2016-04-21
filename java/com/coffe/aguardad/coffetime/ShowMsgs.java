package com.coffe.aguardad.coffetime;


import android.app.Activity;
import android.view.View;

public class ShowMsgs implements View.OnClickListener{

    String user;
    private Activity activity;

    public ShowMsgs(String user, Activity activity){
        this.activity = activity;
        this.user = user;
    }

    @Override
    public void onClick(View view) {
        new Thread(new ShowMyMsgs(this.user, view, this.activity)).start();
    }
}
