package com.example.myapplication.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.myapplication.Model.ViewTaskResult;
import com.example.myapplication.R;

import java.util.List;

public class TaskAdapter extends BaseAdapter
{
    Context context;
    List<ViewTaskResult> taskResults;
    LayoutInflater layoutInflater;
    public TaskAdapter(Context context, List<ViewTaskResult> taskResults)
    {
        this.context=context;
        this.taskResults=taskResults;
        layoutInflater=(LayoutInflater.from(context));
    }

    @Override
    public int getCount() {
        return taskResults.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        ViewTaskResult i1 = taskResults.get(position);
        View v = layoutInflater.inflate(R.layout.row_taskdetail,null);
        TextView t1= v.findViewById(R.id.row_task);
        TextView t2= v.findViewById(R.id.row_remark);


        t1.setText(i1.getTtask());
        t2.setText(i1.getTremark());
        return v;
    }
}
