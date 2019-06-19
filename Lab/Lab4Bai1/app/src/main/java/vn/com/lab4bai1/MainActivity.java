package vn.com.lab4bai1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText edtSoA,edtSoB;
    private Button btnKQ;
    public static final String Bundle = "bundle";
    public static final String boichung = "bc";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtSoA=findViewById(R.id.edtSoA);
        edtSoB=findViewById(R.id.edtSoB);
    }

    public void timBC(View view) {
        String soA,soB;
        soA=edtSoA.getText().toString();
        soB=edtSoB.getText().toString();

        double a=Double.parseDouble(soA);
        double b=Double.parseDouble(soB);
        double bc=0;

        for(double i=a;i<a*b;i+=a){
            if(i%a==0 && i%b==0){
                bc=i;
                break;
            }
        }
        Intent intent = new Intent(MainActivity.this, SubActivity.class);



        Bundle bundle = new Bundle();
        bundle.putString(boichung,String.valueOf(bc));
        intent.putExtra(Bundle,bundle);

        startActivity(intent);




    }
}
