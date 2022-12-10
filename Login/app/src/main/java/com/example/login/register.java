package com.example.login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
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

public class register extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    EditText mFullName,mEmail,mPassword,mPhone;
    Button mRegisterBtn;
    TextView mLoginBtn;
    FirebaseAuth fAuth;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mFullName = findViewById(R.id.fullName);
        mEmail = findViewById(R.id.Email);
        mPassword = findViewById(R.id.password);
        mPhone = findViewById(R.id.phone);
        mRegisterBtn= findViewById(R.id.registerButton);
        mLoginBtn = findViewById(R.id.createText);
        fAuth = FirebaseAuth.getInstance();
        progressBar = findViewById(R.id.progressBar);
        if(fAuth.getCurrentUser() != null){
            startActivity(new Intent(getApplicationContext(),MainActivity.class));
            finish();
        }
    }

    public void onClickLoginFromRegister (View view){
        startActivity(new Intent(getApplicationContext(),login.class));
    }
    public void onClickRegister (View view){
        final String email = mEmail.getText().toString().trim();
        String password = mPassword.getText().toString().trim();
        if(TextUtils.isEmpty(email)){
            mEmail.setError("Email is Required.");
            return;
        }
        if(TextUtils.isEmpty(password)){
            mPassword.setError("Password is Required.");
            return;
        }
        if(password.length() < 6){
            mPassword.setError("Password Must be >= 6 Characters");
            return;
        }
        progressBar.setVisibility(View.VISIBLE);
// Now, we register the user in Firebase
        fAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {

            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(register.this, "User Created.", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getApplicationContext(),MainActivity.class));
                }else {
                    Toast.makeText(register.this, "Error ! " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    progressBar.setVisibility(View.GONE);
                }
            }
        });
    }
}