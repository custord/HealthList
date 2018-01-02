package com.custord.user.healthlist;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

public class login extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button cbuttonid = (Button) findViewById(R.id.cbuttonid);
        Button dbuttonid = (Button) findViewById(R.id.dbuttonid);

        cbuttonid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gocustomerActivity();
            }
        });

        dbuttonid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                godoctorActivity();
            }
        });
    }

    private void gocustomerActivity() {
        Intent intent = new Intent(this, logincustomer.class);
        startActivity(intent);

    }

    private void godoctorActivity() {
        Intent intent = new Intent(this, logindoctor.class);
        startActivity(intent);

    }
}