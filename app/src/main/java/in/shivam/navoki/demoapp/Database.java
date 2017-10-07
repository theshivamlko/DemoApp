package in.shivam.navoki.demoapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class Database extends SQLiteOpenHelper {

    Context context; // MyDB.db

     String CREATE_TABLE="create table student(id integer primary key autoincrement,name text,subject text)";


    public Database(Context context) {
        super(context,"MyDatabase.db",null,1);
        this.context=context;


    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        Log.e("MSG","CREATE");
         sqLiteDatabase.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    // CRUD
    void insert(String name,String subject )
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("name",name);
        contentValues.put("subject",subject);
        db.insert("student",null,contentValues);
    }

    void select(int i)
    {
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery("select * from student where id="+i,null);

       while (cursor.moveToNext())
       {
           Log.e("MSG"," NAME "+cursor.getString(2));
       }
    }

    void update(String subject,int id)
    {
        SQLiteDatabase db=this.getReadableDatabase();
        select(id);
        db.execSQL("update student set subject='"+subject+"' where id="+id);
        Log.e("QUERY" ,"update student set subject='"+subject+"' where id="+id);
        select(id);

    }
  void delete(int id)
    {
        SQLiteDatabase db=this.getReadableDatabase();
        select(3);
        db.execSQL("delete from student where id="+id);
         select(id);
    }

}
