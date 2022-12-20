package com.example.app1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.app1.DB.DBFirebase;
import com.example.app1.Entities.Product;

public class Form extends AppCompatActivity {

    private Button btnForm;
    private EditText editName, editDescription, editPrice;
    private DBFirebase dbFirebase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        btnForm=(Button) findViewById(R.id.btnForm);
        editName=(EditText) findViewById(R.id.editNameForm);
        editDescription=(EditText) findViewById(R.id.editDescriptionForm);
        editPrice=(EditText) findViewById(R.id.editPriceForm);

        dbFirebase=new DBFirebase();

        Intent intentIN=getIntent();
        if(intentIN.getBooleanExtra("edit",false)){
            editName.setText(intentIN.getStringExtra("name"));
            editDescription.setText(intentIN.getStringExtra("description"));
            editPrice.setText(intentIN.getStringExtra("price"));
        }

        btnForm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Product product=new Product(
                        editName.getText().toString(),
                        editDescription.getText().toString(),
                        editPrice.getText().toString(),
                        String.valueOf(R.drawable.furniture1),
                        "0",
                        "0"
                );
                if(intentIN.getBooleanExtra("edit",false)){
                    product.setId(intentIN.getStringExtra("id"));
                    dbFirebase.updateData(product);
                }else{
                    dbFirebase.insertData(product);
                }


                dbFirebase.insertData(product);
                Intent intent= new Intent(getApplicationContext(),Catalogo.class);
                startActivity(intent);
            }
        });



    }
}