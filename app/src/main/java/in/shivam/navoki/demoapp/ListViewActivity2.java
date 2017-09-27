package in.shivam.navoki.demoapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

public class ListViewActivity2 extends Activity {
    private ListView list;

    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view2);

       // list = (ListView) findViewById(R.id.list);
        GridView gridView = (GridView) findViewById(R.id.list);
       // ImageView img = (ImageView) findViewById(R.id.img);
        context=this;
        ArrayList<String> name=new ArrayList<>();
        name.add("ABSTRACT 1");
        name.add("ABSTRACT 2");
        name.add("ABSTRACT 3");
        name.add("ABSTRACT 4");
        name.add("ABSTRACT 5");
        name.add("ABSTRACT 6");
        name.add("ABSTRACT 7");
        name.add("ABSTRACT 8");

        ArrayList<Integer> pics=new ArrayList<>();
        pics.add(R.drawable.background1);
        pics.add(R.drawable.background2);
        pics.add(R.drawable.background3);
        pics.add(R.drawable.background4);
        pics.add(R.drawable.background5);
        pics.add(R.drawable.background6);
        pics.add(R.drawable.background7);
        pics.add(R.drawable.background8);


        MyCustomAdpater myCustomAdpater=new MyCustomAdpater(context,pics,name);
      //  list.setAdapter(myCustomAdpater);
        gridView.setAdapter(myCustomAdpater);


        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                if(i==2)
                {
                    Intent intent=new Intent(context,MainPage.class);
                    startActivity(intent);
                }
            }
        });


    }
}
