package in.shivam.navoki.demoapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class Recievers extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.e("MSG","RECIEVED");
        Toast.makeText(context,"AIRPLANE MODE WAS ON, IT WILL SAVE BATTERY",Toast.LENGTH_SHORT).show();

        Intent intent1=new Intent("ABCDEF");
        context.sendBroadcast(intent1);
    }
}
