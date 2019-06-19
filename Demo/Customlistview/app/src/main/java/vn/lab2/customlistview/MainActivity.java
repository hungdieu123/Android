package vn.lab2.customlistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Music> musicList;
    private ListView lvlist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        musicList = new ArrayList<>();
        lvlist = findViewById(R.id.lvlist);
        for (int i = 0;i<15;i++){
            Music music =new Music();
            music.setName("Anh chang sao ma " +i);
            music.setTime("3:30");
            musicList.add(music);
        }
        MusicAdapter musicAdapter=new MusicAdapter(MainActivity.this,musicList);
        lvlist.setAdapter(musicAdapter);
    }
}
