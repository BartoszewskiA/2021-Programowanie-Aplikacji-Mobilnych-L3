package com.example.lab07p01_ekranlogowania;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    EditText haslo;
    Spinner uzytkownicy_spin;
    Button ok;
    String users[], passwords[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        users = getResources().getStringArray(R.array.users);
        passwords = getResources().getStringArray(R.array.passwords);
        haslo = findViewById(R.id.haslo);
        ok = findViewById(R.id.ok);
        uzytkownicy_spin = findViewById(R.id.uzytkownicy);
        dodajSluchaczeZdarzen();
    }

    private void dodajSluchaczeZdarzen() {
        haslo.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//                if (sprawdzHaslo(charSequence.toString()))
//                    ok.setEnabled(true);
//                else
//                    ok.setEnabled(false);
                ok.setEnabled(sprawdzHaslo(charSequence.toString()));
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });

        uzytkownicy_spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                ok.setEnabled(false);
                haslo.setText("");
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intencja = new Intent(getApplicationContext(), MainActivity2.class);
                intencja.putExtra("kto",uzytkownicy_spin.getSelectedItem().toString());
                startActivity(intencja);
            }
        });
    }

    private boolean sprawdzHaslo(String s) {
        int nr = uzytkownicy_spin.getSelectedItemPosition();
        if (passwords[nr].equals(s)) return true;
        return false;
    }
}