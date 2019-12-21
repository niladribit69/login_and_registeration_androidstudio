package com.example.nil.travel;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class register extends AppCompatActivity {
    EditText et1,et2,et3;
    Button b1;
    TextView t1,t2;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        db=new DatabaseHelper(this);
        et1=findViewById(R.id.textView5);
        et2=findViewById(R.id.textView6);
        et3=findViewById(R.id.textView7);
        b1=findViewById(R.id.button2);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user=et1.getText().toString().trim();
                String pwd=et2.getText().toString().trim();
                String cnf_pwd=et3.getText().toString().trim();
                if(pwd.equals(cnf_pwd)) {
                    long val = db.addUser(user, pwd);

                        Toast.makeText(register.this, "registered", Toast.LENGTH_SHORT).show();
                        Intent movetologin = new Intent(register.this, login.class);
                        startActivity(movetologin);
                    }

                     else{
                        Toast.makeText(register.this,"password not matching",Toast.LENGTH_SHORT).show();
                }}
        });


        t1=findViewById(R.id.AL_registered);
        t2=findViewById(R.id.LOGIN);
        t2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerintent = new Intent(register.this, login.class);
                startActivity(registerintent);
            }
        });

    }
}
