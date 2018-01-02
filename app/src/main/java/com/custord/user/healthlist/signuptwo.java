package com.custord.user.healthlist;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.File;

public class signuptwo extends AppCompatActivity implements View.OnClickListener {
    protected Button myButton;
    String myString = "Successfully Registered!";

    private static final int RESULT_LOAD_IMAGE =1;
    ImageView image_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signuptwo);

        image_view = (ImageView) findViewById(R.id.image_view);
        image_view.setOnClickListener(this);


        myButton = (Button) findViewById(R.id.registerid);
        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(), myString, Toast.LENGTH_LONG).show();
                gonextActivity();

            }
        });
    }

    private void gonextActivity() {
        Intent intent = new Intent(this, login.class);
        startActivity(intent);

    }

        @Override
    public void onClick(View v){
        switch(v.getId()){
            case R.id.image_view:
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("application/pdf");
                intent.addCategory(Intent.CATEGORY_OPENABLE);

                try {
                    startActivityForResult(
                            Intent.createChooser(intent, "Select txt file"),
                            0);
                } catch (android.content.ActivityNotFoundException ex) {
                    // Potentially direct the user to the Market with a Dialog

                }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode , Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if(requestCode == RESULT_LOAD_IMAGE && resultCode ==RESULT_OK && data !=null){
            Uri selectedImage = data.getData();
            image_view.setImageURI(selectedImage);
        }
    }
}

