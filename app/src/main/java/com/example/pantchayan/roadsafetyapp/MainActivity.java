package com.example.pantchayan.roadsafetyapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button bLogin;
    EditText etEmail , etPassword ;
    private FirebaseAuth mAuth;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etPassword = (EditText) findViewById(R.id.etCPassword);
        bLogin = (Button) findViewById(R.id.bLogin);

        findViewById(R.id.tvRegisterLink).setOnClickListener(this);
        bLogin.setOnClickListener(this);
        mAuth = FirebaseAuth.getInstance();
        progressBar = (ProgressBar) findViewById(R.id.progressBar2);
    }
    public void userLogin(){
        String password =etPassword.getText().toString();

        String email = etEmail.getText().toString();


        if(email.isEmpty()|password.isEmpty()){
            Toast.makeText(this, "Please enter all the details.", Toast.LENGTH_LONG).show();
            return;
        }

        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            etEmail.setError("Please enter a valid Email");
            etEmail.requestFocus();
            return;
        }
        if(password.length()<6){
            etPassword.setError("Minimum length of the password should be 6");
            etPassword.requestFocus();
            return;
        }
        progressBar.setVisibility(View.VISIBLE);

        mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                progressBar.setVisibility(View.GONE);
                if(task.isSuccessful()){
                    Intent intent = new Intent(MainActivity.this,HomePage.class);
                    //we are doing this so that when the user presses the back button the previous activity doesn't open up.
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                    Toast.makeText(MainActivity.this, "Successfully logged in!", Toast.LENGTH_SHORT).show();

                }else{
                    Toast.makeText(MainActivity.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tvRegisterLink:
                startActivity(new Intent(this,SignUp.class));
                break;
            case R.id.bLogin:
                userLogin();
                break;
        }
    }
}

