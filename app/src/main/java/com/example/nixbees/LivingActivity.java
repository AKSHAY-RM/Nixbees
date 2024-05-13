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

public class LivingActivity extends AppCompatActivity {
    Switch light,light2,thermo,door,projector,cutain;
    SharedPreferences sharedPreferences;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_living);
        sharedPreferences = getSharedPreferences("SwitchStatus", MODE_PRIVATE);
        light = findViewById(R.id.light5);
        light.setChecked(sharedPreferences.getBoolean("light", false));
        light.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                saveSwitchStatus("light", isChecked);
                if(light.isChecked()){
                    Toast.makeText(LivingActivity.this,light.getTextOn().toString(),Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(LivingActivity.this,light.getTextOff().toString(),Toast.LENGTH_SHORT).show();
                }
            }
        });
        light2 = findViewById(R.id.ceiling);
        light2.setChecked(sharedPreferences.getBoolean("light2", false));
        light2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                saveSwitchStatus("light2", isChecked);
                if(light.isChecked()){
                    Toast.makeText(LivingActivity.this,light2.getTextOn().toString(),Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(LivingActivity.this,light2.getTextOff().toString(),Toast.LENGTH_SHORT).show();
                }
            }
        });
        thermo = findViewById(R.id.thermostat);
        thermo.setChecked(sharedPreferences.getBoolean("thermo", false));
        thermo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                saveSwitchStatus("thermo", isChecked);
                if(thermo.isChecked()){
                    Toast.makeText(LivingActivity.this,thermo.getTextOn().toString(),Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(LivingActivity.this,thermo.getTextOff().toString(),Toast.LENGTH_SHORT).show();
                }
            }
        });
        door = findViewById(R.id.Door);
        door.setChecked(sharedPreferences.getBoolean("door", false));
        door.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                saveSwitchStatus("door", isChecked);
                if(door.isChecked()){
                    Toast.makeText(LivingActivity.this,door.getTextOn().toString(),Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(LivingActivity.this,door.getTextOff().toString(),Toast.LENGTH_SHORT).show();
                }
            }
        });
        projector = findViewById(R.id.Projector);
        projector.setChecked(sharedPreferences.getBoolean("projector", false));
        projector.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                saveSwitchStatus("projector", isChecked);
                if(projector.isChecked()){
                    Toast.makeText(LivingActivity.this,projector.getTextOn().toString(),Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(LivingActivity.this,projector.getTextOff().toString(),Toast.LENGTH_SHORT).show();
                }
            }
        });
        cutain = findViewById(R.id.Curtain2);
        cutain.setChecked(sharedPreferences.getBoolean("curtain", false));
        cutain.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                saveSwitchStatus("cutain", isChecked);
                if(cutain.isChecked()){
                    Toast.makeText(LivingActivity.this,cutain.getTextOn().toString(),Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(LivingActivity.this,cutain.getTextOff().toString(),Toast.LENGTH_SHORT).show();
                }
            }
        });
        Button editButton = findViewById(R.id.saveButton5);
        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to the activity_modern_dashboard.xml layout
                Intent intent = new Intent(LivingActivity.this, Modern_Dashboard.class);
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
                    Intent intent = new Intent(LivingActivity.this, performanceActivity.class);
                    startActivity(intent);

                    return true;
                } else if (itemId == R.id.setalarm) {
                    // Handle Set Alarm menu item click
                    Toast.makeText(LivingActivity.this, "Set Alarm clicked", Toast.LENGTH_SHORT).show();
                    return true;
                } else if (itemId == R.id.logout) {
                    // Handle Logout menu item click
                    Intent intent = new Intent(LivingActivity.this, LoginActivity.class);
                    startActivity(intent);
                    return true;
                }
                return false;
            }
        });


        popupMenu.show();
    }


}