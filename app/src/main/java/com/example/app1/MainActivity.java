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
                intent.putExtra("description","Querida Tribu, en esta sección encontrarás gran variedad de Muebles y accesorios para el hogar. Antojate y haznos parte de tu casa");
                intent.putExtra("image",R.drawable.furniture);
                startActivity(intent);
            }
        });

        btnTech.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(), MainActivity3.class);
                intent.putExtra("description","Querida Tribu, en esta sección encontrarás gran variedad de productos tecnológicos. Antojate y dejanos acompañarnos desde el mundo digital");
                intent.putExtra("image",R.drawable.tecnology);
                startActivity(intent);
            }
        });

        btnSports.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(), MainActivity3.class);
                intent.putExtra("description","Querida Tribu, en esta sección encontrarás todos los artículos deportivos que requieres. Dejános acompañarnos en tus ratos de esparcimiento y oxigenación");
                intent.putExtra("image",R.drawable.sports);
                startActivity(intent);
            }
        });


    }
}