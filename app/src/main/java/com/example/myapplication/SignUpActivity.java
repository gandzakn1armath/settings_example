package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {
    EditText firstNameEt;
    EditText lastNameEt;
    EditText emailEt;
    EditText passwordEt;
    AppCompatButton button;
    TextView loginTw;
    String firstName;
    String lastName;
    String password;
    String email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        initDatas();

        loginTw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignUpActivity.this,LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (validation()) {
                    SharedPreferences sp = getSharedPreferences("User", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putString("firstName", firstName);
                    editor.putString("email",email);
                    editor.putString("lastName",lastName);
                    editor.putString("password",password);
                    editor.apply();
                    openExampleActivity();
                }

            }
        });
    }

    private Boolean validation(){
        firstName = firstNameEt.getText().toString();
        lastName = lastNameEt.getText().toString();
        password = passwordEt.getText().toString();
        email= emailEt.getText().toString();

        if (firstName.isEmpty()){
            Toast.makeText(SignUpActivity.this, "Input first name", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (lastName.isEmpty()){
            Toast.makeText(SignUpActivity.this, "Input last name", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (email.isEmpty()){
            Toast.makeText(SignUpActivity.this, "Input email", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (password.isEmpty()){
            Toast.makeText(SignUpActivity.this, "Input password", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    private void openExampleActivity(){
        Intent intent = new Intent(SignUpActivity.this,ExampleActivity.class);
        startActivity(intent);
        finish();
    }

    private void initDatas(){
        firstNameEt = findViewById(R.id.firstNameEt);
        lastNameEt = findViewById(R.id.lastNameEt);
        emailEt = findViewById(R.id.emailEt);
        passwordEt = findViewById(R.id.passwordEt);
        button = findViewById(R.id.btn);
        loginTw = findViewById(R.id.loginTw);
    }

}