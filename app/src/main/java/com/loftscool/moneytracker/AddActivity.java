package com.loftscool.moneytracker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;


public class AddActivity extends AppCompatActivity {
    public static final String EXTRA_TYPE = "type";
    public static final String RESULT_ITEM = "item";
    public static final int RC_ADD_ITEM = 99;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        final EditText titleEdit = findViewById(R.id.name);
        final EditText priceEdit = findViewById(R.id.price);
        final ImageButton addButton = findViewById(R.id.add);
        final String type = getIntent().getStringExtra(EXTRA_TYPE);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent result = new Intent();
                result.putExtra(RESULT_ITEM,new Item(titleEdit.getText().toString(), 100,type));
                setResult(RESULT_OK,result);
                finish();
            }
        });
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
