package com.example.braintrainer;

import android.os.CountDownTimer;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int locationofcorrectposition;
    ArrayList<Integer> answer = new ArrayList<Integer>();
    Button button;
    Button button0;
    Button button1;
    Button button2;
    Button button3;
    TextView sumoftxt;
    TextView secondtxt;
    int score;
    TextView scoretxt;
    TextView resulttxt;
    int numberofQuestion;
    Button playAgain;
    ConstraintLayout constraintLayout;

    public void playAgain(View view){

        score=0;
        numberofQuestion = 0;
        secondtxt.setText("30s");
        scoretxt.setText("0/0");
        resulttxt.setText("");
        playAgain.setVisibility(View.INVISIBLE);
        questiongenerator();
        new CountDownTimer(30100,1000){
            @Override
            public void onTick(long millisUntilFinished) {
                    secondtxt.setText(String.valueOf(millisUntilFinished/1000)+"s");
            }

            @Override
            public void onFinish() {
                playAgain.setVisibility(View.VISIBLE);
                secondtxt.setText("0s");
                //resulttxt.setText("Done");
                resulttxt.setText("Your Score : "+Integer.toString(score)+"/"+Integer.toString(numberofQuestion));
            }
        }.start();
    }
    public void questiongenerator()
    {

        Random ran = new Random();

        int a= ran.nextInt(20);
        int b = ran.nextInt(20);

        sumoftxt.setText(Integer.toString(a)+"+"+Integer.toString(b));

        locationofcorrectposition = ran.nextInt(4);
        answer.clear();
        //secontxt.setText(Integer.toString(locationofcorrectposition));
        int incorrectans;
        for(int i=0;i<4;i++)
        {
            if(i==locationofcorrectposition)
            {
                answer.add(a+b);
            }
            else {
                incorrectans = ran.nextInt(41);
                while (incorrectans==a+b)
                {
                    incorrectans = ran.nextInt(41);
                }
                answer.add(ran.nextInt(41));
            }
        }
        button0.setText(Integer.toString(answer.get(0)));
        button1.setText(Integer.toString(answer.get(1)));
        button2.setText(Integer.toString(answer.get(2)));
        button3.setText(Integer.toString(answer.get(3)));
    }
    public void chooseAnswer(View view)
    {
        if(view.getTag().toString().equals(Integer.toString(locationofcorrectposition)))
        {
            score++;
            resulttxt.setText("Correct...");

        }
        else {
            resulttxt.setText("Wrong...");
        }
        numberofQuestion++;
        scoretxt.setText(Integer.toString(score)+"/"+Integer.toString(numberofQuestion));
        questiongenerator();
    }
    public void start(View view)
    {
        button.setVisibility(View.INVISIBLE);
        constraintLayout.setVisibility(View.VISIBLE);
        playAgain(findViewById(R.id.button5));
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button)findViewById(R.id.button);
         button0 = (Button)findViewById(R.id.button1);
         button1 = (Button)findViewById(R.id.button2);
         button2 = (Button)findViewById(R.id.button3);
         button3 = (Button)findViewById(R.id.button4);
         sumoftxt = (TextView)findViewById(R.id.textView3);
         secondtxt = (TextView)findViewById(R.id.textView);
         scoretxt = (TextView)findViewById(R.id.textView2);
        resulttxt = (TextView)findViewById(R.id.textView4);
        playAgain = (Button)findViewById(R.id.button5);
        constraintLayout = (ConstraintLayout)findViewById(R.id.constrainLayout);



    }
}
