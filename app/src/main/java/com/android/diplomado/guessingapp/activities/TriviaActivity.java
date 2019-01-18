package com.android.diplomado.guessingapp.activities;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.android.diplomado.guessingapp.R;
import com.android.diplomado.guessingapp.endpoints.ControllerManager;
import com.android.diplomado.guessingapp.gameplay.GameRoundController;
import com.android.diplomado.guessingapp.models.Data;

import java.util.List;

public class TriviaActivity extends AppCompatActivity {

    private TextView textViewTrivia;

    private Bundle bundle;
    private int counter = 0;
    private int timer = 27;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trivia);

        textViewTrivia = findViewById(R.id.textViewTrivia);

        bundle = getIntent().getExtras();

        startGame();


    }

    private void startGame() {
        if (bundle != null) {

            int position = bundle.getInt("position");

            final GameRoundController gameRoundController = new GameRoundController(ControllerManager.getCategoryData(position));

            new CountDownTimer(5000, 1000) {

                public void onTick(long millisUntilFinished) {
                    textViewTrivia.setText("La trivia empezara en: " + millisUntilFinished / 1000);
                }

                public void onFinish() {

                    Log.i("Test", gameRoundController.getTrivias().toString());

                    List<Data> data = gameRoundController.getTrivias();
                    setTimer(data);
                }
            }.start();
        }
    }

    private void setTimer(final List<Data> data) {

        new CountDownTimer(30000, 1000) {

            //TODO Cambiar esta logica dummy con el sensor y la puntuacion
            public void onTick(long millisUntilFinished) {
                if ((millisUntilFinished / 1000) == timer) {
                    textViewTrivia.setText(data.get(counter).getName());
                    counter++;
                    timer = timer -5;
                }
            }

            public void onFinish() {
                textViewTrivia.setText("done!");
            }
        }.start();
    }
}
