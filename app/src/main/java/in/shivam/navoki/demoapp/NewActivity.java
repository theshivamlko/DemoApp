package in.shivam.navoki.demoapp;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class NewActivity extends Activity {

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("MSG","START");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);
        Log.e("MSG","CREATE");
        for (int i=0;i<1000000;i++)
        Log.e("MSG",""+i);

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("MSG","RESUME");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("MSG","PAUSE");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("MSG","STOP");

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e("MSG","RESTART");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("MSG","DESTROY");

    }
}
