package com.android.diplomado.guessingapp.models;

import java.util.ArrayList;
import java.util.List;

public class Score {

    private List<Data> success;

    private List<Data> failure;


    public Score() {
        success = new ArrayList<>();
        failure = new ArrayList<>();
    }


    public void setCorrectAnswer(Data data) {
        success.add(data);
    }

    public void setIncorrectAnswer(Data data) {failure.add(data);}

    public int getCorrectAnswers() {
        return success.size();
    }

    public int getIncorrectAnswers() {
        return failure.size();
    }

}
