package com.example.shoppit;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class HomePageActivity extends AppCompatActivity {

    FirebaseAuth auth;
    FirebaseFirestore firestore;
    Button clothing, elec, books;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        clothing = (Button)findViewById(R.id.btn_clothing);
        elec = (Button)findViewById(R.id.button2);
        books = (Button)findViewById(R.id.button3);

        clothing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomePageActivity.this,Clothing.class);
                startActivity(intent);




//            String finalS = "Final string";
//                Map<String, String> map = new HashMap<>();
//                map.put("userAddress", finalS);
//
//
//                firestore.collection("CurrentUser").document(auth.getCurrentUser().getUid())
//                        .collection("Address").add(map).addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
//                            @Override
//                            public void onComplete(@NonNull Task<DocumentReference> task) {
//                                if (task.isSuccessful()) {
//                                    Toast.makeText(HomePageActivity.this, "Address Added", Toast.LENGTH_SHORT).show();
//                                } else {
//                                    Toast.makeText(HomePageActivity.this, "Please fill all the fields", Toast.LENGTH_SHORT).show();
//                                }
//                            }
//                        });
//
//                firestore.collection("CurrentUser").document(auth.getCurrentUser().getUid())
//                        .collection("Address").add(map)
//                        .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
//                            @Override
//                            public void onSuccess(DocumentReference documentReference) {
//                                Toast.makeText(HomePageActivity.this, "Order has been added", Toast.LENGTH_SHORT).show();
//                            }
//                        })
//                        .addOnFailureListener(new OnFailureListener() {
//                            @Override
//                            public void onFailure(@NonNull Exception e) {
//                                Toast.makeText(HomePageActivity.this, "ERROR", Toast.LENGTH_SHORT).show();
//                            }
//                        });

            }
        });

    }
}
