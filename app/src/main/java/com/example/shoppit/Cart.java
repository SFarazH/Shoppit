package com.example.shoppit;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class Cart extends AppCompatActivity {
    FirebaseFirestore firestore;
    FirebaseAuth auth;




        TextView price;
        @Override
        public void onCreate(Bundle savedStateInstance){
            super.onCreate(savedStateInstance);
            setContentView(R.layout.cart_activity);
            price = findViewById(R.id.price2);

            firestore = FirebaseFirestore.getInstance();
            auth = FirebaseAuth.getInstance();
            //String price = "100";
            String value = null ;

            Bundle extras = getIntent().getExtras();
            if (extras != null) {
                value = extras.getString("price1");
                //The key argument here must match that used in the other activity
            }
            price.setText(value);
            Button paynow;
            paynow = findViewById(R.id.paynow);
//            paynow.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    startActivity(new Intent(Cart.this, paymwnt.class));
//                }
//            });


            Map<String, String> map = new HashMap<>();
            map.put("userPrice", value);

            firestore.collection("CurrentUser").document(auth.getCurrentUser().getUid())
                    .collection("OrderPrice").add(map).addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
                        @Override
                        public void onComplete(@NonNull Task<DocumentReference> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(Cart.this, "Order Placed", Toast.LENGTH_SHORT).show();

                            } else {
                                Toast.makeText(Cart.this, "Error", Toast.LENGTH_SHORT).show();
                            }

                        }
                    });

//



        }
}
