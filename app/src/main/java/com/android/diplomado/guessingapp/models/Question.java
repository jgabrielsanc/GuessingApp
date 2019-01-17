package com.android.diplomado.guessingapp.models;

import java.util.List;
import java.util.Random;

public  class Question {

   private List<Data> questions;
   private Random random;
   private Data data;


    public Question(List<Data> questions) {
        this.questions = questions;
        random = new Random();
    }


    public  Data getRandomQuestion() {
        int i = random.nextInt(questions.size());
        data = questions.get(i);
        questions.remove(i);

        return data;
    }



}
