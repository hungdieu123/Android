package vn.lab2.lab6.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatSpinner;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import vn.lab2.lab6.Adapter.MySpinnerAdapter;
import vn.lab2.lab6.Adapter.StudentAdapter;
import vn.lab2.lab6.Adapter.StudentAdapter2;
import vn.lab2.lab6.Model.Classs;
import vn.lab2.lab6.Model.Student;
import vn.lab2.lab6.R;
import vn.lab2.lab6.Sqllite.ClassDAO;
import vn.lab2.lab6.Sqllite.StudentDAO;

public class MainActivity extends AppCompatActivity {

    private EditText edtname;
    private EditText edtprice;
    private List<Classs> classsListt;
    private StudentDAO studentDAO;
    private ListView lvList;
    private StudentAdapter2 studentAdapter2;
    private AppCompatSpinner spclass;

    private ClassDAO classDAO;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtname = findViewById(R.id.edtname);
        spclass = findViewById(R.id.spspinner);
        edtprice = findViewById(R.id.edtprice);
        lvList = findViewById(R.id.lvList);
        spclass=findViewById(R.id.spspinner);

        //List<Classs> classsList = new ArrayList<>();
        //Classs classs = new Classs();
        //classs.tenlop = "Seclect One";
        //classs.malop ="__Secect-One__";
        //classsListt.add(0,classs);


        studentDAO =new StudentDAO(MainActivity.this);
        List<Student> studentList=studentDAO.getAllStudents();
        studentAdapter2=new StudentAdapter2(MainActivity.this,studentList);
        lvList.setAdapter(studentAdapter2);




        classDAO=new ClassDAO(MainActivity.this);
        final List<Classs> classsListt=classDAO.getAllStudents();
        MySpinnerAdapter mySpinerAdapter=new MySpinnerAdapter(classsListt,MainActivity.this);
        spclass.setAdapter(mySpinerAdapter);

    }

    public void them(View view) {

        studentDAO =new StudentDAO(MainActivity.this);


        String name = edtname.getText().toString().trim();
        String price = edtprice.getText().toString().trim();


        if (name.equals("")){

            Toast.makeText(this,"Vui Lòng Nhập Name!",Toast.LENGTH_SHORT).show();
        }else if (price.equals("")){
            Toast.makeText(this,"Vui Lòng Nhập Ngày Sinh!",Toast.LENGTH_SHORT).show();
        }else {
            Student student = new Student();

            student.ten = name;
            student.ngaysinh = price;
            long result = studentDAO.insertStudent(student);


            List<Student> studentList=studentDAO.getAllStudents();
            studentAdapter2 = new StudentAdapter2(MainActivity.this,studentList);
            lvList.setAdapter(studentAdapter2);



            if (result > 0) {

                Toast.makeText(this, "Thêm Thành Công!", Toast.LENGTH_SHORT).show();

            } else {

                Toast.makeText(this, "Thêm Không Thành Công!", Toast.LENGTH_SHORT).show();

            }
        }
    }




}
