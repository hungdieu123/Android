package vn.lab2.lab6.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import vn.lab2.lab6.Model.Student;
import vn.lab2.lab6.R;
import vn.lab2.lab6.Sqllite.ClassDAO;
import vn.lab2.lab6.Sqllite.StudentDAO;

public class StudentAdapter2 extends BaseAdapter {
    private Context context;
    private List<Student> students;
    private StudentDAO studentDAO;
    private  Student student;



    public StudentAdapter2(Context context, List<Student> students) {
        this.context = context;
        this.students = students;
        this.studentDAO = new StudentDAO(context);
    }
    @Override
    public int getCount() {
        return students.size();
    }

    @Override
    public Object getItem(int position) {
        return students.get(position);
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


        final Student student = (Student) getItem(position);
        tvmalop.setText(student.ten);
        tvtenlop.setText(student.ngaysinh);
        tvso.setText(position+1+"");




        tvmalop.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                studentDAO.deleteSudent(student.ten);
                students.remove(position);
                notifyDataSetChanged();
                return false;
            }
        });
        return convertView;
    }
}
