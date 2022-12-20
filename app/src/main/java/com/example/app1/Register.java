package com.example.app1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.dynamic.IFragmentWrapper;
import com.google.firebase.auth.FirebaseAuth;

public class Register extends AppCompatActivity {
    private Button btnRegister;
    private EditText editEmailRegister, editPasswordRegister, editPasswordConfirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        btnRegister=(Button) findViewById(R.id.btnRegister);
        editEmailRegister=(EditText) findViewById(R.id.editEmailRegister);
        editPasswordRegister=(EditText) findViewById(R.id.editPasswordRegister);
        editPasswordConfirm=(EditText) findViewById(R.id.editPasswordConfirm);



        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email= editEmailRegister.getText().toString();
                String pass= editPasswordRegister.getText().toString();
                String confirm=editPasswordConfirm.getText().toString();

                if (pass.compareTo(confirm)==0){
                    FirebaseAuth mAuth;
                    mAuth = FirebaseAuth.getInstance();
                    mAuth.createUserWithEmailAndPassword(email,pass);
                    Intent intent  =new Intent(getApplicationContext(),Login.class);
                    startActivity(intent);

                }else{
                    Toast.makeText(getApplicationContext(),"Las contraseñas no coinciden",Toast.LENGTH_SHORT);
                }
            }
        });
    }
}