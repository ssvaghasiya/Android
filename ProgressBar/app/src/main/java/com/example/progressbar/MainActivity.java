package com.example.progressbar;

import android.app.ProgressDialog;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    ProgressBar progressBar;
    Button button;
   Handler handler = new Handler();
   TextView txt ;
    private int counter = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button  = (Button)findViewById(R.id.button);
        txt = (TextView)findViewById(R.id.textView2);
        progressBar = (ProgressBar)findViewById(R.id.progressBar2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Timer t = new Timer();
                TimerTask tt = new TimerTask() {
                    @Override
                    public void run() {
                        while (counter < 100) {
                            counter++;

                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    progressBar.setProgress(counter);
                                    txt.setText(counter+"/"+progressBar.getMax());
                                }
                            });

                            //txt.setText(counter+"/"+progressBar.getMax());
//                        if(counter==100)
//                            t.cancel();
                            try {
                                Thread.sleep(200);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                       // txt.setText("File Downloaded Successfully");
                    }
                };

                t.schedule(tt,0,100);

            }
        });


    }
}
