package com.example.myapplication;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

public class LoginActivity extends AppCompatActivity {
    EditText email;
    EditText password;
    AppCompatButton loginBtn;
    TextView signUp;
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initViews();

    }

    private void initViews(){
        email = findViewById(R.id.emailEt);
        password = findViewById(R.id.passwordEt);
        loginBtn = findViewById(R.id.btn);
        signUp = findViewById(R.id.signUpTw);
    }
}