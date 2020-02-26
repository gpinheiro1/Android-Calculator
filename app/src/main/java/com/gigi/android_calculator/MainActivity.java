package com.gigi.android_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
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
        String screenText = screen.getText().toString();
        screenText = screenText.substring(0, screenText.length() - 2);
        screen.setText(screenText);
    }

    public void operators(View view) {
        number1 = screen.getText().toString();
        operator = ((Button) view).getText().toString();
        screen.setText("");
    }

    public void equals(View view) {
        number2 = screen.getText().toString();
        switch (operator) {
            case "/": divisao(); break;
            case "*": times(); break;
            case "-": minus(); break;
            case "+": add(); break;
        }
    }
}
