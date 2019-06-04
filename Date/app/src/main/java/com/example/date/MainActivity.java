package com.example.date;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button b1;
    TextView txt;
    DatePicker dp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1 = (Button)findViewById(R.id.button);
        txt = (TextView)findViewById(R.id.textView);
        dp = (DatePicker)findViewById(R.id.datePicker);

        txt.setText("Date is:"+getCurrentdate());
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt.setText("Change Date : "+getCurrentdate());
            }
        });
    }

    public String getCurrentdate()
    {
        StringBuilder builder = new StringBuilder();
        builder.append((dp.getMonth()+1)+"/");
        builder.append(dp.getDayOfMonth()+"/");
        builder.append(dp.getYear());
        return builder.toString();
    }
}
