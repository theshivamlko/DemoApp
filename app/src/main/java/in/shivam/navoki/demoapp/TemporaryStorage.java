package in.shivam.navoki.demoapp;

import android.Manifest;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class TemporaryStorage extends Activity {
    private EditText edit;
    String s;

    private Button b1,b2,b3,b4;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temporary_storage);
        // File
        // Sharedpreferences, SQLite
        edit = (EditText) findViewById(R.id.edit);
        b1 = (Button) findViewById(R.id.b1);
        b2 = (Button) findViewById(R.id.b2);
        b3 = (Button) findViewById(R.id.b3);
        b4 = (Button) findViewById(R.id.b4);
         tv= (TextView) findViewById(R.id.text);
//     /sdcard/

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s = edit.getText().toString();
                if(Build.VERSION.SDK_INT>=23)
                {
                    String[] per={Manifest.permission.READ_EXTERNAL_STORAGE,Manifest.permission.WRITE_EXTERNAL_STORAGE};
                    requestPermissions(per,1);
                }
                else
                    writeFile();
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createSharedPrefernce();
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Database db=new Database(TemporaryStorage.this);
                db.insert("SHIVAM2","SCIENCE");
                db.insert("SHIVAM3","SCIENCE");
                db.insert("SHIVAM4","SCIENCE");
                db.insert("SHIVAM5","SCIENCE");
                db.insert("SHIVAM6","SCIENCE");
                db.select(5);


            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Database database=new Database(TemporaryStorage.this);
            //    database.update("MATH",2);
                database.delete(3);
            }
        });

    }


    void createSharedPrefernce()
    {
        SharedPreferences sharedPreferences=getSharedPreferences("UserData",MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("name","SHIVAM");
        editor.putBoolean("present",true);
        editor.putInt("rollNo",54);
        editor.commit();    // editor.apply();

        String s= sharedPreferences.getString("names","N/A");
        Log.e("SHARED",s);


    }

    void writeFile()
    {

        File file=new File("/sdcard/Subtitle/abc.txt");
        File file2=new File("/sdcard/Subtitle2");
      if(!file2.isDirectory())
          file2.mkdirs();

        try {
        if(!file.exists()) {
            file.createNewFile();

        }

            FileOutputStream fileOutputStream=new FileOutputStream(file);
            fileOutputStream.write(s.getBytes());
            fileOutputStream.close();


        } catch (IOException e) {
            Toast.makeText(this,"No file found",Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }

    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode==1 && grantResults[1]== PackageManager.PERMISSION_GRANTED)
        {
            writeFile();
        }
    }

    BroadcastReceiver broadcastReceiver=new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
           // Toast.makeText(context,"Broadcast2",Toast.LENGTH_SHORT).show();
            tv.setText("Task completed -broadcast was reiceved");
        }
    };

    @Override
    protected void onResume() {
        registerReceiver(broadcastReceiver,new IntentFilter("ABCDEF"));
        super.onResume();
    }

    @Override
    protected void onPause() {
        unregisterReceiver(broadcastReceiver);
        super.onPause();
    }
}
