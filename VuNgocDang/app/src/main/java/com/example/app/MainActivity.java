package com.example.app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;


public class MainActivity extends AppCompatActivity {
    private Button mButtonTrue;
    private Button mButtonFalse;
    private Button mButtonNext;
    private TextView Vquest;
    private  static final  String KEY_INDEX = "index";
    private Button mButtonCheat;
    private Question[] mQuesttionBank = new Question[]{
            new Question(R.string.quest1, false),
            new Question(R.string.quest2, true),
            new Question(R.string.quest3, true),
            new Question(R.string.quest4, false),
            new Question(R.string.quest5, false)
    };
    private int IndexQuestion = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Log.i(TAG, "onCreate() called");
        //EdgeToEdge.enable(this);



        mButtonTrue = findViewById(R.id.button_true);
        mButtonTrue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(true);
            }
        });
        mButtonFalse = findViewById(R.id.button_false);
        mButtonFalse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(false);
            }
        });
        Vquest = findViewById(R.id.Vquestion);

        mButtonNext = findViewById(R.id.button_next);
        mButtonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IndexQuestion++;
                if (IndexQuestion < mQuesttionBank.length){
                    updateQuestion();
                }
                else{
                    Vquest.setText("Đã hết câu hỏi");
                    mButtonNext.setEnabled(false);
                }
            }
        });

        if(savedInstanceState != null){
            IndexQuestion = savedInstanceState.getInt(KEY_INDEX, 0);
        }
        updateQuestion();
        mButtonCheat = findViewById(R.id.show_answer);
        mButtonCheat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean answer = mQuesttionBank[IndexQuestion].isAnswer();
                Intent i = CheatActivity.newIntent(MainActivity.this, answer);
                startActivity(i);
            }
        });
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_INDEX, IndexQuestion);
    }

    //    @Override
//    protected void onSaveInstanceState(@NonNull Bundle outState){
//        super.onSaveInstanceState(outState);
//        //Log.i(TAG,"onSaveInstanceState");
//        outState.putInt(KEY_INDEX, IndexQuestion);
//    }
    private void updateQuestion(){
        Vquest.setText(mQuesttionBank[IndexQuestion].getQuestion());
    }

    private void checkAnswer(boolean userAnswer){
        boolean correctAnswer = mQuesttionBank[IndexQuestion].isAnswer();
        if(userAnswer == correctAnswer){
            Toast.makeText(MainActivity.this, R.string.A_True, Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(MainActivity.this, R.string.A_False, Toast.LENGTH_SHORT).show();
        }
    }

}