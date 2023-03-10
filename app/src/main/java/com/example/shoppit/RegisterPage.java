package com.example.shoppit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterPage extends AppCompatActivity {

    EditText name,email,password;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);


        auth = FirebaseAuth.getInstance();
        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);

        if(auth.getCurrentUser() != null){
            startActivity(new Intent(RegisterPage.this, MainActivity.class));
            finish();
        }
    }


    public void signup(View view) {

        String userName = name.getText().toString();
        String userEmail = email.getText().toString();
        String userPassword = password.getText().toString();

        if(TextUtils.isEmpty(userName)){
            Toast.makeText(this, "Enter Name", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(userEmail)){
            Toast.makeText(this, "Enter Email", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(userPassword)){
            Toast.makeText(this, "Enter Password", Toast.LENGTH_SHORT).show();
            return;
        }

        if(userPassword.length()<6){
            Toast.makeText(this, "Password lenght is too short", Toast.LENGTH_SHORT).show();
        }

        auth.createUserWithEmailAndPassword(userEmail,userPassword)
                .addOnCompleteListener(RegisterPage.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if(task.isSuccessful()){
                            Toast.makeText(RegisterPage.this, "Succesful",Toast.LENGTH_SHORT);
                            startActivity(new Intent(RegisterPage.this,RegLogChoice.class));
                        }else{
                            Toast.makeText(RegisterPage.this, "Failed registration" + task.getException(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });





    }
    public void signin(View view){

        startActivity(new Intent(RegisterPage.this,LoginPage.class));
    }



}
