package vn.com.lab5bai2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Student> studentList;
    private ListView lvList;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvList=findViewById(R.id.lvList);

        studentList=new ArrayList<>();

        studentList.add(new Student("sv01","Híu","888",R.drawable.a1));
        studentList.add(new Student("sv02","Thùy","vô giá",R.drawable.a2));
        studentList.add(new Student("sv03","Đức Anh","000",R.drawable.a3));

        StudentAdapter studentAdapter=new StudentAdapter(MainActivity.this,studentList);
        lvList.setAdapter(studentAdapter);

    }
}
