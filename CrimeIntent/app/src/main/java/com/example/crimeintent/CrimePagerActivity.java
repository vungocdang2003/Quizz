package com.example.crimeintent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import java.util.List;
import java.util.UUID;

public class CrimePagerActivity extends AppCompatActivity {

    private static final String EXTRA_CRIME_ID = "crime_id";
    private ViewPager2 mViewpager;
    private FragmentStateAdapter mStateAdapter;
    private List<Crime> mcrimes;
    public static Intent newIntent(Context context, UUID crimeId){
        Intent intent
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crime_pager);
    }
}