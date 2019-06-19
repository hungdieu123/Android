package vn.lab2.lab6.Adapter;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import java.util.List;

import vn.lab2.lab6.Model.Classs;
import vn.lab2.lab6.R;

public class MySpinnerAdapter implements SpinnerAdapter {
    private List<Classs> classList;
    private Context context;

   public MySpinnerAdapter(List<Classs> classList,Context context){
       this.context = context;
       this.classList = classList;
    }
    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.spinner,parent,false);

        TextView tvmalop = convertView.findViewById(R.id.tvMMalop);
        tvmalop.setText(classList.get(position).malop);
        return convertView;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.vspinner,parent,false);
        TextView tvmalop = convertView.findViewById(R.id.tvMMalop);
        tvmalop.setText(classList.get(position).malop);

        return convertView;
    }



    @Override
    public int getViewTypeCount() {
        return 1;
    }

    @Override
    public int getCount() {
        return classList.size();
    }

    @Override
    public Classs getItem(int position) {
        return classList.get(position);
    }


















    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }



    @Override
    public int getItemViewType(int position) {
        return 0;
    }



    @Override
    public boolean isEmpty() {
        return false;
    }
    @Override
    public void registerDataSetObserver(DataSetObserver observer) {

    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver observer) {

    }
}
