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

public class Confirmresetpassword extends AppCompatActivity {

    TextView title,resetp,clear;
    EditText password,confirmpassword;
    SQLiteDatabase sdb;
    String s_title,uname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmresetpassword);

        password=(EditText)findViewById(R.id.password);
        confirmpassword=(EditText)findViewById(R.id.confirmpassword);

        resetp = (TextView) findViewById(R.id.resetpassword);
        clear = (TextView) findViewById(R.id.clear);
        title = (TextView) findViewById(R.id.title);

        s_title = (String) getIntent().getSerializableExtra("title");
        title.setText(s_title);

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                password.setText("");
                confirmpassword.setText("");
            }
        });


        resetp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(password.getText().toString().length()>3 && confirmpassword.getText().toString().length()>3)
                {
                    if((password.getText().toString().equals(confirmpassword.getText().toString())))
                    {
                        String p =password.getText().toString();
                        String cp =confirmpassword.getText().toString();

                        uname = (String) getIntent().getSerializableExtra("uname");

                        sdb = openOrCreateDatabase("CIY", Context.MODE_PRIVATE,null);

                        sdb.execSQL("update Users set password='"+p+"' where username='"+uname+"';");

                        sdb.close();

                        Toast.makeText(getApplicationContext(), "Password Changed", Toast.LENGTH_LONG).show();

                        Intent intent = new Intent(Confirmresetpassword.this,MainActivity.class);
                        startActivity(intent);
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(), "Password and Confirmpassword are not the same", Toast.LENGTH_LONG).show();
                    }
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "Invalid Credentials", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}