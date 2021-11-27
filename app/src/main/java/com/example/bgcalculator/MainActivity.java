package com.example.bgcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    //In grid layout format
    private Button buttonAC, buttonDelete, buttonDivide, buttonMultiply,
                   buttonSeven, buttonEight, buttonNine, buttonMinus,
                   buttonFour, buttonFive, buttonSix, buttonAdd,
                   buttonOne, buttonTwo, buttonThree, buttonEquals,
                   buttonNegativePositive, buttonZero, buttonPoint;

    private TextView textViewResult, textViewHistory;

    private String number = null, history, currentResult;

    double firstNumber = 0;    //gets value transferred from lastNumber when an operator is pressed
    double lastNumber = 0;     //stores last value printed on screen

    //Used when multiple operators are in the equation
    String status = null;
    boolean operator = false, ACControl = true, equalsControl = false, negativeControl = true, point = true;     //point variable allows for decimal point to be used once

    DecimalFormat decimalFormatter = new DecimalFormat("########.#####");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Matching all Button objects to their Views
        buttonAC = findViewById(R.id.buttonAC);
        buttonDelete = findViewById(R.id.buttonDelete);
        buttonDivide = findViewById(R.id.buttonDivide);
        buttonMultiply = findViewById(R.id.buttonMultiply);

        buttonSeven = findViewById(R.id.buttonSeven);
        buttonEight = findViewById(R.id.buttonEight);
        buttonNine = findViewById(R.id.buttonNine);
        buttonMinus = findViewById(R.id.buttonMinus);

        buttonFour = findViewById(R.id.buttonFour);
        buttonFive = findViewById(R.id.buttonFive);
        buttonSix = findViewById(R.id.buttonSix);
        buttonAdd = findViewById(R.id.buttonAdd);

        buttonOne = findViewById(R.id.buttonOne);
        buttonTwo = findViewById(R.id.buttonTwo);
        buttonThree = findViewById(R.id.buttonThree);
        buttonEquals = findViewById(R.id.buttonEquals);

        buttonNegativePositive = findViewById(R.id.buttonNegativePositive);
        buttonZero = findViewById(R.id.buttonZero);
        buttonPoint = findViewById(R.id.buttonPoint);

        //Matching TextViews to their IDs
        textViewResult = findViewById(R.id.textViewResult);
        textViewHistory = findViewById(R.id.textViewHistory);

        //Click Listeners
        buttonAC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number = null;
                status = null;
                textViewResult.setText("0");
                textViewHistory.setText("");
                firstNumber = 0;
                lastNumber = 0;
                point = true;
                ACControl = true;
            }
        });
        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ACControl == true){
                    textViewResult.setText("0");
                } else {
                    number = number.substring(0, number.length()-1);
                    if (number.length() == 0){
                        buttonDelete.setClickable(false);     //prevents app from closing if no more numbers to delete
                    } else if (number.contains(".")){
                        point = false;
                    } else {                                  //makes decimal point clickable again after deletion
                        point = true;
                    }
                    textViewResult.setText(number);
                }
            }
        });
        buttonDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                history = textViewHistory.getText().toString();
                currentResult = textViewResult.getText().toString();
                textViewHistory.setText(history+currentResult+"-");

                if (operator == true){
                    if (status == "Multiplication"){
                        multiply();
                    } else if (status == "Subtraction") {
                        minus();
                    } else if (status == "Addition"){
                        plus();
                    } else {
                        divide();
                    }
                }
                status = "Division";
                operator = false;
                number = null;
            }
        });
        buttonMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                history = textViewHistory.getText().toString();
                currentResult = textViewResult.getText().toString();
                textViewHistory.setText(history+currentResult+"*");

                if (operator == true){
                    if (status == "Subtraction"){
                        minus();
                    } else if (status == "Division") {
                        divide();
                    } else if (status == "Addition"){
                        plus();
                    } else {
                        multiply();
                    }
                }
                status = "Multiplication";
                operator = false;
                number = null;
            }
        });
                            //ROW 1
        buttonSeven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClick("7");
            }
        });
        buttonEight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClick("8");
            }
        });
        buttonNine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClick("9");
            }
        });
        buttonMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                history = textViewHistory.getText().toString();
                currentResult = textViewResult.getText().toString();
                textViewHistory.setText(history+currentResult+"-");
                if (operator == true){
                    if (status == "Multiplication"){
                        multiply();
                    } else if (status == "Division") {
                        divide();
                    } else if (status == "Addition"){
                        plus();
                    } else {
                        minus();
                    }
                }
                status = "Subtraction";
                operator = false;
                number = null;
            }
        });
                            //ROW 2
        buttonFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClick("4");
            }
        });
        buttonFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClick("5");
            }
        });
        buttonSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClick("6");
            }
        });
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                history = textViewHistory.getText().toString();
                currentResult = textViewResult.getText().toString();
                textViewHistory.setText(history+currentResult+"+");

                if (operator == true){
                     if (status == "Multiplication"){
                         multiply();
                     } else if (status == "Division") {
                         divide();
                     } else if (status == "Subtraction"){
                         minus();
                     } else {
                         plus();
                     }
                }
                status = "Addition";
                operator = false;
                number = null;
            }
        });
                            //ROW 3
        buttonOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClick("1");
            }
        });
        buttonTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClick("2");
            }
        });
        buttonThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClick("3");
            }
        });
        buttonEquals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (operator == true){
                    if (status == "Multiplication"){
                        multiply();
                    } else if (status == "Division"){
                        divide();
                    } else if (status == "Addition"){
                        plus();
                    } else if (status == "Subtraction"){
                        minus();
                    } else {
                        firstNumber = Double.parseDouble(textViewResult.getText().toString());
                    }
                }
                operator = false;
                equalsControl = true;
            }
        });
                            //ROW 4
        buttonNegativePositive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (negativeControl == true) {
                    textViewResult.setText("-" + number);
                    negativeControl = false;
                } else {
                    char positive = ' ';
                    textViewResult.setText(number.replace('-', positive));      //replaces negative symbol with empty character
                    negativeControl = true;
                }
            }
        });
        buttonZero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClick("0");
            }
        });
        buttonPoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (point == true){
                    if (number == null){
                        number = "0.";
                    } else {
                        number = number + ".";
                    }
                }
                textViewResult.setText(number);
                point = false;     //prevents point from being used again
            }
        });
    }
    //Adds number to textViewResult
    public void numberClick(String view){
        if (number == null){
            number = view;
        } else if (equalsControl == true) {
            firstNumber = 0;
            lastNumber = 0;
            number = view;
        } else {
            number = number + view;
        }
        textViewResult.setText(number);
        operator = true;
        //Allows AC,delete, and equals buttons to function again
        ACControl = false;
        buttonDelete.setClickable(true);
        equalsControl = false;
    }
    public void plus(){
        lastNumber = Double.parseDouble(textViewResult.getText().toString());
        firstNumber = firstNumber + lastNumber;
        textViewResult.setText(decimalFormatter.format(firstNumber));
        point = true;
    }
    public void minus(){
        if(firstNumber == 0){
            firstNumber = Double.parseDouble(textViewResult.getText().toString());
        } else {
            lastNumber = Double.parseDouble(textViewResult.getText().toString());
            firstNumber = firstNumber - lastNumber;
        }
        textViewResult.setText(decimalFormatter.format(firstNumber));
        point = true;
    }
    public void multiply(){
        if (firstNumber == 0){
            firstNumber = 1;
            lastNumber = Double.parseDouble(textViewResult.getText().toString());
            firstNumber = firstNumber * lastNumber;
        } else {
            lastNumber = Double.parseDouble(textViewResult.getText().toString());
            firstNumber = firstNumber * lastNumber;
        }
        textViewResult.setText(decimalFormatter.format(firstNumber));
        point = true;
    }
    public void divide() {
        if (firstNumber == 0) {
            lastNumber = Double.parseDouble(textViewResult.getText().toString());
            firstNumber = lastNumber / 1;
        } else {
            lastNumber = Double.parseDouble(textViewResult.getText().toString());
            firstNumber = firstNumber / lastNumber;
        }
        textViewResult.setText(decimalFormatter.format(firstNumber));
        point = true;
    }
}