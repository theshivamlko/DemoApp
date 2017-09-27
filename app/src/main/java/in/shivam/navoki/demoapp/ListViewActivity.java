package in.shivam.navoki.demoapp;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;

import java.util.ArrayList;

public class ListViewActivity extends Activity {
    private ListView listview;
    private GridView gridView;

    Context c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
c=this;

        listview = (ListView) findViewById(R.id.listview);
        gridView = (GridView) findViewById(R.id.gridview);

        ArrayList<String> list=new ArrayList<>();
        list.add("INDIA");
        list.add("AUSTRALIA");
        list.add("AFRICA");
        list.add("CANADA");
        list.add("AMERICA");
        list.add("TOKYO");
        list.add("GERMANY");
        list.add("LONDON");
        list.add("RUSSIA");
         list.add("INDIA");
        list.add("AUSTRALIA");
        list.add("AFRICA");
        list.add("CANADA");
        list.add("AMERICA");
        list.add("TOKYO");
        list.add("GERMANY");
        list.add("LONDON");
        list.add("RUSSIA");
         list.add("INDIA");
        list.add("AUSTRALIA");
        list.add("AFRICA");
        list.add("CANADA");
        list.add("AMERICA");
        list.add("TOKYO");
        list.add("GERMANY");
        list.add("LONDON");
        list.add("RUSSIA");
         list.add("INDIA");
        list.add("AUSTRALIA");
        list.add("AFRICA");
        list.add("CANADA");
        list.add("AMERICA");
        list.add("TOKYO");
        list.add("GERMANY");
        list.add("LONDON");
        list.add("RUSSIA");


        ArrayAdapter<String> adapter=new ArrayAdapter<String>(c,R.layout.spinnertext,R.id.textView,list);
        listview.setAdapter(adapter);
        gridView.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.e("POSITION",i+" CLICKED");
            }
        });

    }
}
