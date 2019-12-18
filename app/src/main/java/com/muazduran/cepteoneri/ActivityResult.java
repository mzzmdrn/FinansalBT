package com.muazduran.cepteoneri;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ActivityResult extends AppCompatActivity {

    public ArrayList<PhoneInformation> brandFiltered_R = new ArrayList<>();
    private Button reSelect;
    ImageView imageView,imageView2;
    //private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    //private DatabaseReference databaseReference = firebaseDatabase.getReference();
   // private DatabaseReference first = databaseReference.child("img3");
   // private DatabaseReference SMG975FDS = databaseReference.child("SMG975F"); // String olan databasedeki isim. Filtreyi burda yap


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        getWindow().getDecorView().setBackgroundColor(Color.WHITE);
        getSupportActionBar().hide();

        // Maindeki listeyi results'ta alma
        Bundle bundleObject = getIntent().getExtras();
        brandFiltered_R = (ArrayList<PhoneInformation>) bundleObject.getSerializable("brandFilteredList");

        //imageView = findViewById(R.id.img3);
        //imageView2 = findViewById(R.id.img);

        reSelect = findViewById(R.id.reSelect);
        reSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityResult.this, ActivityMain.class);
                startActivity(intent);
            }
        });

    }

    private void sortArrayList (){
        Collections.sort(brandFiltered_R, new Comparator<PhoneInformation>() {
            @Override
            public int compare(PhoneInformation o1, PhoneInformation o2) {
                return 0;
            }
        });
    }

/*
    @Override
    protected void onStart() {
        super.onStart();
        first.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String link = dataSnapshot.getValue(String.class);
                Picasso.get().load(link).into(imageView);
           }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError){}
        });
        SMG975FDS.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String link = dataSnapshot.getValue(String.class);
                Picasso.get().load(link).into(imageView2);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }*/
}
