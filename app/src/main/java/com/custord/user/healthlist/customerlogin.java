package com.custord.user.healthlist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class customerlogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customerlogin);
        Button memberid = (Button) findViewById(R.id.memberid);

        memberid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gocsignupActivity();
            }
        });
    }

    private void gocsignupActivity() {
        Intent intent = new Intent(this, customersignup.class);
        startActivity(intent);
    }
}