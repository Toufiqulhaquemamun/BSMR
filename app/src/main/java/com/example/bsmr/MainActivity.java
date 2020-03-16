package com.example.bsmr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView date,place,subject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        date = findViewById(R.id.textViewdate);
        place = findViewById(R.id.textViewplace);
        subject = findViewById(R.id.textViewsubject);

        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,CalenderActivity.class);
                startActivity(i);
            }
        });

        place.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,PlaceActivity.class);
                startActivity(i);
            }
        });
        subject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,SubjectActivity.class);
                startActivity(i);
            }
        });
    }



}
