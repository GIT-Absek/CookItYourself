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

public class Resetpassword extends AppCompatActivity {

    TextView title,check,clear;
    EditText username,sqa;
    SQLiteDatabase sdb;
    Cursor cr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resetpassword);

        username=(EditText)findViewById(R.id.username);
        sqa=(EditText)findViewById(R.id.sqa);

        check = (TextView) findViewById(R.id.check);
        clear = (TextView) findViewById(R.id.clear);
        title = (TextView) findViewById(R.id.title);

        Intent i = getIntent();
        String s_title = i.getSerializableExtra("title").toString();
        title.setText(s_title);

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                username.setText("");
                sqa.setText("");
            }
        });

        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(username.getText().toString().length()>0 && sqa.getText().toString().length()>2)
                {
                    String uname,sqanswer;

                    uname=username.getText().toString();
                    sqanswer=sqa.getText().toString();

                    try
                    {
                        sdb = openOrCreateDatabase("CIY", Context.MODE_PRIVATE,null);

                        cr = sdb.rawQuery("select username,sqa from Users where username='"+uname+"' and sqa='"+sqanswer+"';",null);

                        if(cr.getCount()>0)
                        {
                            Toast.makeText(getApplicationContext(), "Valid Account", Toast.LENGTH_LONG).show();

                            Intent i = new Intent(Resetpassword.this,Confirmresetpassword.class);
                            i.putExtra("title","Confirm Password");
                            i.putExtra("uname",username.getText().toString());
                            startActivity(i);
                        }
                        else
                        {
                            Toast.makeText(getApplicationContext(), "Invalid Account", Toast.LENGTH_LONG).show();
                        }

                        cr.close();
                        sdb.close();
                    }
                    catch (Exception e)
                    {}
                }
                else if(username.getText().toString().length()==0)
                {
                    Toast.makeText(getApplicationContext(),"Invalid Username",Toast.LENGTH_LONG).show();
                }
                else if(sqa.getText().toString().length()<=3)
                {
                    Toast.makeText(getApplicationContext(),"Invalid Answer",Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Invalid Credentials",Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}