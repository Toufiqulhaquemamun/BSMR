package com.example.bsmr;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import android.widget.SearchView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class SubjectActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Spinner spinner;
    SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject);
        getSupportActionBar().hide();
        spinner=findViewById(R.id.spinnersubject);
        searchView = findViewById(R.id.searchView);
        searchView.setQueryHint("বিষয় লিখুন");
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("বক্তব্য নির্বাচন করুন");
        arrayList.add("৭ মার্চ ১৯৭১ ঐতিহাসিক ভাষণ\n");
        arrayList.add("১৬ ই ডিসেম্বর বিজয় দিবস\n");

        Spinner(arrayList);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
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
                    Intent j = new Intent(SubjectActivity.this,DateVideoPlayer.class);
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
