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
import androidx.appcompat.app.AppCompatActivity;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Room2Activity extends AppCompatActivity {
    Switch iswitch,fans,acs,tvs,bls,curtains;
    SharedPreferences sharedPreferences;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_room2);
        sharedPreferences = getSharedPreferences("SwitchStatus", MODE_PRIVATE);

        iswitch = findViewById(R.id.light2);
        fans = findViewById(R.id.fan2);
        acs = findViewById(R.id.ac2);
        tvs = findViewById(R.id.tv2);
        bls = findViewById(R.id.bedlamp2);
        curtains = findViewById(R.id.Curtain2);

        // Restore switch statuses from SharedPreferences
        iswitch.setChecked(sharedPreferences.getBoolean("iswitch", false));
        fans.setChecked(sharedPreferences.getBoolean("fans", false));
        acs.setChecked(sharedPreferences.getBoolean("acs", false));
        tvs.setChecked(sharedPreferences.getBoolean("tvs", false));
        bls.setChecked(sharedPreferences.getBoolean("bls", false));
        curtains.setChecked(sharedPreferences.getBoolean("curtains", false));


        iswitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                saveSwitchStatus("iswitch", isChecked);
                if(iswitch.isChecked()){
                    Toast.makeText(Room2Activity.this,iswitch.getTextOn().toString(),Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(Room2Activity.this,iswitch.getTextOff().toString(),Toast.LENGTH_SHORT).show();
                }
            }
        });

        fans.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                saveSwitchStatus("fans", isChecked);
                if(fans.isChecked()){
                    Toast.makeText(Room2Activity.this,fans.getTextOn().toString(),Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(Room2Activity.this,fans.getTextOff().toString(),Toast.LENGTH_SHORT).show();
                }
            }
        });

        acs.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                saveSwitchStatus("acs", isChecked);
                if(acs.isChecked()){
                    Toast.makeText(Room2Activity.this,acs.getTextOn().toString(),Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(Room2Activity.this,acs.getTextOff().toString(),Toast.LENGTH_SHORT).show();
                }
            }
        });

        tvs.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                saveSwitchStatus("tvs", isChecked);
                if(tvs.isChecked()){
                    Toast.makeText(Room2Activity.this,tvs.getTextOn().toString(),Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(Room2Activity.this,tvs.getTextOff().toString(),Toast.LENGTH_SHORT).show();
                }
            }
        });

        bls.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                saveSwitchStatus("bls",isChecked);
                if(bls.isChecked()){
                    Toast.makeText(Room2Activity.this,bls.getTextOn().toString(),Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(Room2Activity.this,bls.getTextOff().toString(),Toast.LENGTH_SHORT).show();
                }
            }
        });

        curtains.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {


            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                saveSwitchStatus("curtains",isChecked);
                if(curtains.isChecked()){
                    Toast.makeText(Room2Activity.this,curtains.getTextOn().toString(),Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(Room2Activity.this,curtains.getTextOff().toString(),Toast.LENGTH_SHORT).show();
                }
            }
        });
        Button editButton = findViewById(R.id.saveButton2);
        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to the activity_modern_dashboard.xml layout
                Intent intent = new Intent(Room2Activity.this, Modern_Dashboard.class);
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
                    Intent intent = new Intent(Room2Activity.this, performanceActivity.class);
                    startActivity(intent);

                    return true;
                } else if (itemId == R.id.setalarm) {
                    // Handle Set Alarm menu item click
                    Toast.makeText(Room2Activity.this, "Set Alarm clicked", Toast.LENGTH_SHORT).show();
                    return true;
                } else if (itemId == R.id.logout) {
                    // Handle Logout menu item click
                    Intent intent = new Intent(Room2Activity.this, LoginActivity.class);
                    startActivity(intent);
                    return true;
                }
                return false;
            }
        });


        popupMenu.show();
    }


}