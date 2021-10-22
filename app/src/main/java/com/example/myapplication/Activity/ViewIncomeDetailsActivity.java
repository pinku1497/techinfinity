package com.example.myapplication.Activity;

import android.content.Intent;
import android.os.Bundle;

import com.example.myapplication.API.ApiHandler;
import com.example.myapplication.Adapter.IncomeDataAdapter;
import com.example.myapplication.Adapter.StudentDataAdapter;
import com.example.myapplication.Model.ViewIncomeModel;
import com.example.myapplication.Model.ViewIncomeResult;
import com.example.myapplication.Model.ViewStudentModel;
import com.example.myapplication.Model.ViewStudentResult;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class ViewIncomeDetailsActivity extends AppCompatActivity
{
    ListView l1;
    List<ViewIncomeResult> income_list;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_income_details);

        l1=(ListView) findViewById(R.id.income_list);
        income_list = new ArrayList<>();

        Toast.makeText(ViewIncomeDetailsActivity.this,"IncomeDetails....",Toast.LENGTH_LONG).show();

        ApiHandler.getApiService().viewIncomeDetails(new Callback<ViewIncomeModel>()
        {
            @Override
            public void success(ViewIncomeModel viewIncomeModel, Response response)
            {
                income_list = viewIncomeModel.getIncomedata();

                IncomeDataAdapter income = new IncomeDataAdapter(ViewIncomeDetailsActivity.this,income_list);
                l1.setAdapter(income);
            }

            @Override
            public void failure(RetrofitError error)
            {
                Toast.makeText(ViewIncomeDetailsActivity.this,"faill",Toast.LENGTH_LONG).show();
        }
        });
        Button newincome_register =(Button) findViewById(R.id.newincome_register);
        newincome_register.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent i = new Intent(ViewIncomeDetailsActivity.this,NewBatchActivity.class);
                startActivity(i);
            }
        });
    }
}
