package com.example.app1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {
    private Button btnContinue;
    private TextView textDescription;
    private ImageView imgProduct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        btnContinue=(Button) findViewById(R.id.btnContinue);
        textDescription=(TextView) findViewById(R.id.textDescription);
        imgProduct=(ImageView) findViewById(R.id.imgProduct);

        Intent intentIn=getIntent();
        textDescription.setText(intentIn.getStringExtra("description"));
        imgProduct.setImageResource(intentIn.getIntExtra("image",0));

        btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Catalogo.class);
                startActivity(intent);
            }
        });
    }
}