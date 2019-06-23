package com.example.tictactoe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    int rouncount;
    Button button[][] = new Button[3][3];
    TextView txt1 ;
    TextView txt2;
    boolean player2turn;
    boolean player1turn = true;
    int player1point;
    int player2point;
    Button resetButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt1 = (TextView)findViewById(R.id.text_view_p1);
        txt2 = (TextView)findViewById(R.id.text_view_p2);

        resetButton = (Button)findViewById(R.id.button_reset);
        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                player1point = 0;
                player2point=0;
                updatePoint();
                reset();
            }
        });
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                String buttonId = "button_"+i+j;
                  int id = getResources().getIdentifier(buttonId,"id",getPackageName());
                  button[i][j] = findViewById(id);
                  button[i][j].setOnClickListener(this);
            }
        }


    }

    @Override
    public void onClick(View v) {
        if(!((Button)v).getText().toString().equals(""))
        {
            return;
        }
        if(player1turn)
        {
            ((Button)v).setText("X");
        }
        else
        {
            ((Button)v).setText("O");
        }

        rouncount++;

        if(checkWin())
        {
            if(player1turn)
            {
                player1win();

            }
            else {
                player2win();
            }
        }
        else if(rouncount==9)
        {
            draw();
        }
        else {
            player1turn = !player1turn;
        }
    }

    public boolean checkWin()
    {
        String[][] check = new String[3][3];

        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                check[i][j]=button[i][j].getText().toString();

            }
        }

        for(int i=0;i<3;i++)
        {
            if(check[i][0].equals(check[i][1]) && check[i][0].equals(check[i][2]) && !check[i][0].equals("")){
                return true;
            }
        }

        for(int i=0;i<3;i++)
        {
            if(check[0][i].equals(check[1][i]) && check[0][i].equals(check[2][i]) && !check[0][i].equals("")){
                return true;
            }
        }

        if(check[0][0].equals(check[1][1]) && check[0][0].equals(check[2][2]) && !check[0][0].equals("")){
            return true;
        }

        if(check[0][2].equals(check[1][1]) && check[0][2].equals(check[2][0]) && !check[0][2].equals("")){
            return true;
        }

        return false;
    }

    private void player1win()
    {
        player1point++;
        Toast.makeText(getApplicationContext(),"Player 1 Win!",Toast.LENGTH_SHORT).show();
        updatePoint();
        reset();
    }

    private void player2win()
    {
        player2point++;
        Toast.makeText(getApplicationContext(),"Player 2 Win!",Toast.LENGTH_SHORT).show();
        updatePoint();
        reset();
    }

    private  void draw()
    {
        Toast.makeText(getApplicationContext(),"Draw!",Toast.LENGTH_SHORT).show();
        reset();
    }

    private void updatePoint()
    {
        txt1.setText("Player 1:"+player1point);
        txt2.setText("Player 2:"+player2point);
    }



    private void reset()
    {
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                button[i][j].setText("");
            }
        }
        rouncount = 0;
        player1turn = true;
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("Roundcount",rouncount);
        outState.putInt("Player1point",player1point);
        outState.putInt("Player2point",player2point);
        outState.putBoolean("Player1Turn",player1turn);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        rouncount = savedInstanceState.getInt("Roundcount");
        player1point = savedInstanceState.getInt("Player1ppoint");
        player2point =savedInstanceState.getInt("Player2point");
        player2turn = savedInstanceState.getBoolean("Player1Turn");

    }


}
