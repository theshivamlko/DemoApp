package in.shivam.navoki.demoapp;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class ViewExample2 extends Activity {

    Context context;
    private ProgressBar progressBar;
    private ProgressBar progressBar2;
    private SeekBar seekBar;
    private SeekBar seekBar2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_example2);

        Spinner spinner=(Spinner)findViewById(R.id.spr2);
        Spinner spinner2=(Spinner)findViewById(R.id.spr3);
        RatingBar ratingBar=(RatingBar) findViewById(R.id.ratingBar);
        context=this;

        Log.e("MSG",ratingBar.getNumStars()+"");
        seekBar = (SeekBar) findViewById(R.id.seekBar);
        seekBar2 = (SeekBar) findViewById(R.id.seekBar2);


        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        progressBar2 = (ProgressBar) findViewById(R.id.progressBar2);

        ArrayList<String> list=new ArrayList<>();
        list.add("INDIA");
        list.add("AUSTRALIA");
        list.add("AFRICA");
        list.add("CANADA");

        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(context,android.R.layout.simple_spinner_dropdown_item,list);
        spinner.setAdapter(arrayAdapter);

       ArrayAdapter<String> arrayAdapter2=new ArrayAdapter<String>(context,R.layout.spinnertext,R.id.textView,list);
        spinner2.setAdapter(arrayAdapter2);

        Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(context,"TASK COMPLETE",Toast.LENGTH_SHORT).show();
                progressBar.setVisibility(View.GONE);
                progressBar2.setProgress(3000);

            }
        },6000);


        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                Log.e("MSG",""+i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Log.e("MSG","START");

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Log.e("MSG","STOP");

            }
        });
    }
}
