package com.example.app1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnFurniture, btnSports, btnTech;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnFurniture=(Button) findViewById(R.id.btnFurniture);
        btnTech=(Button) findViewById(R.id.btnTech);
        btnSports=(Button) findViewById(R.id.btnSports);


        btnFurniture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(), MainActivity3.class);
                intent.putExtra("description","En esta sección encontarrá variedad de Muebeles y accesorios para el hogar");
                intent.putExtra("image",R.drawable.imgFurniture);
                startActivity(intent);
            }
        });

        btnTech.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(), MainActivity3.class);
                intent.putExtra("description","En esta sección encontrará todos los artículos tecnolóogicos");
                intent.putExtra("image",R.drawable.imgTech);
                startActivity(intent);
            }
        });

        btnSports.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(), MainActivity3.class);
                intent.putExtra("description","En esta sección encontrará artículos deportivos");
                intent.putExtra("image",R.drawable.imgSports);
                startActivity(intent);
            }
        });


    }
}