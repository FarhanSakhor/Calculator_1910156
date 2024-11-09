package com.example.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    TextView resultText, solutionText;
    Button but1, but2, but3, but4, but5, but6, but7, but8, but9, but0, butDot;
    Button butPlus, butMinus, butMultiply, butDivision, butEqual;
    Button butC, butD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        resultText= findViewById(R.id.resultText);
        solutionText= findViewById(R.id.solutionText);

        assignId(but0, R.id.but0);
        assignId(but1, R.id.but1);
        assignId(but2, R.id.but2);
        assignId(but3, R.id.but3);
        assignId(but4, R.id.but4);
        assignId(but5, R.id.but5);
        assignId(but6, R.id.but6);
        assignId(but7, R.id.but7);
        assignId(but8, R.id.but8);
        assignId(but9, R.id.but9);
        assignId(butDot, R.id.butDot);
        assignId(butPlus, R.id.butPlus);
        assignId(butMinus, R.id.butMinus);
        assignId(butMultiply, R.id.butMultiply);
        assignId(butDivision, R.id.butDivision);
        assignId(butEqual, R.id.butEqual);
        assignId(butC, R.id.butC);
        assignId(butD, R.id.butD);
    }

    @Override
    public void onClick(View v) {

    }
    void assignId(Button but, int id)
    {
        but= findViewById(id);
        but.setOnClickListener(this);
    }
}