package in.shivam.navoki.demoapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by NAVOKI on 9/27/2017.
 */

public class MyCustomAdpater extends ArrayAdapter{

    Context context2;
    ArrayList<Integer> pics2;
    ArrayList<String> names2;

    MyCustomAdpater(Context context,ArrayList<Integer> pics,ArrayList<String> names)
    {
        super(context,R.layout.item_food_menu);
        context2=context;
        pics2=pics;
        names2=names;
    }

    @NonNull
    @Override        // 0
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view=View.inflate(context2,R.layout.item_food_menu,null);
        TextView tv=(TextView)view.findViewById(R.id.text);
        ImageView img=(ImageView) view.findViewById(R.id.img);
        String name=names2.get(position);
        Integer pic=pics2.get(position);

        tv.setText(name);
        img.setBackground(ContextCompat.getDrawable(context2,pic));
        Log.e("MSG","POSITION CREATED "+position);

        return view;
    }


    @Override
    public int getCount() {
        return names2.size();
        }
        }
