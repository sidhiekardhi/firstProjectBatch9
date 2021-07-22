package com.batch9.firstproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edtNama, edtUsia, edtNoTelp;
    Button btnSimpan;
    String namanya;
    Button btnPindah;
    RadioButton rbPria, rb_wanita;
    Spinner spnAgama;
    String pria= "pria";
    String wanita= "wanita";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtNoTelp= findViewById(R.id.edt_notelp);
        edtNama= findViewById(R.id.edt_nama);
        edtUsia= findViewById(R.id.edt_usia);
        btnSimpan= findViewById(R.id.btn_simpan);
        btnPindah= findViewById(R.id.btn_pindah);
        rbPria= findViewById(R.id.rb_pria);
        rb_wanita= findViewById(R.id.rb_wanita);
        spnAgama= findViewById(R.id.spn_agama);
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

                System.out.println(spnAgama.getSelectedItem());
                String agama= String.valueOf(spnAgama.getSelectedItem());
                Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
                intent.putExtra("nama", edtNama.getText().toString());
                intent.putExtra("phone", edtNoTelp.getText().toString());
                intent.putExtra("usia", edtUsia.getText().toString());
                if (rbPria.isChecked()){
                    intent.putExtra("gender", pria);
                } else {
                    intent.putExtra("gender", wanita);
                }
                intent.putExtra("agama", agama );
                startActivity(intent);
            }
        });
    }


}