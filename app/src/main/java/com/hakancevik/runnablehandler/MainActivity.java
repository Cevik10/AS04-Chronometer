package com.hakancevik.runnablehandler;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.hakancevik.runnablehandler.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    Runnable runnable;
    Handler handler;

    int number;
    Button startButton;
    Button stopButton;
    Button resetButton;
    TextView timeText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        number = 0;
        timeText = binding.timeText;
        startButton = binding.startButton;
        stopButton = binding.stopButton;
        resetButton = binding.resetButton;

    }


    public void start(View view) {

        handler = new Handler();
        runnable = new Runnable() {
            @SuppressLint("SetTextI18n")
            @Override
            public void run() {

                timeText.setText("Time (sec) : " + number);
                number++;

                handler.postDelayed(runnable, 1000); // count one second.

            }
        };

        handler.post(runnable);
        startButton.setEnabled(false);
        resetButton.setEnabled(true);
        stopButton.setEnabled(true);

    }


    public void stop(View view) {

        resetButton.setEnabled(true);
        startButton.setEnabled(true);

        handler.removeCallbacks(runnable);
        stopButton.setEnabled(false);

    }


    @SuppressLint("SetTextI18n")
    public void reset(View view) {

        handler.removeCallbacks(runnable);
        number = 0;
        timeText.setText("Time (sec) : " + number);
        resetButton.setEnabled(false);
        startButton.setEnabled(true);
        stopButton.setEnabled(false);

    }


}


