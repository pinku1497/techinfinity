package com.example.myapplication.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.myapplication.Model.ViewStudentResult;
import com.example.myapplication.R;

import java.util.List;

public class StudentDataAdapter extends BaseAdapter
{
    Context context;
    List<ViewStudentResult> list;
    LayoutInflater layoutInflater;
    public StudentDataAdapter(Context context,List<ViewStudentResult> list)
    {
        this.context=context;
        this.list=list;
        layoutInflater=LayoutInflater.from(context);

    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        ViewStudentResult d1 = list.get(i);
        View v = layoutInflater.inflate(R.layout.row_studentdetails,null);
        TextView t1= v.findViewById(R.id.s_name);
        TextView t2= v.findViewById(R.id.s_course);

        t1.setText(d1.getName());
        t2.setText(d1.getCourse());
        return v;
    }
}
