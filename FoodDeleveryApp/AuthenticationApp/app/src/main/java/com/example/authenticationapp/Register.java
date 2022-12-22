package com.example.authenticationapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
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
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;

public class Register extends AppCompatActivity {

    TextView alreadyHaveAccount;

    private static final String TAG = MainActivity.class.getSimpleName();
    EditText mFullName,mEmail,mPassword,confirmPassword;
    Button mRegisterBtn;
    FirebaseAuth fAuth;
    ProgressBar progressBar;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        alreadyHaveAccount = findViewById(R.id.alreadyHaveAccount);
        mRegisterBtn = findViewById(R.id.btnRegister);

        mFullName = findViewById(R.id.fullName);
        mEmail = findViewById(R.id.registerEmail);
        mPassword = findViewById(R.id.registerPassword);
        confirmPassword = findViewById(R.id.confirmPassword);
        progressBar = findViewById(R.id.progressBar);


        alreadyHaveAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Register.this,Login.class);
                startActivity(intent);
            }
        });

        mRegisterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fullName, email,password, confPassword;

                fullName = mFullName.getText().toString();
                email = mEmail.getText().toString();
                password = mPassword.getText().toString();
                confPassword = confirmPassword.getText().toString();

                if (TextUtils.isEmpty(fullName)){
                    mFullName.setError("Please Add Fullname!");
                    return;
                }

                if (TextUtils.isEmpty(email)){
                    mEmail.setError("Email is required!");
                    return;
                }

                if (!email.matches(emailPattern)){
                    mEmail.setError("Enter Correct Email!");
                    return;
                }
                if (TextUtils.isEmpty(password)){
                    mPassword.setError("Password is empty!");
                    return;
                }
                if (!TextUtils.equals(password,confPassword)){
                    confirmPassword.setError("Passwords didn't match");
                    return;
                }




                System.out.println("you are in 1");

                fAuth = FirebaseAuth.getInstance();
                System.out.println(fAuth);
                System.out.println("you are in 2");
                progressBar.setVisibility(View.VISIBLE);
                System.out.println("you are in 3");
//                if(fAuth.getCurrentUser()!= null){
//                    startActivity(new Intent(getApplicationContext(),Login.class));
//                    System.out.println("you are in 4");
//                    finish();
//                }
                System.out.println("you are in 5");
                fAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
//                    System.out.println("you are in before 6");
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        System.out.println("you are in 6");
                        if (task.isSuccessful()) {

                            FirebaseUser user1 = FirebaseAuth.getInstance().getCurrentUser();

                            UserProfileChangeRequest profileUpdates = new UserProfileChangeRequest.Builder()
                                    .setDisplayName(fullName)
                                    .build();
                            user1.updateProfile(profileUpdates)
                                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {
                                            if (task.isSuccessful()) {
                                                Log.d(TAG, "User profile updated.");
                                            }
                                        }
                                    });

                            System.out.println("you are in 7");
                            Toast.makeText(Register.this,"User created!",Toast.LENGTH_LONG).show();
                            progressBar.setVisibility(View.GONE);
                            startActivity(new Intent(getApplicationContext(),UserHomePage.class));
                        }else {
                            System.out.println("you are in 8");
                            Toast.makeText(Register.this,"error!"+task.getException().getLocalizedMessage(),Toast.LENGTH_SHORT).show();
                            progressBar.setVisibility(View.GONE);
                        }
                    }
                });
            }
        });
        
        
    }
}