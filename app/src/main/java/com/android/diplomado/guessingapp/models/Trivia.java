package com.android.diplomado.guessingapp.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public  class Trivia {

   private List<Data> trivias;
   private List<Data> triviasToBeAsked;


    public Trivia(List<Data> questions) {
        this.trivias = questions;
        triviasToBeAsked  = new ArrayList<>();
        getRandomQuestions();
    }


    public Data getTrivia(int i) {
        return triviasToBeAsked.get(i);
    }

    private   List<Data> getRandomQuestions() {
        Random random = new Random();
        triviasToBeAsked.clear();
        triviasToBeAsked.addAll(trivias);
        while (triviasToBeAsked.size() > 10)
            triviasToBeAsked.remove(random.nextInt(triviasToBeAsked.size()));

        return triviasToBeAsked;
    }

    public List<Data> getTrivias() {
        return triviasToBeAsked;
    }




}
