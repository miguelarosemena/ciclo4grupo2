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

import com.example.app1.Adapters.ProductAdapter;
import com.example.app1.DB.DBFirebase;
import com.example.app1.Entities.Product;

import java.util.ArrayList;

public class Catalogo extends AppCompatActivity {

    private ListView listViewProducts;
    private ProductAdapter productoAdaptador;
    private ArrayList<Product> arrayProducts;
    private Button btnReturn;
    private DBFirebase dbFirebase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalogo);

        dbFirebase=new DBFirebase();
        btnReturn=(Button) findViewById(R.id.btnReturn);
        listViewProducts=(ListView) findViewById(R.id.listViewProducts);
        arrayProducts=new ArrayList<>();



        //**Creación de los productos
        /*
        Product product1=new Product("Producto 1","Desc.1", "1000", String.valueOf(R.drawable.furniture1));
        Product product2=new Product("Producto 2","Desc.2", "2000", String.valueOf(R.drawable.furniture2));
        Product product3=new Product("Producto 3","Desc.3", "3000", String.valueOf(R.drawable.furniture3));
        Product product4=new Product("Producto 4","Desc.4", "4000", String.valueOf(R.drawable.furniture4));
        Product product5=new Product("Producto 5","Desc.5", "5000", String.valueOf(R.drawable.furniture1));
        Product product6=new Product("Producto 6","Desc.6", "6000", String.valueOf(R.drawable.furniture2));
        Product product7=new Product("Producto 7","Desc.7", "7000", String.valueOf(R.drawable.furniture3));
        Product product8=new Product("Producto 8","Desc.8", "8000", String.valueOf(R.drawable.furniture4));
        Product product9=new Product("Producto 9","Desc.9", "9000", String.valueOf(R.drawable.furniture1));

        arrayProduct.add(product1);
        arrayProduct.add(product2);
        arrayProduct.add(product3);
        arrayProduct.add(product4);
        arrayProduct.add(product5);
        arrayProduct.add(product6);
        arrayProduct.add(product7);
        arrayProduct.add(product8);
        arrayProduct.add(product9);
        */

        //** Fin creación productos


        productoAdaptador=new ProductAdapter(this,arrayProducts);
        listViewProducts.setAdapter(productoAdaptador);


        dbFirebase.getData(productoAdaptador);

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
        Intent intent;
        switch (item.getItemId()){
            case R.id.itemAdd:
                intent =new Intent(getApplicationContext(),Form.class);
                startActivity(intent);
                Toast.makeText(getApplicationContext(),"Agregar", Toast.LENGTH_LONG).show();
                return true;
            case R.id.itemMap:
                intent=new Intent(getApplicationContext(),Maps.class);
                startActivity(intent);
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