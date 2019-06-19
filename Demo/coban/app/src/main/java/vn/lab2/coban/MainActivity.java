package vn.lab2.coban;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText edtuser,edtpass;
    String ten,mk;
    String us = "admin";
    String pass = "admin";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtuser = findViewById(R.id.edtuser);
        edtpass = findViewById(R.id.edtpass);




    }
    public void login(View View){
        Intent intent = new Intent(MainActivity.this,SubActivity.class);
        ten = edtuser.getText().toString();
        mk = edtpass.getText().toString();
        if (ten.equals("admin")& mk.equals("admin")){
            Toast toast=Toast.makeText(MainActivity.this,"Đăng Nhập Thành Công", Toast.LENGTH_SHORT);
            toast.show();
            startActivity(intent);
        }else {
            Toast toast=Toast.makeText(MainActivity.this,"Đăng Nhập Thất Bại", Toast.LENGTH_SHORT);
            toast.show();
        }

    }
}
