package com.example.bsmr;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.CalendarView;
import android.widget.Toast;

import java.util.Calendar;

public class CalenderActivity extends AppCompatActivity {

    CalendarView calendarView;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calender);
        getSupportActionBar().hide();
        calendarView = findViewById(R.id.calendarView);
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                String msg = "Selected date Day: " + dayOfMonth + " Month : " + (month+1) + " Year " + year;
                Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
                Intent i = new Intent(CalenderActivity.this,DateVideoPlayer.class);
                startActivity(i);
            }
        });
    }
}
