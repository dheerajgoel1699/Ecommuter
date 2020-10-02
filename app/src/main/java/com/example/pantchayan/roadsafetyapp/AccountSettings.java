package com.example.pantchayan.roadsafetyapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class AccountSettings extends AppCompatActivity implements View.OnClickListener {
    Button bPassword;
    ProgressDialog dialog;
    Button bEmail;
    FirebaseAuth auth;
    ImageView iAcc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_settings);
        iAcc = (ImageView) findViewById(R.id.iAcc);
        iAcc.animate().alpha(1f).setDuration(1000).rotation(360f);

        bPassword = (Button) findViewById(R.id.bPassword);
        bEmail = (Button)findViewById(R.id.bEmail);

        bEmail.setOnClickListener(this);
        bPassword.setOnClickListener(this);
        dialog = new ProgressDialog(this);
        auth = FirebaseAuth.getInstance();
    }

    public void deactivate(View view){
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if(user!=null){
            dialog.setMessage("Deactivating user!!");
            dialog.show();
            user.delete().addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if(task.isSuccessful()){
                        dialog.dismiss();
                        Toast.makeText(AccountSettings.this, "Account Deactivated", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(AccountSettings.this,SignUp.class);
                        startActivity(intent);
                        finish();
                    }
                    else{
                        dialog.dismiss();
                        Toast.makeText(AccountSettings.this, "Problem occurred deactivating the account.", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }


    }
    public  void logout(View v){
        auth.signOut();
        startActivity((new Intent(this ,MainActivity.class)));
        Toast.makeText(this, "Successfully logged out!", Toast.LENGTH_SHORT).show();
        finish();

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.bPassword:
                startActivity((new Intent(this ,ChangePassword.class)));
                break;

            case R.id.bEmail:
                startActivity(new Intent(this,ChangeEmail.class));
                break;
        }
    }
}
