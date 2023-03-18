package com.example.assignment_2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String STATE_SCORE = "stateScore";
    private int counterScore;
    private TextView CountText;
    private Button BtnCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CountText = findViewById(R.id.txtCount);
        BtnCount = findViewById(R.id.btnCount);
        BtnCount.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btnCount) {
            counterScore = counterScore+1;
            CountText.setText(String.valueOf(counterScore));
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("count", String.valueOf(CountText.getText()));
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        if (savedInstanceState != null) {
            String text = savedInstanceState.getString("count");
            if (CountText != null) {
                CountText.setText(text);
            }
        }
    }
}