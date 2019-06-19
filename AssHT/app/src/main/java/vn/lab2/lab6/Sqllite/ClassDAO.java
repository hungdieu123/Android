package vn.lab2.lab6.Sqllite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import vn.lab2.lab6.Model.Classs;


import static vn.lab2.lab6.Sqllite.ClassRender.COL_MALOP;
import static vn.lab2.lab6.Sqllite.ClassRender.COL_TENLOP;
import static vn.lab2.lab6.Sqllite.ClassRender.TABLE_NAME;

public class ClassDAO {
    public ClassRender classRender;

    public ClassDAO(Context context){
        classRender = new ClassRender(context);
    }
    public long insertStudent(Classs classs) {
        // xin quyen
        SQLiteDatabase sqLiteDatabase = classRender.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_MALOP, classs.malop);
        contentValues.put(COL_TENLOP, classs.tenlop);


        // cau lenh themvao co so du lieu
        long result = sqLiteDatabase.insert(TABLE_NAME,null,contentValues);

        return result;
    }
    public List<Classs> getAllStudents() {
        SQLiteDatabase sqLiteDatabase = classRender.getReadableDatabase();

        List<Classs> studentList = new ArrayList<>();
        String truyVan = "SELECT * FROM " + TABLE_NAME;
        Cursor cursor = sqLiteDatabase.rawQuery(truyVan, null);

        if (cursor.getCount() > 0) {
            cursor.moveToFirst();

            while (!cursor.isAfterLast()) {
                Classs classs = new Classs();
                classs.malop = cursor.getString(cursor.getColumnIndex(COL_MALOP));
                classs.tenlop = cursor.getString(cursor.getColumnIndex(COL_TENLOP));


                studentList.add(classs);


                cursor.moveToNext();
            }
            cursor.close();

        }

        return studentList;
    }
    public void deleteSudent(String id) {
        // xin quyen
        SQLiteDatabase sqLiteDatabase = classRender.getWritableDatabase();
        sqLiteDatabase.delete(TABLE_NAME, COL_MALOP + "=?", new String[]{id});

    }
}
