package com.example.crimeintent;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CrimeListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CrimeListFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private RecyclerView recyclerView;
    private String mParam1;
    private String mParam2;

    private class CrimeHoder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private TextView mTextViewTitle;
        private TextView mTextViewDate;
        private CheckBox mCheckboxSolved;
        private Crime mCrime;

        public void bindCrime(Crime crime){
            mCrime = crime;
            mTextViewTitle.setText(mCrime.getmTitle());
            mTextViewDate.setText(mCrime.getmDate().toString());
            mCheckboxSolved.setChecked(mCrime.ismSolved());
        }

        public CrimeHoder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);

            mTextViewTitle = itemView.findViewById(R.id.list_item_textview_crime_title);
            mTextViewDate = itemView.findViewById(R.id.list_item_textview_crime_date);
            mCheckboxSolved = itemView.findViewById(R.id.list_item_checkbox_crime_solved)
        }

        @Override
        public void onClick(View view) {

        }
    }

    private  class CrimeAdapter extends  RecyclerView.Adapter<CrimeHoder>{
        private List<Crime> mCrimes;
        public CrimeAdapter(List<Crime> crimes){
            mCrimes = crimes;
        }

        @NonNull
        @Override
        public CrimeHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            View view = layoutInflater.inflate(R.layout.list_item_crime,parent, false);
            return new CrimeHoder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull CrimeHoder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return 0;
        }
    }

    public CrimeListFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CrimeListFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CrimeListFragment newInstance(String param1, String param2) {
        CrimeListFragment fragment = new CrimeListFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_crime_list, container, false);
    }
}