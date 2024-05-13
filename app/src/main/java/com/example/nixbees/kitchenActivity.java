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

public class kitchenActivity extends AppCompatActivity {
    Switch light,stove,freez,wash,oven,exhaust;
    SharedPreferences sharedPreferences;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_kitchen);
        sharedPreferences = getSharedPreferences("SwitchStatus", MODE_PRIVATE);

        light = findViewById(R.id.light3);
        light.setChecked(sharedPreferences.getBoolean("light", false));
        light.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(light.isChecked()){
                    saveSwitchStatus("light", isChecked);
                    Toast.makeText(kitchenActivity.this,light.getTextOn().toString(),Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(kitchenActivity.this,light.getTextOff().toString(),Toast.LENGTH_SHORT).show();
                }
            }
        });
        stove = findViewById(R.id.stove);
        stove.setChecked(sharedPreferences.getBoolean("stove", false));
        stove.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(stove.isChecked()){
                    saveSwitchStatus("stove", isChecked);
                    Toast.makeText(kitchenActivity.this,stove.getTextOn().toString(),Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(kitchenActivity.this,stove.getTextOff().toString(),Toast.LENGTH_SHORT).show();
                }
            }
        });
        freez = findViewById(R.id.Refrigerator);
        freez.setChecked(sharedPreferences.getBoolean("freez", false));
        freez.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                saveSwitchStatus("freez", isChecked);
                if(freez.isChecked()){
                    Toast.makeText(kitchenActivity.this,freez.getTextOn().toString(),Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(kitchenActivity.this,freez.getTextOff().toString(),Toast.LENGTH_SHORT).show();
                }
            }
        });
        wash = findViewById(R.id.Dishwasher);
        wash.setChecked(sharedPreferences.getBoolean("wash", false));
        wash.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                saveSwitchStatus("wash", isChecked);
                if(wash.isChecked()){
                    Toast.makeText(kitchenActivity.this,wash.getTextOn().toString(),Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(kitchenActivity.this,wash.getTextOff().toString(),Toast.LENGTH_SHORT).show();
                }
            }
        });
        oven = findViewById(R.id.Oven);
        oven.setChecked(sharedPreferences.getBoolean("oven", false));
        oven.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                saveSwitchStatus("oven", isChecked);
                if(oven.isChecked()){
                    Toast.makeText(kitchenActivity.this,oven.getTextOn().toString(),Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(kitchenActivity.this,oven.getTextOff().toString(),Toast.LENGTH_SHORT).show();
                }
            }
        });
        exhaust = findViewById(R.id.ExhaustFan);
        exhaust.setChecked(sharedPreferences.getBoolean("exhaust", false));
        exhaust.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                saveSwitchStatus("exhaust", isChecked);
                if(exhaust.isChecked()){
                    Toast.makeText(kitchenActivity.this,exhaust.getTextOn().toString(),Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(kitchenActivity.this,exhaust.getTextOff().toString(),Toast.LENGTH_SHORT).show();
                }
            }
        });
        Button editButton = findViewById(R.id.saveButton2);
        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to the activity_modern_dashboard.xml layout
                Intent intent = new Intent(kitchenActivity.this, Modern_Dashboard.class);
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
                    Intent intent = new Intent(kitchenActivity.this, performanceActivity.class);
                    startActivity(intent);

                    return true;
                } else if (itemId == R.id.setalarm) {
                    // Handle Set Alarm menu item click
                    Toast.makeText(kitchenActivity.this, "Set Alarm clicked", Toast.LENGTH_SHORT).show();
                    return true;
                } else if (itemId == R.id.logout) {
                    // Handle Logout menu item click
                    Intent intent = new Intent(kitchenActivity.this, LoginActivity.class);
                    startActivity(intent);
                    return true;
                }
                return false;
            }
        });


        popupMenu.show();
    }


}