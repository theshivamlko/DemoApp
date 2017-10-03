package in.shivam.navoki.demoapp;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class TemporaryStorage extends Activity {
    private EditText edit;
    String s;

    private Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temporary_storage);
        // File
        // Sharedpreferences, SQLite
        edit = (EditText) findViewById(R.id.edit);
        b1 = (Button) findViewById(R.id.b1);
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
}
