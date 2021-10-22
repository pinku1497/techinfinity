package com.example.myapplication.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.myapplication.Model.ViewIncomeResult;

import com.example.myapplication.Model.ViewStudentResult;
import com.example.myapplication.R;

import java.util.List;

public class IncomeDataAdapter extends BaseAdapter {
    Context context;
    List<ViewIncomeResult> income_list;
    LayoutInflater layoutInflater;

    public IncomeDataAdapter(Context context, List<ViewIncomeResult> income_list)
    {
        this.context=context;
        this.income_list=income_list;
        layoutInflater=LayoutInflater.from(context);
    }
    @Override
    public int getCount()
    {
        return income_list.size();
    }
    @Override
    public Object getItem(int i)
    {
        return i;
    }
    @Override
    public long getItemId(int i)
    {
        return i;
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup)
    {
        ViewIncomeResult i1 = income_list.get(i);
        View v = layoutInflater.inflate(R.layout.row_incomedetails,null);
        TextView t1= v.findViewById(R.id.row_newincome);
        TextView t2= v.findViewById(R.id.row_newamount);
        TextView t3= v.findViewById(R.id.row_incomedate);
        TextView t4= v.findViewById(R.id.row_incomeremarks);

        t1.setText(i1.getNewincome());
        t2.setText(i1.getNewamount());
        t3.setText(i1.getIncomedate());
        t4.setText(i1.getIncomeremarks());
        return v;
    }
}
