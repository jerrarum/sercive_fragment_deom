package com.example.hp.mediaplayer;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import java.util.ArrayList;

public class MyService extends Service {
    private ArrayList<String> namesList ;
    private int time ;
    private Context context ;
    public static final String dowenloder = "the file is dowenloaded by service";
    public MyService() {
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        namesList = new ArrayList<>();

             namesList = intent.getStringArrayListExtra("list");
              time = intent .getIntExtra("time",0);
              context = getApplicationContext();
            Log.i("this", "onClick: "+namesList.toString());



        //create a thread for service .
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
            String reteur =    Utitites.binding(namesList,time);

                // broducast that finching work .
                Intent done = new Intent();

                done.putExtra("resualt",reteur);
                done.setAction(dowenloder);

                done.putExtra("fin","fnished my job");

                sendBroadcast(done);
            }
        });

        thread.start();
        Context context = getApplicationContext();



        Log.i("this", "onStartCommand: "+" fnished my job . ");
        return START_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }


}
