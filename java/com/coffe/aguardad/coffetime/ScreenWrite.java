package com.coffe.aguardad.coffetime;

import android.app.Activity;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ScreenWrite implements Runnable{

    String message;
    Activity activity;

    public ScreenWrite(String message, Activity activity){
        this.message = message;
        this.activity = activity;
    }

    @Override
    public void run() {
        String tokens[] = message.split("]");

        String content = tokens[0];
        String usuario = tokens[1];

        message = usuario + " dice: " + content;

        LinearLayout Linear = (LinearLayout)activity.findViewById(R.id.showMsgs);
        TextView textV = new TextView(activity);
        textV.setText(message);
        Linear.addView(textV);
    }
}
