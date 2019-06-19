package vn.lab2.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class StudentRendersql extends SQLiteOpenHelper {
    public static final String TABLE_NAME = "Student";
    public static final String COL_ID = "id";
    public static final String COL_NAME = "name";

    public StudentRendersql(Context context) {
        super(context, "student.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //cÂU LỆNH TẠO BẢNG
        //Tạo Bảng
        String create_table = "CREATE TABLE " + TABLE_NAME + "  (" + COL_ID + " TEXT PRIMARY KEY," + COL_NAME + "  TEXT)";

        db.execSQL(create_table);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //NÂNG CẤP BẢNG !!

    }

    public long insertStudent(Student student) {
        //Xin quyền
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_ID, student.id);
        contentValues.put(COL_NAME, student.name);
        long result = sqLiteDatabase.insert(TABLE_NAME, null, contentValues);
        sqLiteDatabase.close();
        return result;


    }

    public List<Student> gtStudents() {
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        List<Student> students = new ArrayList<>();
        String truyvan = "SELECT * FROM " + TABLE_NAME;
        Cursor cursor = sqLiteDatabase.rawQuery(truyvan, null);
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                Student student = new Student();
                student.id = cursor.getString(cursor.getColumnIndex(COL_ID));
                student.name = cursor.getString(cursor.getColumnIndex(COL_NAME));


                students.add(student);
cursor.moveToNext();
            }
            cursor.close();
        }
        return students;
    }
    public void dellstudent(String id){
        SQLiteDatabase sqLiteDatabase =this.getWritableDatabase();
        sqLiteDatabase .delete(TABLE_NAME,COL_ID + "=?",new String[]{id});

    }
    public long updateStudents(Student student){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_ID, student.id);
        contentValues.put(COL_NAME, student.name);
        long result = sqLiteDatabase.update(TABLE_NAME,contentValues,COL_ID + "=?",new String[]{student.id});
        sqLiteDatabase.close();
        return result;

    }
}
