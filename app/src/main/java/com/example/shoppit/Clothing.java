package com.example.shoppit;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Clothing extends AppCompatActivity {
    Button mens,womens;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clothing);

        mens = (Button)findViewById(R.id.mens);
        womens = (Button)findViewById(R.id.womens);

        mens.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Clothing.this , Clothing_Mens.class);
                startActivity(intent);

//                    new Activity_DbManager(this);

            }
        });

        womens.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Clothing.this , Clothing_womens.class);
                startActivity(intent);

//                new Activity_DbManager(this);
            }
        });
    }
}
