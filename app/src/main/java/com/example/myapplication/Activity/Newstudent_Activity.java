package com.example.myapplication.Activity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.myapplication.API.ApiHandler;
import com.example.myapplication.Model.NewStudentModel;
import com.example.myapplication.R;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class Newstudent_Activity extends AppCompatActivity {

    EditText name, course,sem,fees,date,desc;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newstudent_);

        name = (EditText) findViewById(R.id.s_name);
        course = (EditText) findViewById(R.id.s_course);
        sem = (EditText) findViewById(R.id.s_semester);
        fees = (EditText) findViewById(R.id.s_fees);
        date = (EditText) findViewById(R.id.s_date);
        desc = (EditText) findViewById(R.id.s_description);

        btn = (Button) findViewById(R.id.submit);


        date.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                final Calendar myCalendar = Calendar.getInstance();
                DatePickerDialog.OnDateSetListener dt = new DatePickerDialog.OnDateSetListener()
                {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth)
                    {
                        myCalendar.set(Calendar.YEAR, year);
                        myCalendar.set(Calendar.MONTH, monthOfYear);
                        myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                        String myFormat = "dd-MMM-yyyy";
                        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.getDefault());

                        date.setText(sdf.format(myCalendar.getTime()));
                    }

                };
                new DatePickerDialog(Newstudent_Activity.this, dt, myCalendar.get(Calendar.YEAR), myCalendar.get(Calendar.MONTH), myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
        btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if (name.getText().toString().equals(""))
                {
                    name.setError("Please Enter Your Name");
                }
                if (course.getText().toString().equals(""))
                {
                    course.setError("Please Enter Your Course");
                }
                if (sem.getText().toString().equals(""))
                {
                    sem.setError("Please Enter Your Semester");
                }
                if (fees.getText().toString().equals(""))
                {
                    fees.setError("Please Enter Your Fees");
                }
                if (date.getText().toString().equals(""))
                {
                    date.setError("Please Enter Your Date");
                }
                if (desc.getText().toString().equals(""))
                {
                    desc.setError("Please Enter Your Description");
                }
                else
                    {
                      getUserAPI(name.getText().toString(), course.getText().toString(),sem.getText().toString(), fees.getText().toString(), date.getText().toString(), desc.getText().toString());
                        Intent i=new Intent(Newstudent_Activity.this,ViewStudentDetailsActivity.class);
                        startActivity(i);
                    }
            }
        });
    }
    private void getUserAPI(String name, String course, String sem, String fees, String date, String desc)
    {
        ApiHandler.getApiService().stu(name, course, sem, fees, date, desc, new Callback<NewStudentModel>()
        {
            @Override
            public void success(NewStudentModel studentdataModel, Response response)
            {
                Toast.makeText(Newstudent_Activity.this,"Data Submitted..",Toast.LENGTH_SHORT).show();
            }
            @Override
            public void failure(RetrofitError error)
            {
                Toast.makeText(Newstudent_Activity.this,"Data Not Submitted..",Toast.LENGTH_SHORT).show();
            }
        });
    }
}

