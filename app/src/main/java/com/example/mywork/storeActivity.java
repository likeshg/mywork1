package com.example.mywork;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;

public class storeActivity extends Activity {
    String Tag = storeActivity.class.getSimpleName();

    WebView webView1 = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.store);
        setTitle("춘식이 굿즈 검색하기");

        Button btnSearch = (Button) findViewById(R.id.btnSearch);
        Button btnReturn = (Button) findViewById(R.id.btnReturn);
        EditText searchItem = (EditText) findViewById(R.id.searchItem);

        //gif 재생
        ImageView imageView2 = (ImageView) findViewById(R.id.imageView2);
        Glide.with(this).load(R.raw.choonsik).into(imageView2);

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(searchItem.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "굿즈명을 입력하세요",
                            Toast.LENGTH_SHORT).show();
                }
                else{
                    Uri uri = Uri.parse("https://store.kakaofriends.com/search?keyword=" +
                            searchItem.getText().toString() + "&sort=SELL&global=false");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
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
