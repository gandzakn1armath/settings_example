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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        initDatas();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String firstName = firstNameEt.getText().toString();
                String lastName = lastNameEt.getText().toString();
                String password = passwordEt.getText().toString();
                String email = emailEt.getText().toString();
                if (firstName.isEmpty()){
                    Toast.makeText(SignUpActivity.this, "Input first name", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (lastName.isEmpty()){
                    Toast.makeText(SignUpActivity.this, "Input last name", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (email.isEmpty()){
                    Toast.makeText(SignUpActivity.this, "Input email", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (password.isEmpty()){
                    Toast.makeText(SignUpActivity.this, "Input password", Toast.LENGTH_SHORT).show();
                    return;
                }
                SharedPreferences sp = getSharedPreferences("User", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();
                editor.putString("firstName", firstName);
                editor.putString("email",email);
                editor.putString("lastName",lastName);
                editor.putString("password",password);
                editor.apply();

                Intent intent = new Intent(SignUpActivity.this,ExampleActivity.class);
                startActivity(intent);
            }
        });
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