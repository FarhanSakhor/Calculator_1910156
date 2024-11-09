package com.example.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    TextView resultText, solutionText;
    Button but1, but2, but3, but4, but5, but6, but7, but8, but9, but0, butDot;
    Button butPlus, butMinus, butMultiply, butDivision, butEqual;
    Button butAC, butDel;

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
        assignId(butAC, R.id.butAC);
        assignId(butDel, R.id.butDel);
    }

    @Override
    public void onClick(View v) {
        Button button = (Button) v;
        String buttonText= button.getText().toString();
        String dataToCalculate = solutionText.getText().toString();

        if(buttonText.equals("AC"))
        {
            solutionText.setText("");
            resultText.setText("0");
            return;
        }
        if(buttonText.equals("="))
        {
            solutionText.setText(resultText.getText());
            return;
        }
        if(buttonText.equals("DEL"))
        {
            dataToCalculate= dataToCalculate.substring(0,dataToCalculate.length()-1);
        }
        else {
            dataToCalculate= dataToCalculate+buttonText;
        }

        solutionText.setText(dataToCalculate);

        String result= getResult(dataToCalculate);

        if(!result.equals("Error"))
        {
            resultText.setText(result);
        }
    }
    void assignId(Button but, int id)
    {
        but= findViewById(id);
        but.setOnClickListener(this);
    }

    String getResult(String data)
    {
        try {
            Context context= Context.enter();
            context.setOptimizationLevel(-1);
            Scriptable scriptable= context.initSafeStandardObjects();
            String result= context.evaluateString(scriptable, data, "Javascript", 1, null).toString();
            if (result.endsWith(".0"))
            {
                result=result.replace(".0", "");
            }
            return result;
        }catch (Exception e)
        {
            return "Error";
        }
    }

}