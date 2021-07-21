package com.batch9.firstproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
EditText edtNama, edtUsia;
Button btnSimpan;
    String namanya;
    Button btnPindah;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtNama= findViewById(R.id.edt_nama);
        edtUsia= findViewById(R.id.edt_usia);
        btnSimpan= findViewById(R.id.btn_simpan);
        btnPindah= findViewById(R.id.btn_pindah);

        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                namanya= edtNama.getText().toString();
                Toast toast = Toast.makeText(getApplicationContext(), namanya, Toast.LENGTH_SHORT);
                toast.show();
                System.out.println(edtNama.getText().toString());
            }
        });

        btnPindah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
                intent.putExtra("nama", edtNama.getText().toString());
                startActivity(intent);
            }
        });
    }


}