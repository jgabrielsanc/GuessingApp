package com.android.diplomado.guessingapp.models;

import java.util.List;

public class Score {

    private List<Data> success;

    private List<Data> failure;



    public List<Data> getSuccess() {
        return success;
    }

    public void setSuccess(List<Data> success) {
        this.success = success;
    }

    public List<Data> getFailure() {
        return failure;
    }

    public void setFailure(List<Data> failure) {
        this.failure = failure;
    }

    public int getCorrectAnswers() {
        return success.size();
    }

    public int getIncorrectAnswers() {
        return failure.size();
    }

}
