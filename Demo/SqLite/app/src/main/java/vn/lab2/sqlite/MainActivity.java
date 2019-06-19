package vn.lab2.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private StudentRendersql studentRendersql;
    private TextView tvdanhsach;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvdanhsach = findViewById(R.id.tvdanhsach);
        studentRendersql = new StudentRendersql(MainActivity.this);
        Student student = new Student();
        student.id = "PH"+System.currentTimeMillis();
        student.name = "name" + System.currentTimeMillis();
        long resylt = studentRendersql.insertStudent(student);

        List<Student> studentsList =studentRendersql.gtStudents();
        Log.e("size","");

    }

    public void them(View view) {
        Student student = new Student();
        student.setId(" " + System.currentTimeMillis());
        student.setName("Hùng Việt");
        long result = studentRendersql.insertStudent(student);
        if (result >0){
            Toast.makeText(this,"Thêm Dữ Liệu Thành Công",Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this,"Thêm Dữ Liệu Thất Bại",Toast.LENGTH_SHORT).show();
        }

    }

    public void sua(View view) {
    }

    public void xoa(View view) {
    }

    public void danhsach(View view) {
        List<Student> studentList = studentRendersql.gtStudents();
        String data= "";
        for (int i=0;i<studentList.size();i++){
            data = data +" | "+studentList.get(i).getId();

        }
        tvdanhsach.setText(data);
    }
}
