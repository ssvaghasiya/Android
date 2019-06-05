package com.example.login;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText et1;
    EditText et2;
    Button b1;
    TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1=(EditText)findViewById(R.id.editText5);
        et2 = (EditText)findViewById(R.id.editText6);
        b1 = (Button)findViewById(R.id.button);
        txt = (TextView)findViewById(R.id.textView);
        txt.setVisibility(View.INVISIBLE);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(et1.getText().toString().equals("") && et2.getText().toString().equals(""))
                {
                    txt.setVisibility(View.INVISIBLE);
                    Toast.makeText(getApplicationContext(),"Please Enter Username And Password",Toast.LENGTH_SHORT).show();
                }
                else if(et1.getText().toString().equals("admin") && et2.getText().toString().equals("savan"))
                {
                    Toast.makeText(getApplicationContext(),"SuccessFully Login",Toast.LENGTH_SHORT).show();
                    txt.setText("Successfully Login");
                    txt.setTextColor(Color.GREEN);
                    txt.setVisibility(View.VISIBLE);

                }
                else {
                    txt.setText("Incorrect Username And Password");
                    txt.setTextColor(Color.RED);
                    txt.setVisibility(View.VISIBLE);
                }
            }
        });
    }
}
