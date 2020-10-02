package com.example.pantchayan.roadsafetyapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomePage extends AppCompatActivity implements View.OnClickListener {

    Button bAccount;
    Button bEmergency;
    Button bHotspots;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        bAccount = (Button) findViewById(R.id.bAccount);
        bAccount.setOnClickListener(this);
        bEmergency = (Button) findViewById(R.id.bEmergency);
        bEmergency.setOnClickListener(this);
        bHotspots = (Button)findViewById(R.id.bHotspots);
        bHotspots.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.bAccount:
                startActivity(new Intent(this,AccountSettings.class));
                break;

            case R.id.bEmergency:
                startActivity((new Intent(this ,Emergency.class)));
                break;

            case R.id.bHotspots:
                startActivity(new Intent(this,Hotspots.class));
                break;


        }
    }
}


