package com.example.pantchayan.roadsafetyapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Emergency extends AppCompatActivity implements View.OnClickListener {

    Button bPolice;
    Button bAmbulance;
    ImageView iAmb;
    ImageView iPol;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emergency);
        iAmb = (ImageView)findViewById(R.id.iAmb);
        iPol = (ImageView)findViewById(R.id.iPol);


        Button bPolice = (Button) findViewById(R.id.bPolice);
        Button bAmbulance = (Button) findViewById(R.id.bAmbulance);

        bAmbulance.setOnClickListener(this);
        bPolice.setOnClickListener(this);
        iAmb.animate().alpha(1f).setDuration(2000);
        iPol.animate().alpha(1f).setDuration(2000);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.bAmbulance: {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:102"));
                startActivity(intent);
                break;
            }
            case R.id.bPolice: {
                Intent intent2 = new Intent(Intent.ACTION_DIAL);

                intent2.setData(Uri.parse("tel:100"));
                startActivity(intent2);
                break;
            }
        }
    }
}
