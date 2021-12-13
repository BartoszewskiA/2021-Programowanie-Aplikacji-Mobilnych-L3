package com.example.lab07p01_ekranlogowania;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        TextView zalogowano = findViewById(R.id.textView01_a2);

        String s = getIntent().getStringExtra("kto");
        zalogowano.setText(s);
    }
}