package vn.lab2.lab6.Sqllite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import vn.lab2.lab6.Model.Student;

import static vn.lab2.lab6.Sqllite.StudentRender.COL_ID;
import static vn.lab2.lab6.Sqllite.StudentRender.COL_NAME;
import static vn.lab2.lab6.Sqllite.StudentRender.COL_PRICE;
import static vn.lab2.lab6.Sqllite.StudentRender.TABLE_NAME;

public class StudentDAO {
    public StudentRender studentRender;
    public StudentDAO(Context context){
    studentRender = new StudentRender(context);
    }
    public long insertStudent(Student student) {
        // xin quyen
        SQLiteDatabase sqLiteDatabase = studentRender.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_ID, student.ten);
        contentValues.put(COL_NAME, student.ngaysinh);


        // cau lenh themvao co so du lieu
        long result = sqLiteDatabase.insert(TABLE_NAME, null, contentValues);

        return result;
    }

    public List<Student> getAllStudents() {
        SQLiteDatabase sqLiteDatabase = studentRender.getReadableDatabase();

        List<Student> studentList = new ArrayList<>();
        String truyVan = "SELECT * FROM " + TABLE_NAME;
        Cursor cursor = sqLiteDatabase.rawQuery(truyVan, null);

        if (cursor.getCount() > 0) {
            cursor.moveToFirst();

            while (!cursor.isAfterLast()) {
                Student student = new Student();
                student.ten = cursor.getString(cursor.getColumnIndex(COL_ID));
                student.ngaysinh = cursor.getString(cursor.getColumnIndex(COL_NAME));


                studentList.add(student);


                cursor.moveToNext();
            }
            cursor.close();

        }

        return studentList;
    }

    public void deleteSudent(String id) {
        // xin quyen
        SQLiteDatabase sqLiteDatabase = studentRender.getWritableDatabase();
        sqLiteDatabase.delete(TABLE_NAME, COL_ID + "=?", new String[]{id});

    }

    public long updateStudent(Student student) {
        SQLiteDatabase sqLiteDatabase = studentRender.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_ID, student.ten);
        contentValues.put(COL_NAME, student.ngaysinh);

        //cau lenh them vao cs du lieu
        long result = sqLiteDatabase.update(TABLE_NAME, contentValues, COL_ID + "=?", new String[]{student.ten});

        return result;
    }
}
