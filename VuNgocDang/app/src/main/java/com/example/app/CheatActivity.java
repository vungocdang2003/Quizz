package com.example.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class CheatActivity extends AppCompatActivity {

    private static final String EXTRA_ANSWER = "VuNgocDang.Quiz.Answer";
    public static Intent newIntent(Context pakageContext, boolean answer){
        Intent i = new Intent(pakageContext, CheatActivity.class);
        i.putExtra(EXTRA_ANSWER, answer);
        return i;
    }
    private boolean mAnswer;
    private TextView mTextViewAnswer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);
        mAnswer = getIntent().getBooleanExtra(EXTRA_ANSWER, false);
        mTextViewAnswer = findViewById(R.id.Show_Resuilt);

    }
}