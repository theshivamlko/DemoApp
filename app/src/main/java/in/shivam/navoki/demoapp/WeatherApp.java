package in.shivam.navoki.demoapp;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class WeatherApp extends Activity {
    private ImageView image;
    private TextView location;
    private TextView weather;
    private Button refresh;
    private EditText edit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_app);



        image = (ImageView) findViewById(R.id.image);
        location = (TextView) findViewById(R.id.location);
        weather = (TextView) findViewById(R.id.weather);
        refresh = (Button) findViewById(R.id.refresh);
        edit = (EditText) findViewById(R.id.edit);

        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GetData getData=new GetData();
                getData.execute();
            }
        });




    }

    class  GetData extends AsyncTask<String,String,String>
    {

        String loc;
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            loc=edit.getText().toString();

        }

        @Override
        protected String doInBackground(String... strings) {

            String response="";
            try {
                URL url=new URL("https://apteral-bay.000webhostapp.com/weather.php?country="+loc);
                Log.e("LINK","https://apteral-bay.000webhostapp.com/weather.php?country="+loc);

                HttpURLConnection httpURLConnection=(HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.setDoOutput(true);

                if (httpURLConnection.getResponseCode()==HttpURLConnection.HTTP_OK)
                {
                    BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
                    String s="";
                    while ((s=bufferedReader.readLine())!=null)
                    {
                        response=response+s;
                    }
                }

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return response;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);


            try {
                JSONObject jsonObject=new JSONObject(s);

                boolean status=jsonObject.getBoolean("status");
                if (status)
                {
                    location.setText( jsonObject.getString("location") );
                    weather.setText( jsonObject.getString("weather") );

                    String im=jsonObject.getString("image");

                    Picasso.with(WeatherApp.this).load(im).into(image); // src

                   // do some excuton
                }
                else {
                    String s2=jsonObject.getString("message");
                    Toast.makeText(WeatherApp.this,s2,Toast.LENGTH_LONG ).show();
                }


            } catch (JSONException e) {
                Log.e("MSG",e.getLocalizedMessage()+"");
                e.printStackTrace();
            }

        //    location.setText(s);
        }
    }





}
