package com.custord.user.healthlist;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

/**
 * Created by user on 20/10/2017.
 */

public class ActivityDoctor extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor);


        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavViewBar);
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);
        Menu menu = bottomNavigationView.getMenu();
        //MenuItem menuItem = menu.getItem(0);
        //menuItem.setChecked(true);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item){
                switch(item.getItemId()){
                    case R.id.ic_home:
                        Intent intent1 = new Intent(ActivityDoctor.this, ActivityOne.class);
                        startActivity(intent1);
                        break;

                    case R.id.ic_event_note:
                        Intent intent2 = new Intent(ActivityDoctor.this, ActivityTwo.class);
                        startActivity(intent2);
                        break;

                    case R.id.ic_favorite:
                        Intent intent3 = new Intent(ActivityDoctor.this, ActivityThree.class);
                        startActivity(intent3);
                        break;

                    case R.id.ic_person:
                        Intent intent4 = new Intent(ActivityDoctor.this, ActivityFour.class);
                        startActivity(intent4);
                        break;
                }

                return false;
            }
        });
        Button buttondr1 = (Button) findViewById(R.id.button1);

        buttondr1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gonextActivityDr1();
            }
        });

        Button buttondr2 = (Button) findViewById(R.id.button2);

        buttondr2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gonextActivityDr2();
            }
        });
    }

    private void gonextActivityDr1() {
        Intent intent = new Intent(this, doctorprofile.class);
        startActivity(intent);
    }

    private void gonextActivityDr2() {
        Intent intent = new Intent(this, dr2.class);
        startActivity(intent);
    }
}
