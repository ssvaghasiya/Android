package com.example.backpress;

import android.content.DialogInterface;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Spinner spinner;
    ArrayAdapter<CharSequence> arrayAdapter;
    String[] lan = {"C","C++","Java","Python","Android"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner= (Spinner) findViewById(R.id.spinner);
        arrayAdapter = ArrayAdapter.createFromResource(this,R.array.country,android.R.layout.simple_spinner_item);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getBaseContext(),parent.getItemAtPosition(position)+" Selected",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ArrayAdapter<String> adt = new ArrayAdapter<String>(this,android.R.layout.select_dialog_item,lan);
        AutoCompleteTextView act = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView);
        act.setThreshold(1);
        act.setAdapter(adt);
        act.setTextColor(Color.RED);



    }
    @Override
    public void onBackPressed(){

    AlertDialog.Builder builder = new AlertDialog.Builder(this);
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

}
