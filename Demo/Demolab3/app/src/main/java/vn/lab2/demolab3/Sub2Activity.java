package vn.lab2.demolab3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Sub2Activity extends AppCompatActivity {
    private EditText edtA,edtB,edtC;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub2);
        edtA=findViewById(R.id.edtA);
        edtB=findViewById(R.id.edtB);
        edtC=findViewById(R.id.edtC);

    }
    public void giaiPt(View view){

        String KQ;
        String sa=edtA.getText().toString();
        String sb=edtB.getText().toString();
        String sc=edtC.getText().toString();

        Intent intent =new Intent(Sub2Activity.this,Sub3Activity.class);
        if(sa.equals("") || sb.equals("") ||sc.equals("")){
            Toast toast=Toast.makeText(Sub2Activity.this,"Nhập đủ dữ liệu",Toast.LENGTH_SHORT);
            toast.show();
        }else{
            double a=Double.parseDouble(sa);
            double b=Double.parseDouble(sb);
            double c=Double.parseDouble(sc);

            if(a==0){
                if(b==0){
                    if(c==0){
                        KQ="Phương trình vô số nghiệm";
                        intent.putExtra("kq",KQ);
                    }else{
                        KQ="Phương trình vô nghiệm";
                        intent.putExtra("kq",KQ);
                    }
                }else{
                    KQ="Phương trình có 1 nghiệm   "+String.valueOf(-c/b);
                    intent.putExtra("kq",KQ);
                }
            }else{
                double delta=b*b-4*a*c;
                if(delta<0){
                    KQ="Phương trình vô nghiệm";
                    intent.putExtra("kq",KQ);
                }else if(delta==0){
                    KQ="X : " +String.valueOf(-b/(2*a));
                    intent.putExtra("kq",KQ);
                }else{
                    KQ="X1 : "+String.valueOf((-b+Math.sqrt(delta))/(2*a))+"\n"+"X2 : "+String.valueOf((-b-Math.sqrt(delta))/(2*a));
                    intent.putExtra("kq",KQ);
                }
            }

        }


        startActivity(intent);

    }
}
