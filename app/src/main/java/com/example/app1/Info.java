package com.example.app1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.app1.Entities.Product;

public class Info extends AppCompatActivity {

    private TextView textNameInfo, textDescriptionInfo, textPriceInfo, textIdInfo;
    private ImageView imgInfo;
    private Button btnInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        textIdInfo=(TextView) findViewById(R.id.textIdInfo);
        textNameInfo=(TextView) findViewById(R.id.textNameInfo);
        textDescriptionInfo=(TextView) findViewById(R.id.textDescriptionInfo);
        textPriceInfo=(TextView) findViewById(R.id.textPriceInfo);
        imgInfo=(ImageView) findViewById(R.id.imgInfo);
        btnInfo=(Button) findViewById(R.id.btnInfo);

        Intent intentIN=getIntent();
        Product product =new Product(
                intentIN.getStringExtra("id"),
                intentIN.getStringExtra("name"),
                intentIN.getStringExtra("description"),
                intentIN.getStringExtra("price"),
                intentIN.getStringExtra("image")
        );

        textIdInfo.setText(product.getId());
        textNameInfo.setText(product.getName());
        textDescriptionInfo.setText(product.getDescription());
        textPriceInfo.setText(product.getPrice());
        imgInfo.setImageResource(Integer.parseInt(product.getImage()));


        btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(), Catalogo.class);
                startActivity(intent);
            }
        });


    }
}