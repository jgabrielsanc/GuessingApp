package com.android.diplomado.guessingapp.models;

import java.util.List;
import java.util.Random;

public  class Trivia {

   private List<Data> trivias;


    public Trivia(List<Data> questions) {
        this.trivias = questions;
        getRandomQuestions();
    }


    public Data getTrivia(int i) {
        return trivias.get(i);
    }



    private   List<Data> getRandomQuestions() {
        Random random = new Random();
        while (trivias.size() > 10) {
            trivias.remove(random.nextInt(trivias.size()));
        }

        return trivias;
    }

    public List<Data> getTrivias() {
        return trivias;
    }




}
