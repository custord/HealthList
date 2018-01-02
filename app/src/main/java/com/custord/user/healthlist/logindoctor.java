package com.custord.user.healthlist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class logindoctor extends AppCompatActivity {
    EditText uname;
    EditText pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logindoctor);
        TextView signup = (TextView) findViewById(R.id.signup);
        Button buttonid = (Button) findViewById(R.id.buttonid);
        uname=(EditText)findViewById(R.id.username);
        pass=(EditText)findViewById(R.id.password);

        buttonid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String username=uname.getText().toString();
                String password=pass.getText().toString();
                if(username.equalsIgnoreCase("")&&(password.equals(""))){
                    Toast.makeText(logindoctor.this,"Welcome", Toast.LENGTH_LONG).show();
                    gonextActivity();
                } else {
                    Toast.makeText(logindoctor.this,"Invalid Credentials", Toast.LENGTH_LONG).show();
                }
            }
        });



        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gosignupActivity();
            }
        });
    }


    private void gosignupActivity() {
        Intent intent = new Intent(this, signup.class);
        startActivity(intent);
    }

    private void gonextActivity() {
        Intent intent = new Intent(this, ActivityOne.class);
        startActivity(intent);

    }
}
