package com.example.app1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Info extends AppCompatActivity {

    private TextView TextNameInfo, TextDescriptionInfo, TextPriceInfo;
    private ImageView ImgInfo;
    private Button BtnInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        TextNameInfo=(TextView) findViewById(R.id.textNameInfo);
        TextDescriptionInfo=(TextView) findViewById(R.id.textDescriptionInfo);
        TextPriceInfo=(TextView) findViewById(R.id.textPriceInfo);
        ImgInfo=(ImageView) findViewById(R.id.imgInfo);
        BtnInfo=(Button) findViewById(R.id.btnInfo);

        Intent intentIN=getIntent();
        TextNameInfo.setText(intentIN.getStringExtra("name"));
        TextDescriptionInfo.setText(intentIN.getStringExtra("description"));
        TextPriceInfo.setText(intentIN.getStringExtra("price"));
        ImgInfo.setImageResource(intentIN.getIntExtra("img",0));




        BtnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(), Catalogo.class);
                startActivity(intent);
            }
        });


    }
}