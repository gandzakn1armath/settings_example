package com.example.myapplication;

import static com.example.myapplication.Constants.BLUE;
import static com.example.myapplication.Constants.GREEN;
import static com.example.myapplication.Constants.RED;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    private  LinearLayout linearLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSaveColor();
        initViews();
    }

    private void getSaveColor() {
        SharedPreferences sp = getSharedPreferences("Test", Context.MODE_PRIVATE);
        setBackground(sp.getInt("color",RED));
    }

    private void initViews() {
        linearLayout = findViewById(R.id.layout);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_example,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.red:
                saveColor(RED);
                setBackground(RED);
                break;
            case R.id.green:
                saveColor(GREEN);
                setBackground(GREEN);
                break;
            case R.id.blue:
                saveColor( BLUE);
                setBackground(BLUE);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void saveColor(int color){
        SharedPreferences sp = getSharedPreferences("Test", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putInt("color",color).apply();
    }

    private void setBackground(int color){
        switch (color){
            case RED:
                linearLayout.setBackgroundResource(R.color.red);
                break;
            case GREEN:
                linearLayout.setBackgroundResource(R.color.green);
                break;
            case BLUE:
                linearLayout.setBackgroundResource(R.color.blue);
                break;
        }
    }
}