package com.batch9.firstproject;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

import in.mayanknagwanshi.imagepicker.ImageSelectActivity;

public class CameraActivity extends AppCompatActivity {
    ImageView imageView, imageViewLibrary;
    Button btnTake, btnTakeLibrary;
    int requestCode = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
        btnTake = findViewById(R.id.btnTake);
        imageView = findViewById(R.id.imageView);
        btnTakeLibrary= findViewById(R.id.btnTakeLibrary);
        imageViewLibrary= findViewById(R.id.imageViewLibrary);

//        Glide.with(getApplicationContext()).load("https://www.nusabali.com/article_images/55405/chelsea-islan-norak-saat-ke-nagoya-jepang-800-2019-07-10-180045_0.jpg").into(imageView);

        btnTake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent takePicture = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivity(takePicture);
                startActivityForResult(takePicture,1);
            }
        });

        btnTakeLibrary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //library camera
                Intent intent = new Intent(getApplicationContext(), ImageSelectActivity.class);
                intent.putExtra(ImageSelectActivity.FLAG_COMPRESS, false);//default is true
                intent.putExtra(ImageSelectActivity.FLAG_CAMERA, true);//default is true
                intent.putExtra(ImageSelectActivity.FLAG_GALLERY, true);//default is true
                startActivityForResult(intent, 1213);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(this.requestCode ==  requestCode && resultCode == RESULT_OK){
            Bitmap bitmap = (Bitmap) data.getExtras().get("data");
            imageView.setImageBitmap(bitmap);
        }
        //library camera
        if (requestCode == 1213 && resultCode == Activity.RESULT_OK) {
            String filePath = data.getStringExtra(ImageSelectActivity.RESULT_FILE_PATH);
            Bitmap selectedImage = BitmapFactory.decodeFile(filePath);
            imageViewLibrary.setImageBitmap(selectedImage);
        }
    }
}
