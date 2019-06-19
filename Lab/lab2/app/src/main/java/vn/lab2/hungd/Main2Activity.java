package vn.lab2.hungd;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    private String hienthi;
    double so111;
    private TextView tvketquaa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        tvketquaa = findViewById(R.id.tvketquaa);
        hienthi=getIntent().getStringExtra("ketqua");
         so111 = Double.parseDouble(hienthi);
        if (hienthi != null){
            tvketquaa.setText(hienthi);
        }
    }
}
