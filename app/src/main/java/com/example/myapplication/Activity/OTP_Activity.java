package com.example.myapplication.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.R;

import java.util.Random;

public class OTP_Activity extends AppCompatActivity
{

    EditText edtnum,edtotp;
    Button send,login;
    Random random;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp_);

         random=new Random();

         final String otp = String.format("%04d",random.nextInt(1000));
        edtnum=(EditText)findViewById(R.id.edtnum);
        edtotp=(EditText)findViewById(R.id.otp);
        send=(Button)findViewById(R.id.send);
        login=(Button)findViewById(R.id.login);
        send.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                String no= edtnum.getText().toString();
                SmsManager smsManager=SmsManager.getDefault();
                smsManager.sendTextMessage(no,null,otp,null,null);
                Toast.makeText(OTP_Activity.this,"Sent succesfully..",Toast.LENGTH_SHORT).show();

                edtotp.setVisibility(View.INVISIBLE);
                edtotp.setText(otp);
                send.setVisibility(View.INVISIBLE);
                login.setVisibility(View.VISIBLE);
                edtotp.setVisibility(View.VISIBLE);

            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edtotp.getText().toString().equals(otp))
                {
                    Intent i=new Intent(OTP_Activity.this,HomeActivity.class);
                    startActivity(i);
                }
                else
                {
                    Intent i=new Intent(OTP_Activity.this,OTP_Activity.class);
                    startActivity(i);
                }
            }
        });
    }
}
