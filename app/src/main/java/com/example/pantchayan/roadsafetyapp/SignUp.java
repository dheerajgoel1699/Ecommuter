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
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;

public class SignUp extends AppCompatActivity implements View.OnClickListener{

    EditText etName , etUsername , etEmail , etPassword ;
    TextView tvLogin;
    Button bRegister;
    private FirebaseAuth mAuth;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        bRegister  = (Button) findViewById(R.id.bRegister);
        etUsername = (EditText) findViewById(R.id.etUsername);
        etName = (EditText) findViewById(R.id.etName);
        etPassword = (EditText) findViewById(R.id.etCPassword);
        etEmail = (EditText) findViewById(R.id.etEmail);
        progressBar = (ProgressBar) findViewById(R.id.progressBar2);
        tvLogin = (TextView) findViewById(R.id.loginTvLink);


        mAuth = FirebaseAuth.getInstance();
        tvLogin.setOnClickListener(this);
        bRegister.setOnClickListener(this);
    }

    public  void RegsiterUser(){
        String name = etName.getText().toString();

        String password =etPassword.getText().toString();

        String email = etEmail.getText().toString();

        String username = etUsername.getText().toString();

        if(email.isEmpty()|name.isEmpty()|password.isEmpty()|username.isEmpty()){
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
        mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                progressBar.setVisibility(View.GONE);
                if(task.isSuccessful()){
                    Toast.makeText(SignUp.this, "User Registered Successfully.", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(SignUp.this,HomePage.class);
                    //we are doing this so that when the user presses the back button the previous activity doesn't open up.
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);

                }
                else{
                    if(task.getException() instanceof FirebaseAuthUserCollisionException){
                        Toast.makeText(SignUp.this, "Email is already registered.", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(SignUp.this, "Some error occurred.", Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });



    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.bRegister:
            RegsiterUser();

                break;
            case R.id.loginTvLink:
                startActivity(new Intent(this, MainActivity.class));
        }
    }
}
