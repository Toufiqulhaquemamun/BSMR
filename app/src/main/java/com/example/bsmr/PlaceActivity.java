package com.example.bsmr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class PlaceActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place);
        getSupportActionBar().hide();
        spinner = findViewById(R.id.spinner2);
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("স্থানের নাম লিখুন");
        arrayList.add("রেসকোর্স ময়দান");
        arrayList.add("ঢাকা কলেজ মাঠ");
        arrayList.add("চট্টগ্রাম বিশ্ববিদ্যালয়");
        arrayList.add("গোপালগঞ্জ");
        arrayList.add("সিলেট সরকারি কলেজ মাঠ");
        Spinner(arrayList);

    }
    public void Spinner(ArrayList<String> arrayList)
    {
       spinner.setOnItemSelectedListener(this);

        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,arrayList);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter2);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String place = adapterView.getItemAtPosition(i).toString();
                Toast.makeText(getApplicationContext(), "Selected: " + place, Toast.LENGTH_LONG).show();
                if(i==0)
                {

                }
                else{
                    Intent j = new Intent(PlaceActivity.this,DateVideoPlayer.class);
                    startActivity(j);
                }

            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
