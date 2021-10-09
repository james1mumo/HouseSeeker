package com.dekut.houseseeker.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;

import com.dekut.houseseeker.MainActivity;
import com.dekut.houseseeker.databinding.ActivityLoginBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {
    private ActivityLoginBinding binding;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        firebaseAuth = FirebaseAuth.getInstance();

        binding.forgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //go to password reset
            }
        });
        binding.login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email_text = binding.email.getText().toString().trim();
                String password_text = binding.password.getText().toString().trim();
                if(TextUtils.isEmpty(email_text)){
                    binding.email.setError("Required");
                    binding.email.requestFocus();
                }
                if (TextUtils.isEmpty(password_text)){
                    binding.password.setError("Required");
                    binding.password.requestFocus();
                }
                firebaseAuth.signInWithEmailAndPassword(email_text, password_text).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                    FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
                    firebaseUser.getEmail();
                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                    finish();
                    }
                });
            }
        });
    }
}