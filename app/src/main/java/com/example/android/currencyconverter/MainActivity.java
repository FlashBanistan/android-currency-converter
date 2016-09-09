package com.example.android.currencyconverter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    double pesoExchangeRate = 18.87;
    double dollarExchangeRate = 0.053;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    private void displayAnswerInPesos (double answer){
        TextView answerInPesos = (TextView) findViewById(R.id.in_pesos);
        answerInPesos.setText("$" + answer + " pesos");

    }

    private void displayAnswerInDollars (double answer){
        TextView answerInDollars = (TextView) findViewById(R.id.in_dollars);
        answerInDollars.setText("$" + answer + " dollars");

    }

    public void dollarsToPesos (View view) {
        EditText getDollars = (EditText) findViewById(R.id.us_dollar);
        double dollarAmount = Double.parseDouble(getDollars.getText().toString());
        double answer = calculateDollarsToPesos(dollarAmount);
        displayAnswerInPesos(answer);

    }

    public void pesosToDollars (View view){
        EditText getPesos = (EditText) findViewById(R.id.mexican_peso);
        double pesoAmount = Double.parseDouble(getPesos.getText().toString());
        double answer = calculatePesosToDollars(pesoAmount);
        displayAnswerInDollars(answer);
    }

    public double calculateDollarsToPesos (double dollars) {

        return dollars * pesoExchangeRate;
    }

    public double calculatePesosToDollars (double pesos) {
        return pesos * dollarExchangeRate;
    }

    public void resetText (View view) {
        EditText mexicanTextToReset = (EditText) findViewById(R.id.mexican_peso);
        EditText usTextToReset = (EditText) findViewById(R.id.us_dollar);

        mexicanTextToReset.setText("");
        usTextToReset.setText("");
    }

}
