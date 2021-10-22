package com.example.myapplication.Activity;

import androidx.appcompat.app.AppCompatActivity;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.API.ApiHandler;
import com.example.myapplication.Model.NewStudentModel;
import com.example.myapplication.R;

public class NewBatchActivity extends AppCompatActivity {
    EditText batch_name,batch_location;
    Button batch_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_batch2);
        batch_name=(EditText)findViewById(R.id.batch_name);
        batch_location=(EditText)findViewById(R.id.batch_location);
        batch_btn=(Button)findViewById(R.id.batch_btn);
        batch_btn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view)
        {
            ApiHandler.getApiService().newBatch(batch_name.getText().toString(), batch_location.getText().toString(), new Callback<NewStudentModel>() {
                @Override
                public void success(NewStudentModel newStudentModel, Response response)
                {
                    Toast.makeText(NewBatchActivity.this,"Batch Add..",Toast.LENGTH_LONG).show();
                }

                @Override
                public void failure(RetrofitError error)
                {

                }
            });

        }
    });
    }
}
