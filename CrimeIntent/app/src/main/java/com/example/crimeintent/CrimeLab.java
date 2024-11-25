package com.example.crimeintent;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CrimeLab {
    private static  CrimeLab sCrimelab;

    public static CrimeLab get(Context context){
        if(sCrimelab == null)
            sCrimelab = new CrimeLab(context);
        return sCrimelab;
    }
    private List<Crime> mCrimes;
    private  CrimeLab(Context context){
        mCrimes = new ArrayList<Crime>();
        for( int i = 0; i < 100; i++){
            Crime crime = new Crime();
            crime.setmTitle("Crime #" + i);
            crime.setmSolved(i % 2 ==0);
            mCrimes.add(crime);
        }
    }

    public List<Crime>getmCrimes(){return  mCrimes;}

    public  Crime getCrime(UUID id){
        for(Crime crime : mCrimes)
            if(crime.getmId().equals(id))
                return crime;
            return null;
    }
}
