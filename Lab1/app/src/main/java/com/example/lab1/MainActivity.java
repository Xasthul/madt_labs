package com.example.lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView label1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.label1 = findViewById(R.id.label1);
    }

    public void OnButton1Click(View view) {
        this.label1.setText("Text was changed!");
    }
}