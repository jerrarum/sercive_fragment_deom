package com.example.hp.mediaplayer;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private EditText namesEditText ;
    private Button addToList ;
    private Button startService ;
    private ArrayList<String> names ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //resive from service .
        IntentFilter filter = new IntentFilter();
        filter.addAction(MyService.dowenloder);
        registerReceiver(new Resiver(),filter);



        namesEditText = (EditText) findViewById(R.id.et_names);

        addToList = (Button) findViewById(R.id.bt_addTolist);

        startService = (Button) findViewById(R.id.bt_service);

        names = new ArrayList<String>();

        addToList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = namesEditText.getText().toString() ;
                if(!name.equals("")){
                    names.add(name);
                    namesEditText.setText("");
                    Log.i("this", "onClick: "+name);
                }

            }
        });





        // start service after click service button .
        startService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(names != null){
                    Intent intent = new Intent(MainActivity.this,MyService.class);

                    intent.putExtra("list",names);
                    intent.putExtra("time",400);
                    startService(intent);
                    names.clear();

                }
            }
        });




    }



     // win user click on next button open activity third .
    public void click(View view) {
        Intent intent = new Intent(this,ThirdActivity.class);
        startActivity(intent);
    }

    public class  Resiver extends BroadcastReceiver {


        @Override
        public void onReceive(Context context, Intent intent) {

            String words = intent.getStringExtra("resualt");

            notification("finsh",words,getApplicationContext());

        }
    }

    // this method get title and text as string and send notification to user .
    public  void notification(String title , String text,Context context){

        Notification.Builder builder = new Notification.Builder(context);

        builder.setContentTitle(title);
        builder.setContentText(text);
        builder.setAutoCancel(true);
        builder.setSmallIcon(R.drawable.ic_feedback_black);

        // create intent to make notification clickable .
        Intent intent = new Intent(this,ScondActivity.class);
        intent.putExtra("word","fuck you man ");
        PendingIntent pendingIntent = PendingIntent.getActivity(this,0,intent,0);
        builder.setContentIntent(pendingIntent);

        // create a notification object .
        Notification notification = new Notification();

        // set notification .
        notification = builder.build();

        // get notification manager .
        NotificationManager manager = (NotificationManager) getSystemService(context.NOTIFICATION_SERVICE);



        manager.notify(23,notification);



    }


}
