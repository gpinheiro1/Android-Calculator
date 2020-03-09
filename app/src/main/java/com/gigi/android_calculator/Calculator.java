package com.gigi.android_calculator;

public class Calculator {

    String expression;

    public Calculator(String expression) {
        this.expression = expression;

    }

    private void calcular() {

    }

    public String getResult(){
        return this.expression;
    }
}
