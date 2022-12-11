package com.example.app1.Adaptadores;

import android.content.Context;
import android.content.Intent;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.app1.Entities.Product;
import com.example.app1.Info;
import com.example.app1.R;

import java.util.ArrayList;

public class productoAdaptador extends BaseAdapter {

    private Context context;
    private ArrayList<Product> arrayProduct;

    public productoAdaptador(Context context, ArrayList<Product> arrayProduct) {
        this.context = context;
        this.arrayProduct = arrayProduct;
    }

    @Override
    public int getCount() {
        return arrayProduct.size();
    }

    @Override
    public Object getItem(int i) {
        return arrayProduct.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        LayoutInflater layoutInflater = LayoutInflater.from(this.context);
        view= layoutInflater.inflate(R.layout.producto_template,null);

        ImageView imgProduct= (ImageView) view.findViewById(R.id.imgProduct);
        TextView textName=(TextView) view.findViewById(R.id.textName);
        TextView textDescription=(TextView) view.findViewById(R.id.textDescription);
        TextView textPrice=(TextView) view.findViewById(R.id.textPrice);

        Product product = arrayProduct.get(i);

        imgProduct.setImageResource(product.getImage());
        textName.setText(product.getName());
        textDescription.setText(product.getDescription());
        textPrice.setText(product.getPrice());

        imgProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(context.getApplicationContext(), Info.class);
                intent.putExtra("name",product.getName());
                intent.putExtra("description",product.getDescription());
                intent.putExtra("price",product.getPrice());
                intent.putExtra("img",product.getImage());

                context.startActivity(intent);
            }
        });

        return view;
    }
}
