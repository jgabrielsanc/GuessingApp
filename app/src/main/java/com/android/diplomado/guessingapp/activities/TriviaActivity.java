package com.android.diplomado.guessingapp.activities;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
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

public class TriviaActivity extends AppCompatActivity  {

    private TextView textViewTrivia;
r
    private Bundle bundle;
    private int counter = 0;
    private int timer = 300;
    private SensorManager sensorManager;
    private Sensor sensorGyro;
    private GameRoundController gameRoundController;

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

         gameRoundController  = new GameRoundController(ControllerManager.getCategoryData(position));

            new CountDownTimer(10000, 1000) {

                public void onTick(long millisUntilFinished) {
                    textViewTrivia.setText("La trivia empezara en: " + millisUntilFinished / 1000);


                }

                public void onFinish() {

                    List<Data> data = gameRoundController.getRandomTrivia();
                    setTimer(data);
                }
            }.start();
        }
    }

    private void setTimer(final List<Data> data) {

        new CountDownTimer(300000, 1000) {

            //TODO Cambiar esta logica dummy con el sensor y la puntuacion
            public void onTick(long millisUntilFinished) {
                if (millisUntilFinished / 1000 == timer) {
                    textViewTrivia.setText(data.get(counter).toString());

                    counter++;
                    timer = timer - 30;

                }


            }

            public void onFinish() {
                textViewTrivia.setText("done!");
            }

        }.start();
    }

}


