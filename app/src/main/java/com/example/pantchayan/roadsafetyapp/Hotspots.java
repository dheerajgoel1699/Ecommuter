package com.example.pantchayan.roadsafetyapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.Locale;

public class Hotspots extends AppCompatActivity {

    ImageView i1,i2,i3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotspots);

        i1=(ImageView)findViewById(R.id.i1);
        i2=(ImageView)findViewById(R.id.i2);
        i3=(ImageView)findViewById(R.id.i3);
        i1.animate().alpha(1f).setDuration(2000);
        i2.animate().alpha(1f).setDuration(2000);
        i3.animate().alpha(1f).setDuration(2000);
    }

    public void kDetails(View v){
        AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setTitle("Kasna 8-lane cross section");
        alertDialog.setMessage("The 8 lane cross section with high speed vehicles and no working traffic signals makes it difficult for the vehicles to pass by." );
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();
    }
    public void pDetails(View v){
        AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setTitle("Pi sector cross section");
        alertDialog.setMessage("Blind cross section meets a main road with high speed vehicles making the area very prone to accidents.");
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();
    }
    public void nDetails(View v){
        AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setTitle("Bridge near P3 round-about");
        alertDialog.setMessage("Narrow bridge alongside of a blind intersection in continuation of a highway makes it difficult for the vehicles to pass-by.");
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();
    }

    public void parichowk(View view){
        String uri = String.format(Locale.ENGLISH, "geo:%f,%f", 28.4639, 77.5098);
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
        startActivity(intent);


    }

    public void kasnaCross(View view){
        String uri = String.format(Locale.ENGLISH, "geo:%f,%f", 28.446733 ,77.529352);
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
        startActivity(intent);



    }
    public void p3Cross(View view){
        String uri = String.format(Locale.ENGLISH, "geo:%f,%f", 28.452994 ,77.516150);
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
        startActivity(intent);

    }
    public void narrowBridge(View view){
        String uri = String.format(Locale.ENGLISH, "geo:%f,%f", 28.456567, 77.518818);
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
        startActivity(intent);
    }
}

