package com.example.crimeintent;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import java.util.List;
import java.util.UUID;

public class CrimePagerActivity extends FragmentActivity {

    private  static final String EXTRA_CRIME_ID= "com.example.crimeintent";



//    private static final String EXTRA_CRIME_ID = "crime_id";
    private ViewPager2 mViewpager;
    private FragmentStateAdapter mStateAdapter;
    private List<Crime> mCrimes;
//    public static Intent newIntent(Context context, UUID crimeId){
//        Intent intent =
//    }

    public static Intent newIntent(Context context, UUID crimeId){
        Intent intent = new Intent(context,CrimePagerActivity.class);
        intent.putExtra(EXTRA_CRIME_ID, crimeId);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crime_pager);
        UUID crimeId = (UUID) getIntent().getSerializableExtra(EXTRA_CRIME_ID);
        mViewpager = findViewById(R.id.activity_crime_pager_viewpager);
        mCrimes = CrimeLab.get(this).getCrimes();
        mStateAdapter = new MyPagerAdapter(this);
        mViewpager.setAdapter(mStateAdapter);

        for (int i= 0; i<mCrimes.size(); i++){
            if (mCrimes.get(i).getmId().equals(crimeId)){
                mViewpager.setCurrentItem(i);
            }
        }
    }

    private class MyPagerAdapter extends FragmentStateAdapter {
        public MyPagerAdapter(FragmentActivity fragmentActivity) {
            super(fragmentActivity);
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {
            Crime crime = mCrimes.get(position);

            return CrimeFragment.newInstance(crime.getmId());
        }

        @Override
        public int getItemCount() {
            return mCrimes.size();
        }
    }
}