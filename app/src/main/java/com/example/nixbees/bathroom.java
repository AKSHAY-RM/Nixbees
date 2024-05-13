package com.example.nixbees;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.Switch;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class bathroom extends AppCompatActivity {
    Switch light,geyser,blinds,speaker,washer,dryers;
    SharedPreferences sharedPreferences;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_bathroom);
        sharedPreferences = getSharedPreferences("SwitchStatus", MODE_PRIVATE);
        light = findViewById(R.id.light4);
        light.setChecked(sharedPreferences.getBoolean("light", false));
        light.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                saveSwitchStatus("light", isChecked);
                if(light.isChecked()){
                    Toast.makeText(bathroom.this,light.getTextOn().toString(),Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(bathroom.this,light.getTextOff().toString(),Toast.LENGTH_SHORT).show();
                }
            }
        });
        geyser = findViewById(R.id.geyser);
        geyser.setChecked(sharedPreferences.getBoolean("geyser", false));
        geyser.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                saveSwitchStatus("geyser", isChecked);
                if(geyser.isChecked()){
                    Toast.makeText(bathroom.this,geyser.getTextOn().toString(),Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(bathroom.this,geyser.getTextOff().toString(),Toast.LENGTH_SHORT).show();
                }
            }
        });
        blinds = findViewById(R.id.Blinds);
        blinds.setChecked(sharedPreferences.getBoolean("blinds", false));
        blinds.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                saveSwitchStatus("blinds", isChecked);
                if(blinds.isChecked()){
                    Toast.makeText(bathroom.this,blinds.getTextOn().toString(),Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(bathroom.this,blinds.getTextOff().toString(),Toast.LENGTH_SHORT).show();
                }
            }
        });
        speaker = findViewById(R.id.speakers);
        speaker.setChecked(sharedPreferences.getBoolean("speaker", false));
        speaker.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                saveSwitchStatus("speaker", isChecked);
                if(speaker.isChecked()){
                    Toast.makeText(bathroom.this,speaker.getTextOn().toString(),Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(bathroom.this,speaker.getTextOff().toString(),Toast.LENGTH_SHORT).show();
                }
            }
        });
        washer = findViewById(R.id.washer);
        washer.setChecked(sharedPreferences.getBoolean("washer", false));
        washer.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                saveSwitchStatus("washer", isChecked);
                if(washer.isChecked()){
                    Toast.makeText(bathroom.this,washer.getTextOn().toString(),Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(bathroom.this,washer.getTextOff().toString(),Toast.LENGTH_SHORT).show();
                }
            }
        });
        dryers = findViewById(R.id.dryer);
        dryers.setChecked(sharedPreferences.getBoolean("dryers", false));
        dryers.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                saveSwitchStatus("dryers", isChecked);
                if(dryers.isChecked()){
                    Toast.makeText(bathroom.this,dryers.getTextOn().toString(),Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(bathroom.this,dryers.getTextOff().toString(),Toast.LENGTH_SHORT).show();
                }
            }
        });
        Button editButton = findViewById(R.id.saveButton2);
        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to the activity_modern_dashboard.xml layout
                Intent intent = new Intent(bathroom.this, Modern_Dashboard.class);
                startActivity(intent);
            }
        });

        ImageButton menuButton = findViewById(R.id.menuButton);
        menuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopupMenu(v);
            }
        });
    }
    private void saveSwitchStatus(String switchKey, boolean isChecked) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(switchKey, isChecked);
        editor.apply();
    }
    private void showPopupMenu(View v) {
        PopupMenu popupMenu = new PopupMenu(this, v);
        popupMenu.getMenuInflater().inflate(R.menu.popup_menu, popupMenu.getMenu());

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                int itemId = item.getItemId();
                if (itemId == R.id.performance) {
                    Intent intent = new Intent(bathroom.this, performanceActivity.class);
                    startActivity(intent);

                    return true;
                } else if (itemId == R.id.setalarm) {
                    // Handle Set Alarm menu item click
                    Toast.makeText(bathroom.this, "Set Alarm clicked", Toast.LENGTH_SHORT).show();
                    return true;
                } else if (itemId == R.id.logout) {
                    // Handle Logout menu item click
                    Intent intent = new Intent(bathroom.this, LoginActivity.class);
                    startActivity(intent);
                    return true;
                }
                return false;
            }
        });


        popupMenu.show();
    }


}