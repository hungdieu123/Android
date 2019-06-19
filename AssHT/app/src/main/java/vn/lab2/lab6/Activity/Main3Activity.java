package vn.lab2.lab6.Activity;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import vn.lab2.lab6.Adapter.StudentAdapter;
import vn.lab2.lab6.Model.Classs;
import vn.lab2.lab6.Model.Student;
import vn.lab2.lab6.R;
import vn.lab2.lab6.Sqllite.ClassDAO;

public class Main3Activity extends AppCompatActivity {

    private ClassDAO classDAO;
    private List<Classs> studentList;

    private AlertDialog alertDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.roww);
        classDAO =new ClassDAO(Main3Activity.this);

    }

    public void themlop(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View dialog  = LayoutInflater.from(this).inflate(R.layout.giaodien,null);
        builder.setView(dialog);

        final EditText edtmalop;
        final EditText edttenlop;
        Button btnxoatrang;
        Button btnluulop;


        edttenlop = dialog.findViewById(R.id.edttenlop);
        edtmalop = dialog.findViewById(R.id.edtmalop);
        btnxoatrang = dialog.findViewById(R.id.btnxoatrang);
        btnluulop = dialog.findViewById(R.id.btnluulop);

        btnluulop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                classDAO =new ClassDAO(Main3Activity.this);
                String malop = edtmalop.getText().toString().trim();
                String tenlop = edttenlop.getText().toString().trim();


                if (malop.equals("")){
                    Toast.makeText(Main3Activity.this,"Vui Lòng Nhập Mã Lớp!",Toast.LENGTH_SHORT).show();
                }else if (tenlop.equals("")){
                    Toast.makeText(Main3Activity.this,"Vui Lòng Nhập Tên Lớp!",Toast.LENGTH_SHORT).show();
                }else {
                    Classs classs = new Classs();
                    classs.malop = malop;
                    classs.tenlop = tenlop;

                    long result = classDAO.insertStudent(classs);


                    if (result > 0) {

                        Toast.makeText(Main3Activity.this, "Thêm Thành Công!", Toast.LENGTH_SHORT).show();
                        alertDialog.dismiss();


                    } else {

                        Toast.makeText(Main3Activity.this, "Thêm Không Thành Công!", Toast.LENGTH_SHORT).show();

                    }
                }
            }
        });
        btnxoatrang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtmalop.setText("");
                edttenlop.setText("");
            }
        });


        builder.create();
        alertDialog = builder.show();



    }

    public void danhsachsinhvien(View view) {
        Intent intent = new Intent(Main3Activity.this, Main2Activity.class);
        startActivity(intent);
    }

    public void Quanlysinhvien(View view) {
        Intent intent = new Intent(Main3Activity.this, MainActivity.class);
        startActivity(intent);
    }
}
