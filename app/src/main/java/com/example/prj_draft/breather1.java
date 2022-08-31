package com.example.prj_draft;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

public class breather1 extends AppCompatActivity {

    private static final long START_TIME_IN_MILLIS = 600000;

    private TextView viewCountDown;
    private Button start;
    private Button reset;

    private CountDownTimer countDownTimer;

    private boolean timerRunning;

    private long timeLeftInMillis = START_TIME_IN_MILLIS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breather1);

        getWindow().setBackgroundDrawableResource(R.drawable.consult_img);

        viewCountDown = findViewById(R.id.textView_countdown);
        start = findViewById(R.id.button_start);
        reset = findViewById(R.id.button2_reset);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(timerRunning){
                    pauseTimer();
                }
                else {
                    startTimer();
                }
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                resetTimer();
            }
        });

        updateCountDownText();
    }

    private void startTimer(){
        countDownTimer = new CountDownTimer(timeLeftInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeLeftInMillis = millisUntilFinished;
                updateCountDownText();
            }

            @Override
            public void onFinish() {
                timerRunning = false;

                start.setText("Start");
                //resetTimer();
                //start.setVisibility(View.INVISIBLE);
                //reset.setVisibility(View.VISIBLE);
            }
        }.start();

        timerRunning = true;
        start.setText("Pause");
        // reset.setVisibility(viewCountDown.INVISIBLE);
    }

    private void updateCountDownText(){
        int minutes = (int) (timeLeftInMillis / 1000) / 60;
        int seconds = (int) (timeLeftInMillis / 1000) % 60;

        String timeLeftFormatted = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);
        viewCountDown.setText(timeLeftFormatted);
    }

    private void pauseTimer(){
        countDownTimer.cancel();
        timerRunning = false;
        start.setText("Start");
        //  reset.setVisibility(View.VISIBLE);
    }

    private void resetTimer(){
        timeLeftInMillis = START_TIME_IN_MILLIS;
        updateCountDownText();
        // reset.setVisibility(View.INVISIBLE);
        // start.setVisibility(View.VISIBLE);
    }

    public void meditateMethod(View view) {

        Intent i = new Intent(breather1.this, meditate_links.class);
        startActivity(i);
    }

    public void exerciseMethod(View view) {

        Intent i = new Intent(breather1.this, exercise_links.class);
        startActivity(i);
    }

    public void routineMethod(View view) {

        Intent i = new Intent(breather1.this, routine_links.class);
        startActivity(i);
    }
}