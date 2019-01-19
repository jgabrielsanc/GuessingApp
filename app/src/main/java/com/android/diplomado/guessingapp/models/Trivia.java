package com.android.diplomado.guessingapp.models;

import android.os.CountDownTimer;
import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;



public  class Trivia {

    private List<Data> trivias;
    private List<Data> triviasToBeAsked;
    private Random random = new Random();


    public Trivia(List<Data> questions) {
        this.trivias = questions;
        triviasToBeAsked  = new ArrayList<>();
    }


    public Data getTrivia(int i) {
        return triviasToBeAsked.get(i);
    }

    public List<Data> getRandomQuestions() {
        while(triviasToBeAsked.size() < 10) {
            Data d = trivias.get(random.nextInt(trivias.size()));
            if(!triviasToBeAsked.contains(d))
                triviasToBeAsked.add(d);
        }
        return triviasToBeAsked;
    }

    public List<Data> getTrivias() {
        return triviasToBeAsked;
    }




}
