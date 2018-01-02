package com.custord.user.healthlist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.support.v7.widget.ButtonBarLayout;
import android.widget.Spinner;
import android.widget.Toast;

public class signup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.category, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner.setAdapter(adapter);

        Button buttonid = (Button) findViewById(R.id.buttonid);

        buttonid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gonextActivity();
            }
        });
    }

    private void gonextActivity() {
        Intent intent = new Intent(this, signuptwo.class);
        startActivity(intent);

    }
}