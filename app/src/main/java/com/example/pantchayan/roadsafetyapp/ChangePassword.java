package com.example.pantchayan.roadsafetyapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ChangePassword extends AppCompatActivity {
    EditText etCPassword;
    FirebaseAuth auth;
    ProgressDialog dialog;
    ImageView iLock;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);
        etCPassword = (EditText)findViewById(R.id.etCPassword);
        auth = FirebaseAuth.getInstance();

        dialog = new ProgressDialog(this);

        iLock = (ImageView)findViewById(R.id.iLock);

        iLock.animate().alpha(1f).setDuration(1000).rotation(360f);


    }
    public void change(View v){
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();


        if(user!=null){
            dialog.setMessage("Changing Password, please wait!!!");
            dialog.show();

            user.updatePassword(etCPassword.getText().toString()).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if(task.isSuccessful()){
                        dialog.dismiss();
                        Toast.makeText(ChangePassword.this, "Password is changed.", Toast.LENGTH_SHORT).show();
                        auth.signOut();
                        finish();
                        Intent intent = new Intent(ChangePassword.this,MainActivity.class);
                        startActivity(intent);

                    }
                    else{
                        dialog.dismiss();
                        Toast.makeText(ChangePassword.this, "Password could not be changed.", Toast.LENGTH_SHORT).show();
                    }
                }
            });

        }


    }
}
