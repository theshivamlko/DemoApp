package in.shivam.navoki.demoapp;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.ColorRes;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends Activity  implements View.OnClickListener{

    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main2);

        context=getApplicationContext();

        TextView tv=(TextView) findViewById(R.id.text); // View
        tv.setText("SHIVAM as a Android Trainer,");
        tv.setTextColor(Color.GREEN);


        Button btn=(Button)findViewById(R.id.button);
        btn.setText("LOGIN");
        btn.setOnClickListener(this);


        Button btn2=(Button)findViewById(R.id.button2);
         btn2.setOnClickListener(this);

        Button btn3=(Button)findViewById(R.id.button3);
        btn3.setOnClickListener(this);



    }

    @Override
    public void onClick(View view) {

        if(view.getId()==R.id.button)
        Toast.makeText(context,"THIS IS A BUTTON",Toast.LENGTH_SHORT).show();

        else if(view.getId()==R.id.button2)
         Toast.makeText(context,"THIS IS A BUTTON 2",Toast.LENGTH_SHORT).show();

        else if(view.getId()==R.id.button3)
         Toast.makeText(context,"THIS IS A BUTTON 3",Toast.LENGTH_SHORT).show();


    }
}
