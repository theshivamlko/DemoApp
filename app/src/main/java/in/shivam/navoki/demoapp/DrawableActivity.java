package in.shivam.navoki.demoapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DrawableActivity extends Activity {
    private Button button14;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawable);

        button14 = (Button) findViewById(R.id.button14);

        SingletonClass singletonClass=SingletonClass.getInstance();
        singletonClass.var=10;

        button14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(DrawableActivity.this,IntentActivity.class);
                startActivity(intent);
            }
        });


        // Singleton
//   Abc obj=new Abc();
        // obj2=new ABC();

        // object


 // .SVG     .9.png



    }
}
