package vn.lab2.lab6.Sqllite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class StudentRender extends SQLiteOpenHelper {
    public static final String TABLE_NAME = "student";
    public static final String COL_ID = "id";
    public static final String COL_NAME = "name";
    public static final String COL_PRICE = "price";

   public StudentRender(Context context){
       super(context,"student.db",null,1);
   }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " ("+COL_ID+" TEXT PRIMARY KEY,"+COL_NAME+" TEXT,"+COL_PRICE+" TEXT)";
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
