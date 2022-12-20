package com.example.app1.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.app1.Catalogo;
import com.example.app1.DB.DBFirebase;
import com.example.app1.Entities.Product;
import com.example.app1.Form;
import com.example.app1.Info;
import com.example.app1.R;

import java.util.ArrayList;

public class ProductAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Product> arrayProducts;

    public ArrayList<Product> getArrayProducts() {
        return arrayProducts;
    }

    public void setArrayProducts(ArrayList<Product> arrayProducts) {
        this.arrayProducts = arrayProducts;
    }

    public ProductAdapter(Context context, ArrayList<Product> arrayProducts) {
        this.context = context;
        this.arrayProducts = arrayProducts;
    }

    @Override
    public int getCount() {
        return arrayProducts.size();
    }

    @Override
    public Object getItem(int i) {
        return arrayProducts.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        LayoutInflater layoutInflater = LayoutInflater.from(this.context);
        view= layoutInflater.inflate(R.layout.producto_template,null);

        Product product = arrayProducts.get(i);

        ImageView imgProduct= (ImageView) view.findViewById(R.id.imgProduct);
        TextView textName=(TextView) view.findViewById(R.id.textName);
        TextView textDescription=(TextView) view.findViewById(R.id.textDescription);
        TextView textPrice=(TextView) view.findViewById(R.id.textPrice);
        Button btnDelete=(Button) view.findViewById(R.id.btnDelete);
        Button btnEdit=(Button) view.findViewById(R.id.btnEdit);


        imgProduct.setImageResource(Integer.parseInt(product.getImage()));
        textName.setText(product.getName());
        textDescription.setText(product.getDescription());
        textPrice.setText(product.getPrice());

        imgProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context.getApplicationContext(),Info.class);
                intent.putExtra("id",product.getId());
                intent.putExtra("name",product.getName());
                intent.putExtra("description",product.getDescription());
                intent.putExtra("price",product.getPrice());
                intent.putExtra("image",product.getImage());
                context.startActivity(intent);
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBFirebase dbFirebase=new DBFirebase();
                dbFirebase.deleteData(product.getId());
                Intent intent=new Intent(context, Catalogo.class);
                context.startActivity(intent);
            }
        });

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context, Form.class);
                intent.putExtra("edit",true);
                intent.putExtra("id",product.getId());
                intent.putExtra("name",product.getName());
                intent.putExtra("description",product.getDescription());
                intent.putExtra("price",product.getPrice());
                intent.putExtra("image",product.getImage());
                intent.putExtra("longitud",product.getLongitud());
                intent.putExtra("latitud",product.getLatitud());
                context.startActivity(intent);

            }
        });


        return view;
    }
}
