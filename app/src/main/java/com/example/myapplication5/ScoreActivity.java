package com.example.myapplication5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class ScoreActivity extends AppCompatActivity {

    TextView userScore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        Intent in = getIntent();
        int total_correct_answer = in.getIntExtra("total",0);
        userScore = findViewById(R.id.userScore);
        userScore.setText(String.valueOf(total_correct_answer));
    }
}