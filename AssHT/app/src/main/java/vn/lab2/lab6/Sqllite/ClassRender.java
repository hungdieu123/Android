package vn.lab2.lab6.Sqllite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ClassRender extends SQLiteOpenHelper {
    public static final String TABLE_NAME = "class";
    public static final String COL_MALOP = "malop";
    public static final String COL_TENLOP = "tenlop";

    public ClassRender(Context context){
        super(context,"Class.db",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " ("+COL_MALOP+" TEXT PRIMARY KEY,"+COL_TENLOP+" TEXT)";
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
