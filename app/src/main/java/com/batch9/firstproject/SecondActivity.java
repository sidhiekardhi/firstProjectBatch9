package com.batch9.firstproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    TextView txtNama;
EditText edtUsia, edtAgama, edtGender;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        txtNama= findViewById(R.id.txtNama);
        edtUsia= findViewById(R.id.edt_usia);
        edtAgama= findViewById(R.id.edt_agama);
        edtGender= findViewById(R.id.edt_gender);
        String nameOld=getIntent().getStringExtra("nama");
        String usiaOld=getIntent().getStringExtra("usia");
        String genderOld=getIntent().getStringExtra("gender");
        String agamaOld=getIntent().getStringExtra("agama");
        txtNama.setText(nameOld);
        edtUsia.setText(usiaOld);
        edtGender.setText(genderOld);
        edtAgama.setText(agamaOld);
    }
}