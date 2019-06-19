package vn.lab2.customlistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MusicAdapter extends BaseAdapter {
    private List<Music> musicList;
    private Context context;
    public MusicAdapter(Context context,List<Music> musicList){
        this.context = context;
        this.musicList= musicList;
    }

    @Override
    public int getCount() {
        return musicList.size();
    }

    @Override
    public Object getItem(int position) {

        return musicList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.row,parent,false);
        TextView tvten = view.findViewById(R.id.tvten);
        TextView tvtime = view.findViewById(R.id.tvtime);
        Button btnplay = view.findViewById(R.id.btnplay);

        Music music = (Music) getItem(position);
        tvten.setText(music.getName());
        tvtime.setText(music.getTime());
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Helo", Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }
}
