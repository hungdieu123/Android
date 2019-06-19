package vn.lab2.hungd;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    @Override
    public void onStart(){
        super.onStart();
        Log.e("hi","chay vao onStart");
    }
    @Override
    public void onStop(){
        super.onStop();
        Log.e("hi","chay vao onStop");
    }
    @Override
    public void onRestart(){
        super.onRestart();
        Log.e("hi","chay vao onRestart");
    }
    @Override
    public void onDestroy(){
        super.onDestroy();
        Log.e("hi","chay vao onDestroy");
    }
    @Override
    public void onPause(){
        super.onPause();
        Log.e("hi","chay vao onPause");
    }
    @Override
    public void onResume(){
        super.onResume();
        Log.e("hi","chay vao onResume");
    }
    private EditText edtso1,edtso2;
    private TextView textdapan;
    String sothu1,sothu2,ketqua;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtso1=findViewById(R.id.edtso1);
        edtso2 = findViewById(R.id.edtso2);
        textdapan=findViewById(R.id.textdapan);

    }
    public void cong(View View){

        sothu1=edtso1.getText().toString();
        Double soa= Double.parseDouble(sothu1);
        sothu2=edtso2.getText().toString();
        Double sob= Double.parseDouble(sothu2);
        ketqua = String.valueOf(soa+sob);
        Intent intent = new Intent(this,Main2Activity.class);
        intent.putExtra("ketqua",ketqua);
        startActivity(intent);
    }
    public void tru(View View){

        sothu1=edtso1.getText().toString();
        Double soa= Double.parseDouble(sothu1);
        sothu2=edtso2.getText().toString();
        Double sob= Double.parseDouble(sothu2);
        ketqua = String.valueOf(soa-sob);
        Intent intent = new Intent(this,Main2Activity.class);
        intent.putExtra("ketqua",ketqua);
        startActivity(intent);
    }
    public void nhan(View View){

        sothu1=edtso1.getText().toString();
        Double soa= Double.parseDouble(sothu1);
        sothu2=edtso2.getText().toString();
        Double sob= Double.parseDouble(sothu2);
        ketqua = String.valueOf(soa*sob);
        Intent intent = new Intent(this,Main2Activity.class);
        intent.putExtra("ketqua",ketqua);
        startActivity(intent);
    }
    public void chia(View View){

        sothu1=edtso1.getText().toString();
        Double soa= Double.parseDouble(sothu1);
        sothu2=edtso2.getText().toString();
        Double sob= Double.parseDouble(sothu2);
        ketqua = String.valueOf(soa/sob);
        Intent intent = new Intent(this,Main2Activity.class);
        intent.putExtra("ketqua",ketqua);
        startActivity(intent);

    }


}
