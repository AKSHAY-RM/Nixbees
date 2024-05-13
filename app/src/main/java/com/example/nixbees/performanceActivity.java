package com.example.nixbees;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class performanceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_performance);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) Button editButton = findViewById(R.id.back);
        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to the activity_modern_dashboard.xml layout
                Intent intent = new Intent(performanceActivity.this, Modern_Dashboard.class);
                startActivity(intent);
            }
        });

    }
}