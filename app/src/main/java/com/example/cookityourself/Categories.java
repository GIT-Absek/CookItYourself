package com.example.cookityourself;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Categories extends AppCompatActivity {

    TextView title;
    TextView breakfast,dessert,lunch,dinner,northindian,southindian,others,indochinese,tea,coffee,milkshake,soup,pizza,burger,sandwich;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);

        breakfast = (TextView)findViewById(R.id.breakfast);
        dessert = (TextView)findViewById(R.id.dessert);
        lunch = (TextView)findViewById(R.id.lunch);
        dinner = (TextView)findViewById(R.id.dinner);
        northindian = (TextView)findViewById(R.id.northindian);
        southindian = (TextView)findViewById(R.id.southindian);
        others = (TextView)findViewById(R.id.others);
        indochinese = (TextView)findViewById(R.id.indochinese);
        tea = (TextView)findViewById(R.id.tea);
        coffee = (TextView)findViewById(R.id.coffee);
        milkshake = (TextView)findViewById(R.id.milkshake);
        soup = (TextView)findViewById(R.id.soup);
        pizza = (TextView)findViewById(R.id.pizza);
        burger = (TextView)findViewById(R.id.burger);
        sandwich = (TextView)findViewById(R.id.sandwich);

        Intent i = getIntent();
        String s_title = i.getSerializableExtra("title").toString();
        title = (TextView)findViewById(R.id.title);
        title.setText(s_title);

        breakfast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Categories.this,Breakfast.class);
                intent.putExtra("title",breakfast.getText().toString());
                startActivity(intent);
            }
        });
        dessert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Categories.this,Dessert.class);
                intent.putExtra("title",dessert.getText().toString());
                startActivity(intent);
            }
        });
        lunch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Categories.this,Lunch.class);
                intent.putExtra("title",lunch.getText().toString());
                startActivity(intent);
            }
        });
        dinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Categories.this,Dinner.class);
                intent.putExtra("title",dinner.getText().toString());
                startActivity(intent);
            }
        });
        northindian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Categories.this,Northindian.class);
                intent.putExtra("title",northindian.getText().toString());
                startActivity(intent);
            }
        });
        southindian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Categories.this,Southindian.class);
                intent.putExtra("title",southindian.getText().toString());
                startActivity(intent);
            }
        });
        others.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Categories.this,Others.class);
                intent.putExtra("title",others.getText().toString());
                startActivity(intent);
            }
        });
        indochinese.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Categories.this,Indochinese.class);
                intent.putExtra("title",indochinese.getText().toString());
                startActivity(intent);
            }
        });
        tea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Categories.this,Tea.class);
                intent.putExtra("title",tea.getText().toString());
                startActivity(intent);
            }
        });
        coffee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Categories.this,Coffee.class);
                intent.putExtra("title",coffee.getText().toString());
                startActivity(intent);
            }
        });
        milkshake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Categories.this,Milkshake.class);
                intent.putExtra("title",milkshake.getText().toString());
                startActivity(intent);
            }
        });
        soup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Categories.this,Soup.class);
                intent.putExtra("title",soup.getText().toString());
                startActivity(intent);
            }
        });
        pizza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Categories.this,Pizza.class);
                intent.putExtra("title",pizza.getText().toString());
                startActivity(intent);
            }
        });
        burger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Categories.this,Burger.class);
                intent.putExtra("title",burger.getText().toString());
                startActivity(intent);
            }
        });
        sandwich.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Categories.this,Sandwich.class);
                intent.putExtra("title",sandwich.getText().toString());
                startActivity(intent);
            }
        });
    }
}