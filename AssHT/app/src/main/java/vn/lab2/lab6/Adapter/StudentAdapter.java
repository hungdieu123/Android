package vn.lab2.lab6.Adapter;

import android.content.Context;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import vn.lab2.lab6.Activity.Main2Activity;
import vn.lab2.lab6.Model.Classs;
import vn.lab2.lab6.Model.Student;
import vn.lab2.lab6.R;
import vn.lab2.lab6.Sqllite.ClassDAO;
import vn.lab2.lab6.Sqllite.StudentDAO;

public class StudentAdapter extends BaseAdapter {
    private Context context;
    private List<Classs> classses;
    private ClassDAO classDAO;
    private StudentAdapter studentAdapter;

    private ListView lvList;

    public StudentAdapter getStudentAdapter() {
        return studentAdapter;
    }

    public void setStudentAdapter(StudentAdapter studentAdapter) {
        this.studentAdapter = studentAdapter;
    }

    public StudentAdapter(Context context, List<Classs> classses) {
        this.context = context;
        this.classses = classses;
        this.classDAO = new ClassDAO(context);

    }
    @Override
    public int getCount() {
        return classses.size();
    }

    @Override
    public Object getItem(int position) {
        return classses.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.row, parent, false);
        TextView tvmalop = convertView.findViewById(R.id.tvmalop);
        TextView tvso = convertView.findViewById(R.id.tvso);
        TextView tvtenlop = convertView.findViewById(R.id.tvtenlop);


        final Classs classs = (Classs) getItem(position);
        tvmalop.setText(classs.malop);
        tvtenlop.setText(classs.tenlop);
        tvso.setText(position+1+"");

        tvmalop.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                classDAO.deleteSudent(classs.malop);
                notifyDataSetChanged();
                classses.remove(position);
                return false;
            }
        });



        return convertView;
    }
}
