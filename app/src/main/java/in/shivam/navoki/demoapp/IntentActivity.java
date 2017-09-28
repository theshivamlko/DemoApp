package in.shivam.navoki.demoapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class IntentActivity extends Activity {
    private TextView text;
    private Button button8;
    Context context;
    private Button button9;
    private Button button10;
    private Button button11;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent);

        text = (TextView) findViewById(R.id.text);
        button8 = (Button) findViewById(R.id.button8);
        button9 = (Button) findViewById(R.id.button9);
        button10 = (Button) findViewById(R.id.button10);
        button11 = (Button) findViewById(R.id.button11);

        context=this;

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
           /* Intent intent=new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
            startActivityForResult(intent,5);*/

           Intent intent=new Intent(Intent.ACTION_SENDTO);
      /*     intent.putExtra(Intent.EXTRA_EMAIL,"abc@gmail.com");
           intent.putExtra(Intent.EXTRA_SUBJECT,"Complain regarding bill");*/
           startActivity(intent);
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
}
