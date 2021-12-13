package com.example.lab6p01_kasyno;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Spinner wyborGry;
    ImageView ramka;
    SeekBar suwak;
    TextView polePortfel, poleStawka , poleWylosowana;
    int gra = 0;
    int portfel = 100;
    int stawka = 0;
    int wylosowana;
    int[] rysunki = new int[] {R.drawable.r1, R.drawable.r2, R.drawable.r3, R.drawable.r4 };

    Random random;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        random = new Random();
        wyborGry = findViewById(R.id.wyborGry);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                                                                R.layout.support_simple_spinner_dropdown_item,
                                                                getResources().getStringArray(R.array.rodzaje_gier));
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        wyborGry.setAdapter(adapter);
        ramka = findViewById(R.id.ramka);
        suwak = findViewById(R.id.suwak);
        polePortfel = findViewById(R.id.potfel);
        poleStawka = findViewById(R.id.stawka);
        poleWylosowana = findViewById(R.id.wylosowana);
        dodajSluchaczeZdarzen();
    }

    private void dodajSluchaczeZdarzen() {
        wyborGry.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i)
                {
                    case 0: gra=0; break;
                    case 1: gra=1; break;
                    case 2: gra=2; break;
                    case 3: gra=3; break;
                }
                ramka.setImageResource(rysunki[gra]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        suwak.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                poleStawka.setText(String.valueOf(i));
                polePortfel.setText(String.valueOf(portfel-i));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        ramka.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                portfel = Integer.parseInt(polePortfel.getText().toString());
                stawka = Integer.parseInt(poleStawka.getText().toString());
                suwak.setMax(portfel);
                suwak.setProgress(0);
                poleStawka.setText("0");
                wylosowana = random.nextInt(65) + 1;
                poleWylosowana.setText(String.valueOf(wylosowana));

            }
        });
    }
}