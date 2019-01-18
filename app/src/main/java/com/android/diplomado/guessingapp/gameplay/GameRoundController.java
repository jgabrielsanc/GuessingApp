package com.android.diplomado.guessingapp.gameplay;

import com.android.diplomado.guessingapp.models.Data;
import com.android.diplomado.guessingapp.models.Trivia;
import com.android.diplomado.guessingapp.models.Score;

import java.util.List;

public class GameRoundController {

    private Score score;
    private Trivia trivia;


    public GameRoundController(List<Data> trivias) {

        trivia = new Trivia(trivias);
        score = new Score();

    }


    public Data getTrivia(int i) {
        return trivia.getTrivia(i);
    }

    public List<Data> getTrivias() {return trivia.getTrivias();}

    public List<Data> getCorrectAnswers() {return score.getCorrectAnswers();}

    public List<Data> getIncorrectAnswers() {return score.getIncorrectAnswers(); }

    public void setCorrectAnswer(Data data) {
        score.setCorrectAnswer(data);
    }

    public void setIncorrectAnswer(Data data) {
        score.setIncorrectAnswer(data);
    }

    public boolean isWinner() {
        return score.isWinner();
    }






















}
