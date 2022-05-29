package com.example.myapplication;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ExampleActivity extends AppCompatActivity {
    EditText numEdt;
    Button btn;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numEdt = findViewById(R.id.num);
        btn = findViewById(R.id.btn);

        SharedPreferences sp = getSharedPreferences("Test", Context.MODE_PRIVATE);
        int myNum = sp.getInt("integerKey",0);
        Toast.makeText(ExampleActivity.this,(myNum+""),Toast.LENGTH_SHORT).show();
        Log.e("TAG", "onCreate: "+myNum );
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = sp.edit();
                editor.putInt("integerKey",Integer.parseInt(numEdt.getText().toString())).apply();
            }
        });
    }
}