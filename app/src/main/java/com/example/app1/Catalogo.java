package com.example.app1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.app1.Adaptadores.productoAdaptador;
import com.example.app1.Entities.Product;

import java.util.ArrayList;

public class Catalogo extends AppCompatActivity {

    private ListView listViewProducts;
    private productoAdaptador productoAdaptador;
    private ArrayList<Product> arrayProduct;
    private Button btnReturn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalogo);

        btnReturn=(Button) findViewById(R.id.btnReturn);
        listViewProducts=(ListView) findViewById(R.id.listViewProducts);
        arrayProduct=new ArrayList<>();
        productoAdaptador=new productoAdaptador(this, arrayProduct);

        //**Creación de los productos
        Product Product1=new Product("Silla italia blanca", "Silla italiana blanca tipo living exteriores", "1000",R.drawable.furniture1);
        Product Product2=new Product("Silla italia verde", "Silla italiana verde living exteriores", "1000",R.drawable.furniture2);
        Product Product3=new Product("Isabelina Yellow Modern", "Isabelina moderna de interiores color amarillo mostaza", "2500",R.drawable.furniture3);
        Product Product4=new Product("Isabelina Beige Modern", "Isabelina moderna de interiores color beige madera", "2500",R.drawable.furniture4);

        arrayProduct.add(Product1);
        arrayProduct.add(Product2);
        arrayProduct.add(Product3);
        arrayProduct.add(Product4);

        //** Fin creación productos

        listViewProducts.setAdapter(productoAdaptador);

        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }


        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.itemAdd:
                Intent intent =new Intent(getApplicationContext(),Form.class);
                startActivity(intent);
                Toast.makeText(getApplicationContext(),"Agregar", Toast.LENGTH_LONG).show();
                return true;
            case R.id.itemFavorite:
                Toast.makeText(getApplicationContext(),"Favorito", Toast.LENGTH_LONG).show();
                return true;
            case R.id.itemShare:
                Toast.makeText(getApplicationContext(),"Compartir", Toast.LENGTH_LONG).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}