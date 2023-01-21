package com.example.shoppit;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Clothing_Mens extends AppCompatActivity {

    TextView prodname1;
    Button prod1,prod2;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.men_clothing);

        prodname1 = (TextView) findViewById(R.id.prod1);
        prod1 = (Button)findViewById(R.id.prod1);

        prod1.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                String btnText1 = prod1.getText().toString();
                Intent intent = new Intent(Clothing_Mens.this , add_address.class);
                startActivity(intent);

            }
        });

        prod2 = (Button)findViewById(R.id.prod2);

        prod2.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                String btnText1 = prod2.getText().toString();
                Intent intent = new Intent(Clothing_Mens.this , add_address.class);
                startActivity(intent);

            }
        });

    }

//    public void addRecord(View view){
//        Activity_DbManager db = new Activity_DbManager(this);
//        String res= db.addRecord(prodname1.getText().toString(),prod1.getText().toString());
//        Toast.makeText(this, res, Toast.LENGTH_SHORT).show();
//
//        prod1.setText("");
//        prodname1.setText("");
//    }

//    public void startdbapp(View view)
//    {
//        new Activity_DbManager(this);
//        startActivity(new Intent(this,.class));
//    }


}

//    public void onClick(View v) {
//        // 1) Possibly check for instance of first
//        Button b = (Button)v;
//        String buttonText = b.getText().toString();
//    }
//public void addRecord(View view)
//{
//    DbManager db=new DbManager(this);
//
//    String res=db.addRecord(t1.getText().toString(),t2.getText().toString(),t3.getText().toString());
//
//    Toast.makeText(this,res,Toast.LENGTH_LONG).show();
//
//    t1.setText("");
//    t2.setText("");
//    t3.setText("");
//}