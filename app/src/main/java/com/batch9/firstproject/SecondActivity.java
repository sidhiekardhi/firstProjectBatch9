package com.batch9.firstproject;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    TextView txtNama, txtNoTelp;
    EditText edtUsia, edtAgama, edtGender;
    String phoneOld;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        txtNama = findViewById(R.id.txtNama);
        edtUsia = findViewById(R.id.edt_usia);
        txtNoTelp= findViewById(R.id.txtNoTelp);
        edtAgama = findViewById(R.id.edt_agama);
        edtGender = findViewById(R.id.edt_gender);
        phoneOld = getIntent().getStringExtra("phone");
        String nameOld = getIntent().getStringExtra("nama");
        String usiaOld = getIntent().getStringExtra("usia");
        String genderOld = getIntent().getStringExtra("gender");
        String agamaOld = getIntent().getStringExtra("agama");
        txtNama.setText(nameOld);
        txtNoTelp.setText(phoneOld);
        txtNoTelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String message= "hai brother";
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://api.whatsapp.com/send?phone="+phoneOld+"&text="+message)));
                }catch(Exception e){

                }

            }
        });
        edtUsia.setText(usiaOld);
        edtGender.setText(genderOld);
        edtAgama.setText(agamaOld);
    }
}

//                Intent intent = new Intent(Intent.ACTION_DIAL);
//                intent.setData(Uri.parse("tel:"+ phoneOld));
//                startActivity(intent);
