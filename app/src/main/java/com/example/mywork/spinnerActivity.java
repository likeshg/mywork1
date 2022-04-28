package com.example.mywork;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;


import androidx.annotation.Nullable;

public class spinnerActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.picture);
        setTitle("춘식이 사진보기(Spinner)");

        final String[] picList = {"집순이", "전신셀카", "밤에휴대폰", "해냥", "요리", "냥냥냥냥",
        "엔젤", "파자마", "춤셀카", "야식", "벚꽃", "후디", "해변"};

        Button btnReturn = findViewById(R.id.btnReturn);

        Integer[] picture = {R.drawable.cs1, R.drawable.cs2, R.drawable.cs3, R.drawable.cs4,
        R.drawable.cs5, R.drawable.cs6, R.drawable.cs7, R.drawable.cs8, R.drawable.cs9,
        R.drawable.cs10, R.drawable.cs11, R.drawable.cs12, R.drawable.cs13};

        Spinner spinner = (Spinner) findViewById(R.id.spinner1);


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, picList);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View view, int position, long id) {
                ImageView ivPicture = findViewById(R.id.ivPicture);
                ivPicture.setScaleType(ImageView.ScaleType.FIT_CENTER);
                ivPicture.setPadding(5,5,5,5);
                ivPicture.setImageResource(picture[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


    }

}
