package in.shivam.navoki.demoapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class IntentActivity3 extends Activity {
    private TextView text;
    private Button button8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent2);

        text = (TextView) findViewById(R.id.text);
        button8 = (Button) findViewById(R.id.button8);

        final Intent intent=getIntent();

        String name=intent.getStringExtra("name");  // null
        int roll=intent.getIntExtra("roll",0);
        boolean attendence=intent.getBooleanExtra("present",false);

        Bundle bundle=intent.getBundleExtra("data");


        text.setText(name+" "+roll+" "+attendence+" "+bundle.getString("name"));


        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent2=new Intent();
                intent2.putExtra("NAME","SHIVAM");
                setResult(Activity.RESULT_OK,intent2);
                finish();


            }
        });





    }
}
