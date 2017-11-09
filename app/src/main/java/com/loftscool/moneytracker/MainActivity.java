package com.loftscool.moneytracker;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText titleEdit = findViewById(R.id.name);
        final EditText priceEdit = findViewById(R.id.price);
        final ImageButton addButton = findViewById(R.id.add);
        titleEdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            if ((titleEdit.getText().length() != 0)&(priceEdit.getText().length()!=0))
                addButton.setClickable(true);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        priceEdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if ((titleEdit.getText().length() != 0)&(priceEdit.getText().length()!=0))
                    addButton.setClickable(true);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

    }

    }

