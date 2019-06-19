package vn.lab2.lab6.Activity;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

import vn.lab2.lab6.Adapter.StudentAdapter;
import vn.lab2.lab6.Model.Classs;
import vn.lab2.lab6.Model.Student;
import vn.lab2.lab6.R;
import vn.lab2.lab6.Sqllite.ClassDAO;
import vn.lab2.lab6.Sqllite.StudentDAO;

public class Main2Activity extends AppCompatActivity {

    private ClassDAO classDAO;
    private Classs classsd;

    private ListView lvList;
    List<Classs> classsList;



    private StudentAdapter studentAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        lvList = findViewById(R.id.lvList);

        classDAO =new ClassDAO(Main2Activity.this);
        List<Classs> studentList=classDAO.getAllStudents();
        studentAdapter=new StudentAdapter(Main2Activity.this,studentList);
        lvList.setAdapter(studentAdapter);






    }

}
