package com.example.cookityourself;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    TextView title,login,clear,resetpassword;
    EditText username,password;
    SQLiteDatabase sdb;
    Cursor cr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username=(EditText)findViewById(R.id.username);
        password=(EditText)findViewById(R.id.password);

        login = (TextView) findViewById(R.id.login);
        clear = (TextView) findViewById(R.id.clear);
        title = (TextView) findViewById(R.id.title);
        resetpassword = (TextView)findViewById(R.id.resetpassword);

        Intent i = getIntent();
        String s_title = i.getSerializableExtra("title").toString();
        title.setText(s_title);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(username.getText().toString().length()>0 && password.getText().toString().length()>3)
                {
                    String uname,pass;
                    uname = username.getText().toString();
                    pass = password.getText().toString();

                    try
                    {
                        sdb = openOrCreateDatabase("CIY", Context.MODE_PRIVATE,null);

                        cr = sdb.rawQuery("select username,password from Users where username='"+uname+"' and password='"+pass+"';",null);

                        if(cr.getCount()>0)
                        {
                            Toast.makeText(getApplicationContext(), "Login Successful", Toast.LENGTH_LONG).show();

                            Intent i = new Intent(Login.this,MainActivity2.class);
                            i.putExtra("uname",username.getText().toString());
                            startActivity(i);
                            finish();
                        }
                        else
                        {
                            Toast.makeText(getApplicationContext(), "Invalid Entry", Toast.LENGTH_LONG).show();
                        }
                    }
                    catch(Exception e)
                    {

                    }
                    cr.close();
                    sdb.close();
                }
                else if(username.getText().toString().length()==0)
                {
                    Toast.makeText(getApplicationContext(),"Invalid Username",Toast.LENGTH_LONG).show();
                }
                else if(password.getText().toString().length()<=3)
                {
                    Toast.makeText(getApplicationContext(),"Invalid Password",Toast.LENGTH_LONG).show();
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
            }
        });

        resetpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Login.this,Resetpassword.class);
                i.putExtra("title",resetpassword.getText().toString());
                startActivity(i);
            }
        });
    }
}