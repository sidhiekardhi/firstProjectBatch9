package com.batch9.firstproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    TextView txtNama;
EditText edtName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        txtNama= findViewById(R.id.txtNama);
        edtName= findViewById(R.id.edt_name);
        String nameOld=getIntent().getStringExtra("nama");
        edtName.setText(nameOld);
        txtNama.setText(nameOld);
    }
}