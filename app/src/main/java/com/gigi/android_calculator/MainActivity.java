package com.gigi.android_calculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String number1 = "";
    String number2 = "";
    String operator = "";
    TextView screen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        screen = findViewById(R.id.screen);
    }

    public void numbers(View view) {
        String buttonText = ((Button)view).getText().toString();
        String screenText = screen.getText().toString();
        String newText = screenText + buttonText;

        screen.setText(newText);
    }

    public void cleanAll(View view) {
        screen.setText("");
    }

    public void clean(View view) {
        if (screen.getText().length() > 0) {
            String screenText = screen.getText().toString();
            screenText = screenText.substring(0, screenText.length() - 1);
            screen.setText(screenText);
        }
    }

    public void operators(View view) {
        number1 = screen.getText().toString();
        operator = ((Button) view).getText().toString();
        screen.setText("");
    }

    public void equals(View view) {
        number2 = screen.getText().toString();
        switch (operator) {
            case "/": division(); break;
            case "*": multiple(); break;
            case "-": minus(); break;
            case "+": sum(); break;
        }
        number1 = "";
        number2 = "";
        operator = "";
    }

    public void dot(View view) {
        String number = screen.getText().toString();
        if (operator.length() == 0) {
            if (number.length() == 0)
                number = "0.";
            else
                number += ".";
            screen.setText(number);
        } else {
            if (number.length() == 0)
                number = "0.";
            else
                number += ".";
            screen.setText(number);
        }
    }

    private void sum() {
        double num1 = Double.parseDouble(number1);
        double num2 = Double.parseDouble(number2);
        double result = num1 + num2;
        screen.setText(verifyLastDigit(result));
    }

    private void multiple() {
        double num1 = Double.parseDouble(number1);
        double num2 = Double.parseDouble(number2);
        double result = num1 * num2;
        screen.setText(verifyLastDigit(result));
    }

    private void minus() {
        double num1 = Double.parseDouble(number1);
        double num2 = Double.parseDouble(number2);
        double result = num1 - num2;
        screen.setText(verifyLastDigit(result));
    }

    private void division() {
        double num1 = Double.parseDouble(number1);
        double num2 = Double.parseDouble(number2);
        double result = num1 / num2;
        screen.setText(verifyLastDigit(result));
    }

    private String verifyLastDigit(double result) {
        String resultString = String.valueOf(result);
        String stringsFinal = resultString.substring(resultString.length() - 2);
        if (stringsFinal.equals(".0"))
            return resultString.substring(0, resultString.length() - 2);
        else
            return resultString;
    }
}
