package com.custord.user.healthlist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class customersignup extends AppCompatActivity {

    protected Button myButton;
    EditText et1, et2, et3, et4, et5;
    String myString = "Please complete the form.";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customersignup);

        myButton = (Button)findViewById(R.id.buttonid);
        et1 = (EditText)findViewById(R.id.a);
        et2 = (EditText)findViewById(R.id.b);
        et3 = (EditText)findViewById(R.id.c);
        et4 = (EditText)findViewById(R.id.d);
        et5 = (EditText)findViewById(R.id.e);
        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (et1.getText().toString().isEmpty() || et2.getText().toString().isEmpty()
                        || et3.getText().toString().isEmpty() || et4.getText().toString().isEmpty()
                        || et5.getText().toString().isEmpty())
                {
                    Toast.makeText(getApplicationContext(),myString,Toast.LENGTH_LONG).show();
                }
                else
                    gonextActivity();
            }
        });
    }

    private void gonextActivity() {
        Intent intent = new Intent(this, customersignup2.class);
        startActivity(intent);

    }
}