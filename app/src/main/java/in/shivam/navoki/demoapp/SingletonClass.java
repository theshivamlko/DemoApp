package in.shivam.navoki.demoapp;

import android.app.Application;
import android.content.Context;


public class SingletonClass extends Application {
    private static SingletonClass singletonClass;
    static Context context;
    public int var=3;

    @Override
    public void onCreate() {
        super.onCreate();
        context=this;
    }

    public static SingletonClass getInstance()
    {
        if(singletonClass==null)
            singletonClass=(SingletonClass)context;

        return singletonClass;

    }

}
