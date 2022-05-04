package com.example.cookityourself;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Signup extends AppCompatActivity {

    TextView title,signup,clear;
    EditText username,password,email,sqa;
    SQLiteDatabase sdb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        username=(EditText)findViewById(R.id.username);
        password=(EditText)findViewById(R.id.password);
        email=(EditText)findViewById(R.id.email);
        sqa=(EditText)findViewById(R.id.securityquestionanswer);

        signup = (TextView) findViewById(R.id.signup);
        clear = (TextView) findViewById(R.id.clear);
        title = (TextView) findViewById(R.id.title);

        Intent i = getIntent();
        String s_title = i.getSerializableExtra("title").toString();
        title.setText(s_title);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(username.getText().toString().length()>0 && password.getText().toString().length()>3 && email.getText().toString().length()>0 && sqa.getText().toString().length()>2 )
                {
                    sdb = openOrCreateDatabase("CIY", Context.MODE_PRIVATE,null);

                    sdb.execSQL("create table if not exists Users(username varchar(30),password varchar(30),email varchar(30),sqa varchar(30))");

                    sdb.execSQL("insert into Users values('"+username.getText().toString()+"','"+password.getText().toString()+"','"+email.getText().toString()+"','"+sqa.getText().toString()+"')");

                    sdb.close();

                    Intent i = new Intent(Signup.this,MainActivity.class);
                    startActivity(i);

                    Toast.makeText(getApplicationContext(),"Account Signup Successful !!",Toast.LENGTH_LONG).show();
                }
                else if(username.getText().toString().length()==0)
                {
                    Toast.makeText(getApplicationContext(),"Invalid Username",Toast.LENGTH_LONG).show();
                }
                else if(password.getText().toString().length()<=3)
                {
                    Toast.makeText(getApplicationContext(),"Invalid Password",Toast.LENGTH_LONG).show();
                }
                else if(email.getText().toString().length()==0)
                {
                    Toast.makeText(getApplicationContext(),"Invalid Email",Toast.LENGTH_LONG).show();
                }
                else if(sqa.getText().toString().length()<=2)
                {
                    Toast.makeText(getApplicationContext(),"Invalid Security Question Answer",Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Invalid Credentials",Toast.LENGTH_LONG).show();
                }

            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                username.setText("");
                password.setText("");
                sqa.setText("");
                email.setText("");
            }
        });
    }
}