package com.example.cookityourself;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;

public class Bguide1 extends AppCompatActivity {

    TextView t1;
    ImageSlider is;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bguide1);
        t1 = (TextView)findViewById(R.id.title);
        Intent i = getIntent();
        String s_title = i.getSerializableExtra("title").toString();
        t1.setText(s_title);

        is = (ImageSlider)findViewById(R.id.imageslider);

        ArrayList<SlideModel> images = new ArrayList<>();
        images.add(new SlideModel(R.drawable.bguide1_img1,null));
        images.add(new SlideModel(R.drawable.bguide1_img2,null));

        is.setImageList(images);
    }
}