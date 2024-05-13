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

public class GardenActivity extends AppCompatActivity {

    Switch light,sprink,camera,birds,bin,gate;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_garden);
        sharedPreferences = getSharedPreferences("SwitchStatus", MODE_PRIVATE);
        light = findViewById(R.id.light6);
        light.setChecked(sharedPreferences.getBoolean("light", false));
        light.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                saveSwitchStatus("light", isChecked);
                if(light.isChecked()){
                    Toast.makeText(GardenActivity.this,light.getTextOn().toString(),Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(GardenActivity.this,light.getTextOff().toString(),Toast.LENGTH_SHORT).show();
                }
            }
        });
        sprink = findViewById(R.id.Sprinkler);
        sprink.setChecked(sharedPreferences.getBoolean("sprink", false));
        sprink.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                saveSwitchStatus("sprink", isChecked);

                if(sprink.isChecked()){
                    Toast.makeText(GardenActivity.this,sprink.getTextOn().toString(),Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(GardenActivity.this,sprink.getTextOff().toString(),Toast.LENGTH_SHORT).show();
                }
            }
        });
       camera = findViewById(R.id.Camera);
        camera.setChecked(sharedPreferences.getBoolean("camera", false));
        camera.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                saveSwitchStatus("camera", isChecked);
                if(camera.isChecked()){
                    Toast.makeText(GardenActivity.this,camera.getTextOn().toString(),Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(GardenActivity.this,camera.getTextOff().toString(),Toast.LENGTH_SHORT).show();
                }
            }
        });
        birds = findViewById(R.id.birdfeeder);
        birds.setChecked(sharedPreferences.getBoolean("birds", false));
        birds.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                saveSwitchStatus("birds", isChecked);
                if(birds.isChecked()){
                    Toast.makeText(GardenActivity.this,birds.getTextOn().toString(),Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(GardenActivity.this,birds.getTextOff().toString(),Toast.LENGTH_SHORT).show();
                }
            }
        });
        bin = findViewById(R.id.CompostBin);
        bin.setChecked(sharedPreferences.getBoolean("bin", false));
        bin.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                saveSwitchStatus("bin", isChecked);
                if(bin.isChecked()){
                    Toast.makeText(GardenActivity.this,bin.getTextOn().toString(),Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(GardenActivity.this,bin.getTextOff().toString(),Toast.LENGTH_SHORT).show();
                }
            }
        });
        gate = findViewById(R.id.GateOpener);
        gate.setChecked(sharedPreferences.getBoolean("gate", false));

        gate.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                saveSwitchStatus("gate", isChecked);
                if(gate.isChecked()){
                    Toast.makeText(GardenActivity.this,gate.getTextOn().toString(),Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(GardenActivity.this,gate.getTextOff().toString(),Toast.LENGTH_SHORT).show();
                }
            }
        });
      Button editButton = findViewById(R.id.saveButton6);
        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to the activity_modern_dashboard.xml layout
                Intent intent = new Intent(GardenActivity.this, Modern_Dashboard.class);
                startActivity(intent);
            }
        });
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) ImageButton menuButton = findViewById(R.id.menuButton);
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
                    Intent intent = new Intent(GardenActivity.this, performanceActivity.class);
                    startActivity(intent);

                    return true;
                } else if (itemId == R.id.setalarm) {
                    // Handle Set Alarm menu item click
                    Toast.makeText(GardenActivity.this, "Set Alarm clicked", Toast.LENGTH_SHORT).show();
                    return true;
                } else if (itemId == R.id.logout) {
                    // Handle Logout menu item click
                    Intent intent = new Intent(GardenActivity.this, LoginActivity.class);
                    startActivity(intent);
                    return true;
                }
                return false;
            }
        });


        popupMenu.show();
    }


}