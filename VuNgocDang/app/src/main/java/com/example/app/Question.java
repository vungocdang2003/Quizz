package com.example.app;

public class Question {
    public Question(Integer question, boolean answer) {
        Question = question;
        Answer = answer;
    }

    private int Question;
    private boolean Answer = true;

    public Integer getQuestion() {
        return Question;
    }

    public void setQuestion(int question) {
        Question = question;
    }

    public void setAnswer(boolean answer) {
        Answer = answer;
    }

    public boolean isAnswer() {
        return Answer;
    }



}
