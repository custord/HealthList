package com.custord.user.healthlist;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class doctorprofile extends AppCompatActivity implements View.OnClickListener {
    String myString = "Added to Favourite";
    String myString2 = "Removed from Favourite";
    static Boolean favToggled = false;
    favResults fr1 = new favResults();
    appResults ar1 = new appResults();

    Button btnDatePicker, btnTimePicker, btnAppointment;
    EditText txtDate, txtTime;
    private int mYear, mMonth, mDay, mHour, mMinute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctorprofile);

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavViewBar);
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);
        Menu menu = bottomNavigationView.getMenu();
        //MenuItem menuItem = menu.getItem(0);
        //menuItem.setChecked(true);
        Switch fav = (Switch) findViewById(R.id.fav);
        fav.setChecked(favToggled);
        final TextView name= (TextView) findViewById(R.id.name);
        final TextView company= (TextView) findViewById(R.id.company);
        final TextView city= (TextView) findViewById(R.id.city);

        fav.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {

                    Toast.makeText(getApplicationContext(), myString, Toast.LENGTH_LONG).show();
                    fr1.setName(name.getText().toString());
                    fr1.setCompany(company.getText().toString());
                    fr1.setCity(city.getText().toString());
                    ActivityThree.favResults.add(fr1);
                    favToggled = true;
                }else {

                    for ( int i = 0;  i < ActivityThree.favResults.size(); i++){
                        String oldname = ActivityThree.favResults.get(i).getName();
                        if(oldname.equalsIgnoreCase(name.getText().toString()))
                        {
                            ActivityThree.favResults.remove(i);
                        }
                    }

                    Toast.makeText(getApplicationContext(), myString2, Toast.LENGTH_LONG).show();
                    favToggled = false;

                }
            }
        });




        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item){
                switch(item.getItemId()){
                    case R.id.ic_home:
                        Intent intent1 = new Intent(doctorprofile.this, ActivityOne.class);
                        startActivity(intent1);
                        break;

                    case R.id.ic_event_note:
                        Intent intent2 = new Intent(doctorprofile.this, ActivityTwo.class);
                        startActivity(intent2);
                        break;

                    case R.id.ic_favorite:
                        Intent intent3 = new Intent(doctorprofile.this, ActivityThree.class);
                        startActivity(intent3);
                        break;

                    case R.id.ic_person:
                        Intent intent4 = new Intent(doctorprofile.this, ActivityFour.class);
                        startActivity(intent4);
                        break;
                }

                return false;
            }
        });


        btnDatePicker=(Button)findViewById(R.id.btn_date);
        btnTimePicker=(Button)findViewById(R.id.btn_time);
        btnAppointment=(Button)findViewById(R.id.btnAppointment);
        txtDate=(EditText)findViewById(R.id.in_date);
        txtTime=(EditText)findViewById(R.id.in_time);

        btnDatePicker.setOnClickListener(this);
        btnTimePicker.setOnClickListener(this);

        btnAppointment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(txtDate.getText().toString().isEmpty() || txtTime.getText().toString().isEmpty())
                    Toast.makeText(getApplicationContext(), "Please fill in date and time!", Toast.LENGTH_LONG).show();
                else {

                    ar1.setName(name.getText().toString());
                    ar1.setCompany(company.getText().toString());
                    ar1.setDate("Date: " + txtDate.getText().toString());
                    ar1.setTime("Time(24-hr clock): " + txtTime.getText().toString());
                    ActivityTwo.appResults.add(ar1);
                    Toast.makeText(getApplicationContext(), "Appointment made.", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void onClick(View v) {

        if (v == btnDatePicker) {

            // Get Current Date
            final Calendar c = Calendar.getInstance();
            mYear = c.get(Calendar.YEAR);
            mMonth = c.get(Calendar.MONTH);
            mDay = c.get(Calendar.DAY_OF_MONTH);


            DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                    new DatePickerDialog.OnDateSetListener() {

                        @Override
                        public void onDateSet(DatePicker view, int year,
                                              int monthOfYear, int dayOfMonth) {

                            txtDate.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                        }
                    }, mYear, mMonth, mDay);
            datePickerDialog.show();
        }
        if (v == btnTimePicker) {

            // Get Current Time
            final Calendar c = Calendar.getInstance();
            mHour = c.get(Calendar.HOUR_OF_DAY);
            mMinute = c.get(Calendar.MINUTE);

            // Launch Time Picker Dialog
            TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                    new TimePickerDialog.OnTimeSetListener() {

                        @Override
                        public void onTimeSet(TimePicker view, int hourOfDay,
                                              int minute) {

                            txtTime.setText(hourOfDay + ":" + minute);
                        }
                    }, mHour, mMinute, false);
            timePickerDialog.show();
        }
    }

}
