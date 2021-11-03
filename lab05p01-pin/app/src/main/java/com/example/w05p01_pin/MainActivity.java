package com.example.w05p01_pin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button p1,p2,p3,p4,p5,p6,p7,p8,p9,p10;
    TextView dostep;
    int[] tablicaMieszajaca;
    View.OnClickListener sluchacz;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        znajdzUchwyty();
        tablicaMieszajaca = new int[11]; //element zerowy nie jest używany
        losujTablice();
        przypisNazwyPrzyciskow();
        utworzSluchaczaZdarzen();
        dodajSluchaczaZdarzen();


    }

    private void utworzSluchaczaZdarzen() {
        sluchacz = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int Id = view.getId();
                switch(Id)
                {
                    case R.id.button01: break;
                }

            }
        };
    }

    private void dodajSluchaczaZdarzen() {
        p1.setOnClickListener(sluchacz);
        p2.setOnClickListener(sluchacz);
        p3.setOnClickListener(sluchacz);
        p4.setOnClickListener(sluchacz);
        p5.setOnClickListener(sluchacz);
        p6.setOnClickListener(sluchacz);
        p7.setOnClickListener(sluchacz);
        p8.setOnClickListener(sluchacz);
        p9.setOnClickListener(sluchacz);
        p10.setOnClickListener(sluchacz);
    }


    private void losujTablice() {
        Random random = new Random();
        int poz =1;
        while (poz<=10)
        {
           boolean powtorzenie = false;
            do {
                powtorzenie = false;
                tablicaMieszajaca[poz] = random.nextInt(10);
                for (int i=1; i<poz; i++)
                    if (tablicaMieszajaca[i]==tablicaMieszajaca[poz])
                        powtorzenie = true;
            } while(powtorzenie);
            poz++;
        }
    }

    private void znajdzUchwyty() {
        p1 = findViewById(R.id.button01);
        p2 = findViewById(R.id.button02);
        p3 = findViewById(R.id.button03);
        p4 = findViewById(R.id.button04);
        p5 = findViewById(R.id.button05);
        p6 = findViewById(R.id.button06);
        p7 = findViewById(R.id.button07);
        p8 = findViewById(R.id.button08);
        p9 = findViewById(R.id.button09);
        p10 = findViewById(R.id.button10);
        dostep = findViewById(R.id.dostep);
    }

    private void przypisNazwyPrzyciskow() {
        p1.setText(String.valueOf(tablicaMieszajaca[1]));
        p2.setText(String.valueOf(tablicaMieszajaca[2]));
        p3.setText(String.valueOf(tablicaMieszajaca[3]));
        p4.setText(String.valueOf(tablicaMieszajaca[4]));
        p5.setText(String.valueOf(tablicaMieszajaca[5]));
        p6.setText(String.valueOf(tablicaMieszajaca[6]));
        p7.setText(String.valueOf(tablicaMieszajaca[7]));
        p8.setText(String.valueOf(tablicaMieszajaca[8]));
        p9.setText(String.valueOf(tablicaMieszajaca[9]));
        p10.setText(String.valueOf(tablicaMieszajaca[10]));

    }
}