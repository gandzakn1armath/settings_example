package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

public class LoginActivity extends AppCompatActivity {
    public static final String TAG = "LoginActivity";
    EditText emailEt;
    EditText passwordEt;
    AppCompatButton loginBtn;
    TextView signUp;
    SharedPreferences sharedPreferences ;
    String email;
    String password;
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initViews();
        sharedPreferences = getSharedPreferences("User", Context.MODE_PRIVATE);
        email = sharedPreferences.getString("email", "");
        password = sharedPreferences.getString("password", "");

        if(sharedPreferences.getBoolean("isLogin",false)){
            openExampleActivity();
        }

        signUp.setOnClickListener(view -> {
            openSignUpActivity();
        });
        loginBtn.setOnClickListener(view -> {
            validationFields();
        });
    }

    private void validationFields(){
        if (emailEt.getText().toString().isEmpty()) {
            showMessage("Input email");
            return;
        }
        if (passwordEt.getText().toString().isEmpty()) {
            showMessage("Input password!");
            return;
        }
        if (email.equals(emailEt.getText().toString()) && password.equals(passwordEt.getText().toString())) {
            sharedPreferences.edit().putBoolean("isLogin", true).apply();
            openExampleActivity();
        } else {
            showMessage("Uncorrect email or password");
        }

    }

    private void openExampleActivity() {
        Intent intent2 = new Intent(LoginActivity.this, ExampleActivity.class);
        startActivity(intent2);
        finish();
    }

    private void openSignUpActivity(){
        Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
        startActivity(intent);
        finish();
    }

    private void showMessage(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    private void initViews() {
        emailEt = findViewById(R.id.emailEt);
        passwordEt = findViewById(R.id.passwordEt);
        loginBtn = findViewById(R.id.btn);
        signUp = findViewById(R.id.signUpTw);
    }


}