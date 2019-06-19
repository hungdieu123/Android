package vn.lab2.demolist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView lvlist;
    private List<Student> studentList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvlist = findViewById(R.id.lvlist);
        studentList = new ArrayList<>();
        for (int i = 0;i<20;i++){
            Student student
                    = new Student();
            student.setName("Trương Lâm Dương");
            student.setSdt("10.000.000 " + i);
            student.setDiachi("Ph" + System.currentTimeMillis());

            studentList.add(student);

        }
        StudentAdapter studentAdapter = new StudentAdapter(MainActivity.this,studentList);
        lvlist.setAdapter(studentAdapter);
    }
}
