package com.example.myapplication.Activity;

import android.content.Intent;
import android.os.Bundle;

import com.example.myapplication.API.ApiHandler;
import com.example.myapplication.Adapter.TaskAdapter;

import com.example.myapplication.Model.ViewTaskModel;
import com.example.myapplication.Model.ViewTaskResult;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class ViewTaskDetail extends AppCompatActivity
{
    ListView listView;
    List<ViewTaskResult> taskResults;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_task_detail);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        listView = (ListView) findViewById(R.id.tasklist);
        taskResults = new ArrayList<>();

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent i = new Intent(ViewTaskDetail.this, Demo_Task.class);
                startActivity(i);
            }
        });
        ApiHandler.getApiService().viewtask(new Callback<ViewTaskModel>()
        {
            @Override
            public void success(ViewTaskModel viewTaskModel, Response response)
            {
                taskResults=viewTaskModel.getTaskdata();

                TaskAdapter taskAdapter=new TaskAdapter(ViewTaskDetail.this,taskResults);
                listView.setAdapter(taskAdapter);
            }
            @Override
            public void failure(RetrofitError error)
            {
                    Toast.makeText(ViewTaskDetail.this,"Fail",Toast.LENGTH_SHORT).show();
            }
        });
    }
}

