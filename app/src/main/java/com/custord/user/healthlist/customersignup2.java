package com.custord.user.healthlist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class customersignup2 extends AppCompatActivity {
    protected Button myButton;
    String myString = "Successfully Registered!";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customersignup2);

        myButton = (Button) findViewById(R.id.buttonid);
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
}
