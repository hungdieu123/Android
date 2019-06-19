package vn.com.lab3bai2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SubActivity extends AppCompatActivity {

    private TextView tvKQ;
    private String kq;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);
        tvKQ=findViewById(R.id.tvKQ);
        kq=getIntent().getStringExtra("kq");
        tvKQ.setText(kq);
    }
}
