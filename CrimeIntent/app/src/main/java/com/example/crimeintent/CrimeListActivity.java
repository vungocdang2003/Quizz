package com.example.crimeintent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class CrimeListActivity extends SingleFragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crime_list);
    }
}