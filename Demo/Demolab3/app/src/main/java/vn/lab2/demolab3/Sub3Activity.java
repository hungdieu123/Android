package vn.lab2.demolab3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Sub3Activity extends AppCompatActivity {
    private TextView tvKQ;
    private String kq;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub3);
        tvKQ=findViewById(R.id.tvKQ);
        kq=getIntent().getStringExtra("kq");
        tvKQ.setText(kq);
    }
}
