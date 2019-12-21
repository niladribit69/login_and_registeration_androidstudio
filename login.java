package com.example.nil.travel;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class login extends AppCompatActivity {
    EditText et1,et2;
    Button b1;
    TextView t1,t2;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        db=new DatabaseHelper(this);
        et1=findViewById(R.id.textView);
        et2=findViewById(R.id.textView2);
        b1=findViewById(R.id.button);
        t1=findViewById(R.id.not_registered);
        t2=findViewById(R.id.registered);
        t2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent logintent=new Intent(login.this,register.class);
                startActivity(logintent);
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user=et1.getText().toString().trim();
                String pwd =et2.getText().toString().trim();
                Boolean res=db.checkUser(user,pwd);
                if(res==true){
                    Intent Logged=new Intent(login.this,newact.class);
                    startActivity(Logged);

                }
                else{
                    Toast.makeText(login.this,"login error",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
