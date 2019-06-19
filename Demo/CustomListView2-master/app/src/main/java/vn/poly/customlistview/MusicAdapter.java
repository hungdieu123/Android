package vn.poly.customlistview;

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

    private Context context;
    private List<Music> musicList;


    // ham tao. - phuong thuc khoi tao - constructor
    public MusicAdapter(Context context, List<Music> musicList) {
        this.context = context;
        this.musicList = musicList;
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
    public View getView(final int position, View convertView, ViewGroup parent) {

        View view = LayoutInflater.from(context).inflate(R.layout.row, parent, false);

        TextView tvName = view.findViewById(R.id.tvName);

        TextView tvTime = view.findViewById(R.id.tvTime);

        Button btnPlay = view.findViewById(R.id.btnPlay);


        final Music music = (Music) getItem(position);

        tvName.setText(music.getName());
        tvTime.setText(music.getTime());

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                musicList.remove(position);
                notifyDataSetChanged();

                Toast.makeText(context, "Deleted", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}

