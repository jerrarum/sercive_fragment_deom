package com.example.hp.mediaplayer;

import android.content.Context;
import android.os.SystemClock;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;

public class Utitites {
    public static String binding(ArrayList<String> names , int times){
        StringBuilder stringBuilder = new StringBuilder();
        ArrayList<String> list = names ;
        int lenght = names.size();
        for (int x = 0;x < lenght;x++){
            stringBuilder.append(list.get(x)+"\n");
            SystemClock.sleep(times);

        }
        Log.i("this", "binding: "+stringBuilder.toString());
        return stringBuilder.toString()  ;
    }
}
