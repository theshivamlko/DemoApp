package in.shivam.navoki.demoapp;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainPage extends Activity{

    Context context;
    private CheckBox checBox;
    private RadioGroup radioGroup;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);

        context=getApplicationContext();
        Button btn2=(Button)findViewById(R.id.button4);
        Button btn3=(Button)findViewById(R.id.button5);

        Button btn6=(Button)findViewById(R.id.button6);
        Button btn7=(Button)findViewById(R.id.button7);

        final EditText editText=(EditText) findViewById(R.id.ediText1);
        final EditText editText2=(EditText) findViewById(R.id.ediText2);
        checBox = (CheckBox) findViewById(R.id.checBox);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);


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


        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               String n1=editText.getText().toString();
               String n2=editText2.getText().toString();
                // "22" +"30"  ""25.2"
               int a=Integer.parseInt(n1);//
               int b=Integer.parseInt(n2);
               int sum=a+b;

               Toast.makeText(context,"Totol ="+sum,Toast.LENGTH_SHORT).show();
            }
        });


        checBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Toast.makeText(context,"STATE ="+b,Toast.LENGTH_SHORT).show();
            }
        });


        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (i == R.id.radio1)
                    Toast.makeText(context, "MALE", Toast.LENGTH_SHORT).show();
                else if (i == R.id.radio2)
                    Toast.makeText(context, "FEMALE", Toast.LENGTH_SHORT).show();

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
