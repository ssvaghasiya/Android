package com.example.eggtimer;

import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    SeekBar seekBar;
    TextView textView;
    Button button;
    boolean controlIsActive = false;
    CountDownTimer countDownTimer;
    public void update(int second)
    {
        int minutes = (int)second/60;
        int seconds = second-minutes*60;

        String secondString = Integer.toString(seconds);

        if(seconds <=9)
        {
            secondString = "0"+secondString;
        }

        textView.setText(Integer.toString(minutes)+":"+ secondString);
    }
    public void updateCounter(View view)
    {
        if(controlIsActive==false){
            controlIsActive =true;
            seekBar.setEnabled(false);
            button.setText("STOP");
       countDownTimer = new CountDownTimer(seekBar.getProgress()*1000,1000){
           @Override
           public void onTick(long millisUntilFinished) {
               update((int)millisUntilFinished/1000);
           }

           @Override
           public void onFinish() {
               textView.setText("0:00");
               MediaPlayer mediaPlayer =  MediaPlayer.create(getApplicationContext(),R.raw.alert);
               mediaPlayer.start();
               Log.i("timer done","Finished Timer");
           }
       }.start();
    }
    else
        {
            textView.setText("0:30");
            seekBar.setProgress(30);
            button.setText("GO!");

            seekBar.setEnabled(true);
            countDownTimer.cancel();
            controlIsActive = false;

        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seekBar =(SeekBar)findViewById(R.id.seekBar);
        button = (Button)findViewById(R.id.button);
        textView = (TextView)findViewById(R.id.textView);

        seekBar.setMax(600);
        seekBar.setProgress(30);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

               update(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
