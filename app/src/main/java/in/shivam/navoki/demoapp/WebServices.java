package in.shivam.navoki.demoapp;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class WebServices extends Activity {
    private TextView textView2;
    private Button btn;
    private ProgressDialog progressDialog;
    private int n1=10;
    private int n2=20;
    private EditText edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_services);

        textView2 = (TextView) findViewById(R.id.textView2);
        btn = (Button) findViewById(R.id.btn);
        progressDialog=new ProgressDialog(WebServices.this);
        progressDialog.setMessage("Calculating...");

        edit = (EditText) findViewById(R.id.edit);

     //   GetData getData=new GetData();
    //    getData.execute();


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView2.setText("Hello");
                GetWeather getWeather=new GetWeather();
                getWeather.execute();
            }
        });

    }

    class GetWeather extends AsyncTask<String,String,String>
    {

        String loc;
        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            loc=edit.getText().toString();
            progressDialog.setCancelable(false);
            progressDialog.show();
        }

        @Override
        protected String doInBackground(String... strings) {
            Log.e("ASYNC","DO IN BACKGROUND");
            String s="";

            try {
                URL url=new URL("http://api.openweathermap.org/data/2.5/weather?q="+loc+"&appid=8e97e273304ebbd22ebcf4d23456b682");

                HttpURLConnection httpURLConnection=(HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("GET");   // by deafult GET       n POST
                httpURLConnection.setDoOutput(true);

                int status=httpURLConnection.getResponseCode();
                //404 page not found
                // 200 OK

                Log.e("STATUS",status+"");
                if (status==404)
                    Log.e("MSG","PAGE NOT FOUND");
                else if(status==HttpURLConnection.HTTP_OK)
                {
                    BufferedReader bufferedInputStream=new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));

                   String read="";
                    while ((read=bufferedInputStream.readLine())!=null)
                    {
                        s=s+read;
                    }
                }


            } catch (MalformedURLException e) {
                Log.e("STATUS",e.getLocalizedMessage()+"");

                e.printStackTrace();
            } catch (IOException e) {
                Log.e("STATUS",e.getLocalizedMessage()+"");

                e.printStackTrace();
            }


            return s;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Log.e("ASYNC","POSTEXECUTE "+s);

            try {
                JSONObject jsonObject=new JSONObject(s);
                String loc=jsonObject.getString("name");

                JSONObject jsonObject2=jsonObject.getJSONObject("main");
                String temp2=jsonObject2.getString("temp");

                textView2.setText(loc+" Temp: "+temp2+" F");



            } catch (JSONException e) {
                e.printStackTrace();
            }

            //   textView2.setText(s);
            progressDialog.dismiss();


        }
    }
    class GetData extends AsyncTask<String,String,String>
    {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Log.e("ASYNC","PREEXECUTE");

            progressDialog.setCancelable(false);
            progressDialog.show();
        }

        @Override
        protected String doInBackground(String... strings) {
            Log.e("ASYNC","DO IN BACKGROUND");
            int sum=n1+n2;
            try {
                Thread.sleep(5000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return sum+"";
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Log.e("ASYNC","POSTEXECUTE ");
            textView2.setText(s);
            progressDialog.dismiss();


        }
    }


    /*

    {"name":"Shivam"}
    <Student>      // XML
        <name>Shivam</name>
    </Student>


    {"name":"Shivam","location":"Gurgaon"}//JSON object
     <Student>      // XML
        <name>Shivam</name>
        <location>Gurgaon</location>
    </Student>
    //parsing data
     [{"name":"Shivam","location":"Gurgaon"},  {"name":"Vinay","location":"Delhi"}] JSON array

      <Student>      // XML
        <name>Shivam</name>
        <location>Gurgaon</location>
    </Student>
     <Student>      // XML
        <name>Vinay</name>
        <location>Delhi</location>
    </Student>




    {"data":{"name":"Shivam"}}

       {"data": [{"name":"Shivam","location":"Gurgaon"},  {"name":"Vinay","location":"Delhi"}] }



     */



}
