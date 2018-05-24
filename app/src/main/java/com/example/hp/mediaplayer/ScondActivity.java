package com.example.hp.mediaplayer;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ScondActivity extends AppCompatActivity {
    private TextView textView ;
    private Button playButton ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scond);

        // if it invoked by notification for mainactiviy .
        Intent intent = getIntent();

        if(intent!=null){
            // get String for intent .
            final String intentString = intent.getStringExtra("word");

            //reference the content of xml layout .
            textView = (TextView) findViewById(R.id.tv_anonce);
            playButton = (Button) findViewById(R.id.bt_play);

            playButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(!intentString.equals("")){
                        textView.setText(intentString);
                    }
                }
            });

        }


    }

}
