package in.shivam.navoki.demoapp;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Dialogs extends Activity {

    AlertDialog alertDialog;
    AlertDialog alertDialog2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialogs);
        final ProgressDialog progressDialog=new ProgressDialog(Dialogs.this);
        progressDialog.setMessage("Loading...");
        progressDialog.setCancelable(false);

      //  progressDialog.dismiss();
        Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
              //  progressDialog.show();
            }
        },3000);


        AlertDialog.Builder builder=new AlertDialog.Builder(Dialogs.this,R.style.Theme_AppCompat_Dialog_Alert);
        builder.setTitle("Warning!");
        builder.setMessage("Rate our app");

        builder.setPositiveButton("RATE NOW", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(Dialogs.this,"OK CLICKED",Toast.LENGTH_SHORT).show();
            }
        });

        builder.setNegativeButton("NOT NOW", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                alertDialog.dismiss();
            }
        });
      builder.setNeutralButton("May be later", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                alertDialog.dismiss();
            }
        });

       alertDialog= builder.create();
       alertDialog.show();


          AlertDialog.Builder builder2=new AlertDialog.Builder(Dialogs.this,R.style.Theme_AppCompat_Dialog_Alert);

          View view=View.inflate(Dialogs.this,R.layout.dialog,null);
          Button button17;
          Button button18;

        button17 = (Button) view.findViewById(R.id.button17);
        button18 = (Button) view.findViewById(R.id.button18);

        button17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Dialogs.this,"OK CLICKED",Toast.LENGTH_SHORT).show();
                alertDialog2.dismiss();

            }
        });

        button18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Dialogs.this,"CANCEL CLICKED",Toast.LENGTH_SHORT).show();
                alertDialog2.dismiss();

            }
        });

        builder2.setView(view);


        alertDialog2= builder2.create();
       alertDialog2.show();







    }
}
