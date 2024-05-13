package com.example.nixbees;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class ProfileActivity extends AppCompatActivity {
    TextView profileName, profileEmail, profileUsername, profilePassword;
    TextView titleName, titleUsername;
    PieChart pieChart;
    String[] months={"January","February","March","April"};
    int[] energy={16000,20000,30000,50000};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        titleName = findViewById(R.id.titleName);

        showAllUserData();
       pieChart = findViewById(R.id.pie_chart);
        pieChart.setEntryLabelTextSize(14f);
        List<PieEntry> pieEntries = new ArrayList<>();
        for (int i = 0; i < months.length; i++) {
            pieEntries.add(new PieEntry(energy[i], months[i]));
        }
        PieDataSet pieDataSet = new PieDataSet(pieEntries, "Energy Consumption");
        pieDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        PieData pieData = new PieData(pieDataSet);
        pieChart.setData(pieData);
        pieChart.animateXY(5000, 5000);
        pieChart.getDescription().setEnabled(false);
        Button editButton = findViewById(R.id.editButton);
        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to the activity_modern_dashboard.xml layout
                Intent intent = new Intent(ProfileActivity.this, Modern_Dashboard.class);
                startActivity(intent);
            }
        });
    }


    public void showAllUserData(){
        Intent intent = getIntent();
        String nameUser = intent.getStringExtra("name");

        titleName.setText(nameUser);


    }


    }
