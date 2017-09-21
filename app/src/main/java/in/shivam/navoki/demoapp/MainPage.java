package in.shivam.navoki.demoapp;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainPage extends Activity{

    Context context;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);

        context=getApplicationContext();
        Button btn2=(Button)findViewById(R.id.button4);
        Button btn3=(Button)findViewById(R.id.button5);

        Button btn6=(Button)findViewById(R.id.button6);
        Button btn7=(Button)findViewById(R.id.button7);


        btn2.setOnClickListener(onClickListener);

        /*

        ABc obj=new ABC();
        new ABC();
         */
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,"CLICK 5",Toast.LENGTH_SHORT).show();
            }
        });


    }


   public void getClick(View view)
    {
        if(view.getId()==R.id.button6)
            Toast.makeText(context,"THIS IS A BUTTON 6",Toast.LENGTH_SHORT).show();

        else if(view.getId()==R.id.button7)
            Toast.makeText(context,"THIS IS A BUTTON 7",Toast.LENGTH_SHORT).show();

    }

    View.OnClickListener onClickListener=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Toast.makeText(context,"CLICK 1",Toast.LENGTH_SHORT).show();
        }
    };

    View.OnClickListener onClickListener2=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Toast.makeText(context,"CLICK 2",Toast.LENGTH_SHORT).show();
        }
    };
}
