package com.example.pantchayan.roadsafetyapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.EmailAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ChangeEmail extends AppCompatActivity {

    EditText et,etC,etP;
    FirebaseAuth auth;
    ProgressDialog dialog;
    ImageView iEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_email);
        iEmail = (ImageView)findViewById(R.id.iEmail);
        iEmail.animate().alpha(1f).setDuration(1000).rotation(360f);

        et = (EditText)findViewById(R.id.etCEmail);
        etC = (EditText)findViewById(R.id.etCurrent);
        etP = (EditText)findViewById(R.id.etPass);

        auth = FirebaseAuth.getInstance();

        dialog = new ProgressDialog(this);


    }

    public void change(View v){
        dialog.setMessage("Changing Email, please wait!!!");
        dialog.show();
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        // Get auth credentials from the user for re-authentication
        AuthCredential credential = EmailAuthProvider
                .getCredential(etC.getText().toString(), etP.getText().toString()); // Current Login Credentials \\
        // Prompt the user to re-provide their sign-in credentials
        user.reauthenticate(credential)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {

                        //Now change your email address \\
                        //----------------Code for Changing Email Address----------\\
                        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                        user.updateEmail(et.getText().toString())
                                .addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        if (task.isSuccessful()) {
                                           dialog.dismiss();
                                            Toast.makeText(ChangeEmail.this, "Email is successfully changed!", Toast.LENGTH_SHORT).show();
                                        }
                                        else{
                                            dialog.dismiss();
                                            Toast.makeText(ChangeEmail.this, "An error occurred while changing email! Please enter credentials carefully.", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                });
                        //----------------------------------------------------------\\
                    }
                });


    }
}
