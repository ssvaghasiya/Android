package com.example.application;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView lst;
    ArrayAdapter<String> adt;
    String[] str = {"C","C++","Java","Python","Android","Ruby",".NET","C#"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final RatingBar ratingBar = (RatingBar)findViewById(R.id.ratingBar);
        ratingBar.setNumStars(5);
        Button button = (Button) findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String val = String.valueOf(ratingBar.getRating());
                Toast.makeText(getApplicationContext(),val,Toast.LENGTH_SHORT).show();
            }
        });


       Toast.makeText(getApplicationContext(),"Hello Friends",Toast.LENGTH_LONG).show();
      //  toast.setMargin(50,50);

        lst = (ListView) findViewById(R.id.lstview);
         adt = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,str);
        lst.setAdapter(adt);
        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String value = adt.getItem(position);
                Toast.makeText(getApplicationContext(),value,Toast.LENGTH_SHORT).show();
            }
        });
    }
}
