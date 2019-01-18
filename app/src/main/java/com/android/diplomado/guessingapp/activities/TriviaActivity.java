package com.android.diplomado.guessingapp.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.android.diplomado.guessingapp.R;
import com.android.diplomado.guessingapp.endpoints.ControllerManager;
import com.android.diplomado.guessingapp.models.Trivia;

public class TriviaActivity extends AppCompatActivity {

    private TextView textViewTrivia;

    private int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trivia);

        textViewTrivia = findViewById(R.id.textViewTrivia);

        Bundle bundle = getIntent().getExtras();

        if (bundle != null) {
            position = bundle.getInt("position");

            Trivia trivia = new Trivia(ControllerManager.getCategoryData(position));

            Log.i("Test", trivia.getTrivias().toString());

        }
    }
}
