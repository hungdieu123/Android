package vn.lab2.coban;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class SubActivity extends AppCompatActivity {
    private ListView lvlistview;
    private String[] student = {"Trương Việt Hùng","Nguyễn Hoài Sơn","Phan Ngọc Khánh","Lý Bảo Long","Trương Lâm Dương","Trương Việt Hùng","Nguyễn Hoài Sơn","Phan Ngọc Khánh","Lý Bảo Long","Trương Lâm Dương","Trương Việt Hùng","Nguyễn Hoài Sơn","Phan Ngọc Khánh","Lý Bảo Long","Trương Lâm Dương","Trương Việt Hùng","Nguyễn Hoài Sơn","Phan Ngọc Khánh","Lý Bảo Long","Trương Lâm Dương","Trương Việt Hùng","Nguyễn Hoài Sơn","Phan Ngọc Khánh","Lý Bảo Long","Trương Lâm Dương","Trương Việt Hùng","Nguyễn Hoài Sơn","Phan Ngọc Khánh","Lý Bảo Long","Trương Lâm Dương",};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);
        lvlistview = findViewById(R.id.lvlistview);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(SubActivity.this,android.R.layout.simple_list_item_1,student);
        lvlistview.setAdapter(arrayAdapter);

    }
}
