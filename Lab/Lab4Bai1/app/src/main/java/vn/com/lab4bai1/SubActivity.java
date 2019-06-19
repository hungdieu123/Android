package vn.com.lab4bai1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SubActivity extends AppCompatActivity {

    private TextView tvKQ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);
        tvKQ=findViewById(R.id.tvKQ);

        String chuoi;
        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra(MainActivity.Bundle);
        chuoi=bundle.getString(MainActivity.boichung);
        tvKQ.setText(chuoi);
    }
}
