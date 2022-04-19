package com.hakancevik.runnablehandler;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Runnable runnable;
    Handler handler;

    int number;
    Button buttonStart;
    Button buttonStop;
    Button buttonReset;
    TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        number = 0;
        textView = findViewById(R.id.textView);
        buttonStart = findViewById(R.id.button);
        buttonStop = findViewById(R.id.button2);
        buttonReset = findViewById(R.id.button3);

    }



    public void start(View view){

        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                textView.setText("Time (sec): "+number);
                number++;
                textView.setText("Time (sec): "+number);

                handler.postDelayed(runnable,1000); // 1 saniyede bir sayacak.

            }
        };

        handler.post(runnable);
        buttonStart.setEnabled(false);
        buttonReset.setEnabled(true);
        buttonStop.setEnabled(true);

    }


    public void stop(View view){

        buttonReset.setEnabled(true);
        buttonStart.setEnabled(true);

        handler.removeCallbacks(runnable);
        buttonStop.setEnabled(false);

    }



    public void reset(View view){

        handler.removeCallbacks(runnable);
        number=0;
        textView.setText("Time (sec): "+number);
        buttonReset.setEnabled(false);
        buttonStart.setEnabled(true);
        buttonStop.setEnabled(false);

    }


}


