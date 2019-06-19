package vn.poly.customlistview;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private List<Music> musicList;

    private ListView lvList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvList = findViewById(R.id.lvList);

        // khoi tao 1 mang Music Rong~
        musicList = new ArrayList<>();

        for (int i = 0; i < 15; i++) {

            Music music = new Music();

            music.setName("Em gai mua - Huong Tram " + i);
            music.setTime("04:30");


            // bo? music vao  List
            musicList.add(music);

        }


        MusicAdapter musicAdapter = new MusicAdapter(MainActivity.this, musicList);


        lvList.setAdapter(musicAdapter);


    }

    public void openNew(View view) {

//        Intent intent = new Intent(MainActivity.this, SubActivity.class);
//
//        Bundle bundle = new Bundle();
//
//        bundle.putInt("data",100);
//
//        intent.putExtra("bun",bundle);
//
//
//        startActivity(intent);

//
//        Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:0919030190"));
//        startActivity(intent);

        Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:0919030190"));
        startActivity(intent);

    }
}
