package com.example.lab03p01_atlas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ImageView ramka;
    TextView opis;
    int pozycja = 0;
    int[] obrazki = new int[] {
          R.drawable.borowik,
          R.drawable.pieczarka,
          R.drawable.muchomor
    };
    String[] opisy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ramka = findViewById(R.id.ramka);
        ramka.setImageResource(obrazki[pozycja]);
        opis = findViewById(R.id.opis);
        opisy = getResources().getStringArray(R.array.opisy);
        opis.setText(opisy[pozycja]);
    }

    public void wstecz(View view) {
        pozycja--;
        if (pozycja<0) pozycja = 2;
        ramka.setImageResource(obrazki[pozycja]);
        opis.setText(opisy[pozycja]);
    }

    public void naprzod(View view) {
        pozycja++;
        if (pozycja>2) pozycja = 0;
        ramka.setImageResource(obrazki[pozycja]);
        opis.setText(opisy[pozycja]);
    }
}