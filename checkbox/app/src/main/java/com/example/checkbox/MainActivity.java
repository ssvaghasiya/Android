package com.example.checkbox;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    CheckBox pizza,dhosa;
    Button button,clsbtn;
    RadioGroup radiogrp;
    RadioButton radiobbtn;
    AlertDialog.Builder builder ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        radiogrp = (RadioGroup)findViewById(R.id.radioGroup);
        checkcheckboxstate();

        clsbtn = (Button)findViewById(R.id.button3);
        builder = new AlertDialog.Builder(this);
        clsbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                builder.setMessage("Do you want to close this app?");
                builder.setTitle("Closed...");
                builder.setCancelable(false);
                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                        Toast.makeText(getApplicationContext(),"You Choose Ok Action for alertbox",Toast.LENGTH_SHORT).show();


                    }

                });
                builder.setNegativeButton("Cancle", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                        Toast.makeText(getApplicationContext(),"You choose cancle",Toast.LENGTH_SHORT).show();
                    }
                });
            AlertDialog alert = builder.create();
            alert.setTitle("Alert");
            alert.show();
            }
        });
    }

    private void checkcheckboxstate() {

        pizza = (CheckBox) findViewById(R.id.checkBox);
        dhosa = (CheckBox) findViewById(R.id.checkBox2);
        button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuilder res = new StringBuilder();
                int total = 0;
                res.append("Selected Items");
                if(pizza.isChecked())
                {
                    res.append("\nPizza 100Rs.");
                    total+=100;
                }
                if(dhosa.isChecked())
                {
                    res.append("\nDhosa 50Rs.");
                    total+=50;
                }
                res.append("\nTotal Amount is : ");
                res.append(total);
                Toast.makeText(getApplicationContext(),res.toString(),Toast.LENGTH_LONG).show();
            }
        });
    }

    public void buttonClick(View view) {
            int selectedid = radiogrp.getCheckedRadioButtonId();
            radiobbtn = (RadioButton)findViewById(selectedid);
            if(selectedid==-1)
            {
                Toast.makeText(getApplicationContext(),"Nothing selected",Toast.LENGTH_LONG).show();
            }
            else
            {
                Toast.makeText(getApplicationContext(),radiobbtn.getText(),Toast.LENGTH_LONG).show();
            }

    }
}
