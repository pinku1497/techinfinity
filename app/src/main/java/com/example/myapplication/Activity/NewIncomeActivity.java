package com.example.myapplication.Activity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.API.ApiHandler;
import com.example.myapplication.Model.NewIncomeModel;
import com.example.myapplication.Model.NewStudentModel;
import com.example.myapplication.R;

import java.util.Calendar;

import androidx.appcompat.app.AppCompatActivity;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class NewIncomeActivity extends AppCompatActivity implements View.OnClickListener {
    EditText new_income,new_amount,income_date,income_remarks;
    Button income_btn;
    private int mYear, mMonth, mDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_income);

        new_income = (EditText) findViewById(R.id.newincome);
        new_amount = (EditText) findViewById(R.id.newamount);
        income_date = (EditText) findViewById(R.id.incomedate);
        income_remarks = (EditText) findViewById(R.id.incomeremarks);

        income_btn = (Button) findViewById(R.id.incomesave);

        income_date.setOnClickListener(this);

        income_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (new_income.getText().toString().equals("")) {
                    new_income.setError("Please Enter Income");
                }
                if (new_amount.getText().toString().equals("")) {
                    new_amount.setError("Please Enter Amount");
                }
                if (income_date.getText().toString().equals("")) {
                    income_date.setError("Please Enter Income Date");
                }
                else {
                    getUserAPI(new_income.getText().toString(),new_amount.getText().toString(),income_date.getText().toString(),income_remarks.getText().toString());
                }
            }
            private void getUserAPI(String new_income,String new_amount,String income_date,String income_remarks){
                ApiHandler.getApiService().newIncome(new_income,new_amount,income_date,income_remarks,new Callback<NewIncomeModel>()
                {

                    public void success(NewIncomeModel incomeModel, Response response)
                    {
                        Toast.makeText(NewIncomeActivity.this,"Successfull",Toast.LENGTH_LONG).show();
                        Intent i = new Intent(NewIncomeActivity.this,ViewStudentDetailsActivity.class);
                        startActivity(i);

                    }
                    public void failure(RetrofitError error)
                    {
                        Toast.makeText(NewIncomeActivity.this,"czxczx Failure",Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
    }
    public void onClick(View v)
    {
        if (v == income_date) {

            // Get Current Date
            final Calendar c = Calendar.getInstance();
            mYear = c.get(Calendar.YEAR);
            mMonth = c.get(Calendar.MONTH);
            mDay = c.get(Calendar.DAY_OF_MONTH);


            DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                    new DatePickerDialog.OnDateSetListener() {

                        @Override
                        public void onDateSet(DatePicker view, int year,
                                              int monthOfYear, int dayOfMonth) {

                            income_date.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                        }
                    }, mYear, mMonth, mDay);
            datePickerDialog.show();
        }

    }

}
