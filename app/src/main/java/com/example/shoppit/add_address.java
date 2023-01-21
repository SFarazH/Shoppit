package com.example.shoppit;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class add_address extends AppCompatActivity{
    EditText name, address,city, pincode, phoneNo;
    Toolbar toolbar;
    Button addAddrBtn;

    FirebaseFirestore firestore;
    FirebaseAuth auth;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_address);
        auth = FirebaseAuth.getInstance();
        firestore = FirebaseFirestore.getInstance();

//        toolbar = findViewById(R.id.add_address_toolbar);
//        setSupportActionBar(toolbar);
        //      getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        name = findViewById(R.id.ad_name);
        address = findViewById(R.id.ad_address);
        city = findViewById(R.id.ad_city);
        phoneNo = findViewById(R.id.ad_phone);
        pincode = findViewById(R.id.ad_code);
        addAddrBtn = findViewById(R.id.ad_add_address);

        addAddrBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = name.getText().toString();
                String userCity = name.getText().toString();
                String userAddr = address.getText().toString();
                String userPinCode = pincode.getText().toString();
                String userPhone = phoneNo.getText().toString();

                String final_address = "";

                if (!userName.isEmpty()) {
                    final_address += userName;
                }
                if (!userCity.isEmpty()) {
                    final_address += "," + userCity;
                }
                if (!userAddr.isEmpty()) {
                    final_address += "," + userAddr;
                }
                if (!userPinCode.isEmpty()) {
                    final_address += "," + userPinCode;
                }
                if (!userPhone.isEmpty()) {
                    final_address += "," + userPhone;
                }

                String value = "0";

                Bundle extras = getIntent().getExtras();
                if (extras != null) {
                    value = extras.getString("price1");
                    //The key argument here must match that used in the other activity
                }

                String value2 = value;
                Intent i2 = new Intent();


                Map<String, String> map = new HashMap<>();
                map.put("userAddress", final_address);

                firestore.collection("CurrentUser").document(auth.getCurrentUser().getUid())
                        .collection("Address").add(map).addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
                            @Override
                            public void onComplete(@NonNull Task<DocumentReference> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(add_address.this, "Address Added", Toast.LENGTH_SHORT).show();

                                    Intent i2 = new Intent(add_address.this,Cart.class );
                                    i2.putExtra("price1",value2);
                                    startActivity(i2);
                                } else {
                                    Toast.makeText(add_address.this, "Please fill all the fields", Toast.LENGTH_SHORT).show();
                                }

                            }
                        });


            }
        });
    }
}