package com.example.myapplication.Activity;

import android.content.Intent;
import android.os.Bundle;

import com.example.myapplication.API.ApiHandler;
import com.example.myapplication.Adapter.StudentDataAdapter;
import com.example.myapplication.Model.ViewStudentModel;
import com.example.myapplication.Model.ViewStudentResult;

import androidx.appcompat.app.AppCompatActivity;
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

public class ViewStudentDetailsActivity extends AppCompatActivity {

    ListView l1;
    List<ViewStudentResult> studentList;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        l1=(ListView) findViewById(R.id.studentlist);
         studentList = new ArrayList<>();

        Toast.makeText(ViewStudentDetailsActivity.this,"StudentDetails....",Toast.LENGTH_LONG).show();

        ApiHandler.getApiService().viewStudentDetails(new Callback<ViewStudentModel>() {
            @Override
            public void success(ViewStudentModel viewStudentModel, Response response)
            {
                studentList = viewStudentModel.getStudentdata();

                StudentDataAdapter s1 = new StudentDataAdapter(ViewStudentDetailsActivity.this,studentList);
                l1.setAdapter(s1);
            }
            @Override
            public void failure(RetrofitError error)
            {
                Toast.makeText(ViewStudentDetailsActivity.this,"faill",Toast.LENGTH_LONG).show();

            }
        });
        Button newstudent_register =(Button) findViewById(R.id.newstudent_register);
        newstudent_register.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent i = new Intent(ViewStudentDetailsActivity.this,Newstudent_Activity.class);
                startActivity(i);

            }
        });
    }

}
