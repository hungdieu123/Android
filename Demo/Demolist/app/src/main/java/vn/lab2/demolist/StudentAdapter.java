package vn.lab2.demolist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class StudentAdapter extends BaseAdapter {
    private Context context;
    private List<Student> studentList;

    public StudentAdapter(Context context, List<Student> studentList) {
        this.context = context;
        this.studentList = studentList;
    }

    @Override
    public int getCount() {
        return studentList.size();
    }

    @Override
    public Student getItem(int position) {
        return studentList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.row,parent,false);
        TextView tvname = view.findViewById(R.id.tvname);
        TextView tvsdt = view.findViewById(R.id.tvsdt);
        TextView tvdiachi = view.findViewById(R.id.tvdiachi);

        Student student = getItem(position);

        tvname.setText(student.getName());
        tvsdt.setText(student.getSdt());
        tvdiachi.setText(student.getDiachi());
        return view;
    }
}
