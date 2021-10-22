package com.example.myapplication.Activity;

import android.content.Intent;
import android.os.Bundle;

import com.example.myapplication.API.ApiHandler;
import com.example.myapplication.Model.TaskModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.R;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class Demo_Task extends AppCompatActivity {

    EditText task;
    EditText remark;
    Button save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo__task);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

       task=(EditText)findViewById(R.id.task);
       remark=(EditText)findViewById(R.id.remark);
        save = (Button) findViewById(R.id.save);
        save.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                ApiHandler.getApiService().newTask(task.getText().toString(), remark.getText().toString(), new Callback<TaskModel>() {
                    @Override
                    public void success(TaskModel taskModel, Response response) {
                        Intent i=new Intent(Demo_Task.this,ViewTaskDetail.class);
                        startActivity(i);
                        Toast.makeText(Demo_Task.this, "Done", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void failure(RetrofitError error)
                    {
                        Toast.makeText(Demo_Task.this, "Fail", Toast.LENGTH_SHORT).show();
                    }
                });
        }

        });
    }
}