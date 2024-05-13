package com.example.nixbees;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Modern_Dashboard extends AppCompatActivity {

    CardView room1card,room2card,kitchencard,bathroomcard,livingroomcard,garencard;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_modern_dashboard);

        room1card = findViewById(R.id.room1card);
        room1card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Modern_Dashboard.this,Room1Activity.class);
                startActivity(intent);
            }
        });
        room2card = findViewById(R.id.room2card);
        room2card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Modern_Dashboard.this,Room2Activity.class);
                startActivity(intent);
            }
        });
        kitchencard = findViewById(R.id.kitchencard);
        kitchencard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Modern_Dashboard.this, kitchenActivity.class);
                startActivity(intent);
            }
        });
        bathroomcard = findViewById(R.id.bathroomcard);
        bathroomcard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Modern_Dashboard.this,bathroom.class);
                startActivity(intent);
            }
        });
       livingroomcard = findViewById(R.id.livingcard);
        livingroomcard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Modern_Dashboard.this,LivingActivity.class);
                startActivity(intent);
            }
        });
        garencard = findViewById(R.id.gardencard);
        garencard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Modern_Dashboard.this,GardenActivity.class);
                startActivity(intent);
            }
        });



    }
}