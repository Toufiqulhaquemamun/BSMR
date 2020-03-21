package com.example.bsmr;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.SearchView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.bsmr.adapter.ListViewAdapter;
import com.example.bsmr.model.PlaceNames;

import java.util.ArrayList;

public class PlaceActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {

    Spinner spinner;
    AppCompatEditText editText;
    SearchView editsearch;
    ListView list;
    ListViewAdapter adapter;
    String[] placelNameList;
    ArrayList<PlaceNames> arraylist = new ArrayList<PlaceNames>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place);
        getSupportActionBar().hide();
        placelNameList = new String[]{"রেসকোর্স ময়দান", "ঢাকা কলেজ মাঠ", "চট্টগ্রাম বিশ্ববিদ্যালয়",
                "গোপালগঞ্জ", "সিলেট সরকারি কলেজ মাঠ"};
        list = (ListView) findViewById(R.id.listview);
        for (int i = 0; i < placelNameList.length; i++) {
            PlaceNames placeNames = new PlaceNames(placelNameList[i]);
            // Binds all strings into an array
            arraylist.add(placeNames);
        }

        adapter = new ListViewAdapter(this, arraylist);

        // Binds the Adapter to the ListView
        list.setAdapter(adapter);

        // Locate the EditText in listview_main.xml
        editsearch = (SearchView) findViewById(R.id.placeSearchview);
        editsearch.setOnQueryTextListener(this);

    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        String text = newText;
        adapter.filter(text);
        return false;
    }

//
}
