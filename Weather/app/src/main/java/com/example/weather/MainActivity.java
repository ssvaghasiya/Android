package com.example.weather;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    TextView textView;
    public void findweather(View view)
    {
        InputMethodManager inputMethodManager = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(editText.getWindowToken(),0);

        try {
            String urlencod = URLEncoder.encode(editText.getText().toString(), "UTF-8");

            Download task = new Download();
            task.execute("https://samples.openweathermap.org/data/2.5/weather?q=" + urlencod);
        }
        catch (UnsupportedEncodingException e)
        {
            e.printStackTrace();
            Toast.makeText(getApplicationContext(),"could not find weather",Toast.LENGTH_SHORT).show();
        }
        }

    public class Download extends AsyncTask<String,Void,String>{
        @Override
        protected String doInBackground(String... strings) {
            String result = "";
            URL url ;
            HttpURLConnection urlConnection = null;

            try{
                url = new URL(strings[0]);

                urlConnection = (HttpURLConnection)url.openConnection();

                InputStream inn = urlConnection.getInputStream();
                InputStreamReader reader = new InputStreamReader(inn);

                int data = reader.read();

                while(data!=-1)
                {
                    char current = (char)data;
                    result+=current;
                    data=reader.read();
                }
                return result;
            }
            catch (MalformedURLException e)
            {
                e.printStackTrace();
                Toast.makeText(getApplicationContext(),"could not find weather",Toast.LENGTH_SHORT).show();

            }
            catch (IOException e)
            {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            try{
                String message = "";
            JSONObject jsonObject = new JSONObject(result);

            String weatherinfo = jsonObject.getString("weather");

                JSONArray jsonArray = new JSONArray(weatherinfo);

                for(int i=0;i<jsonArray.length();i++)
                {
                    JSONObject jsonObject1 = jsonArray.getJSONObject(i);

                    String main = "";
                    String description = "";
                    main=jsonObject1.getString("main");
                    description=jsonObject1.getString("description");

                    if(main!="" && description!="")
                    {
                        message += main+":"+description+"\r\n";
                    }
                }

                if(message != "")
                {
                    textView.setText(message);
                }
                else {
                    Toast.makeText(getApplicationContext(),"could not find weather",Toast.LENGTH_SHORT).show();
                }
        }catch (JSONException e)
            {
                e.printStackTrace();
            }
        }

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText)findViewById(R.id.editText);
        textView = (TextView)findViewById(R.id.textView2);
    }
}
