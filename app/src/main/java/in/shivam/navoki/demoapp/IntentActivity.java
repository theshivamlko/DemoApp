package in.shivam.navoki.demoapp;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.net.URI;

public class IntentActivity extends Activity {
    private TextView text;
    private Button button8;
    Context context;
    private Button button9;
    private Button button10;
    private Button button11;
    private Button button12;
    private Button button13;

int sum=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent);

        text = (TextView) findViewById(R.id.text);
        button8 = (Button) findViewById(R.id.button8);
        button9 = (Button) findViewById(R.id.button9);
        button10 = (Button) findViewById(R.id.button10);
        button11 = (Button) findViewById(R.id.button11);
        button12 = (Button) findViewById(R.id.button12);
        button13 = (Button) findViewById(R.id.button13);

        context=this;
        Log.e("MSG","SUM "+sum);


        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context,IntentActivity2.class);
                intent.putExtra("name","RAVI");
                intent.putExtra("roll",256);
                intent.putExtra("present",true);

                Bundle bundle=new Bundle();
                bundle.putBoolean("present",true);
                bundle.putString("name","RAM");
                bundle.putInt("roll",25);

                intent.putExtra("data",bundle);

                startActivity(intent);
            }
        });


        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context,IntentActivity2.class);
                intent.putExtra("name","RAVI");
                intent.putExtra("roll",256);
                intent.putExtra("present",true);

                Bundle bundle=new Bundle();
                bundle.putBoolean("present",true);
                bundle.putString("name","RAM");
                bundle.putInt("roll",25);

                intent.putExtra("data",bundle);

                startActivityForResult(intent,1);
            }
        });

    button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context,IntentActivity3.class);
                intent.putExtra("name","SHYAM");
                intent.putExtra("roll",12);
                intent.putExtra("present",true);
// explicit
                Bundle bundle=new Bundle();
                bundle.putBoolean("present",true);
                bundle.putString("name","RAM21");
                bundle.putInt("roll",256);

                intent.putExtra("data",bundle);

                startActivityForResult(intent,2);
            }
        });

    button11.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent=new Intent(Intent.ACTION_VIEW,Uri.parse("http://www.facebook.com"));
            startActivity(intent);

        }
    });

    button12.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent=new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");
            intent.putExtra(Intent.EXTRA_SUBJECT,"My New App");
            intent.putExtra(Intent.EXTRA_TEXT,"Intall my app with this link");
            startActivity(Intent.createChooser(intent,"Share my App"));

        }
    });


    button13.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
               //  19                     // 23
            //  OS verison  >= 23
            // 21
            if(Build.VERSION.SDK_INT  >= Build.VERSION_CODES.M ) {
                String[] permissions = {Manifest.permission.CALL_PHONE};
                requestPermissions(permissions, 1);
            }
            else {
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:+1234567898"));
                startActivity(intent);
            }
           /*
           */
        }
    });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==1 && resultCode==1)
        {
            String d=data.getStringExtra("NAME");
            Toast.makeText(context,"ACTIVTY 2",Toast.LENGTH_SHORT).show();
        }
        else if(requestCode==2)
        {
            if(resultCode==Activity.RESULT_OK)
            Toast.makeText(context,"CORRECT DATA",Toast.LENGTH_SHORT).show();
            else
            Toast.makeText(context,"WRONG DATA",Toast.LENGTH_SHORT).show();

        }
        else if(requestCode==5)
        {
            Log.e("MSG",resultCode+"");
            if(resultCode==Activity.RESULT_OK)
                Toast.makeText(context,"GPS ON",Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(context,"GPS OFF",Toast.LENGTH_SHORT).show();

        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if(requestCode==1 && grantResults[0]== PackageManager.PERMISSION_GRANTED)
        {
            Intent intent=new Intent(Intent.ACTION_CALL, Uri.parse("tel:+1234567898"));
            startActivity(intent);
        }
    }
}
