//Assignment Name: Homework1
//File Name: MainActivity.java
//Name: Prajval Bavi and Bre Iversen

package com.example.hw1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.InputFilter;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.Locale;
import java.util.Stack;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button buttonZero, buttonOne, buttonTwo, buttonThree, buttonFour, buttonFive, buttonSix;
    private Button buttonSeven, buttonEight, buttonNine, buttonEquals, buttonAdd, buttonSubtract;
    private Button buttonMulti, buttonDivide, buttonAC, buttonDot;
    private TextView textViewResult;
    private double arg1, arg2, result;
    private int action;
    private DecimalFormat decimalFormat, decimalFormatLimit;
    private Stack st = new Stack();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        decimalFormat = new DecimalFormat("#.########E+0");
        decimalFormatLimit = new DecimalFormat("#.#############");
        buttonZero = (Button)findViewById(R.id.buttonZero);
        buttonOne = (Button)findViewById(R.id.buttonOne);
        buttonTwo = (Button)findViewById(R.id.buttonTwo);
        buttonThree = (Button)findViewById(R.id.buttonThree);
        buttonFour = (Button)findViewById(R.id.buttonFour);
        buttonFive = (Button)findViewById(R.id.buttonFive);
        buttonSix = (Button)findViewById(R.id.buttonSix);
        buttonSeven = (Button)findViewById(R.id.buttonSeven);
        buttonEight = (Button)findViewById(R.id.buttonEight);
        buttonNine = (Button)findViewById(R.id.buttonNine);
        buttonEquals = (Button)findViewById(R.id.buttonEquals);
        buttonAdd = (Button)findViewById(R.id.buttonPlus);
        buttonSubtract = (Button)findViewById(R.id.buttonMinus);
        buttonDivide = (Button)findViewById(R.id.buttonDivide);
        buttonMulti = (Button)findViewById(R.id.buttonMulti);
        buttonAC = (Button)findViewById(R.id.buttonAC);
        buttonDot = (Button) findViewById(R.id.buttonDot);
        textViewResult = (TextView)findViewById(R.id.textViewResult);

        buttonZero.setOnClickListener(this);
        buttonOne.setOnClickListener(this);
        buttonTwo.setOnClickListener(this);
        buttonThree.setOnClickListener(this);
        buttonFour.setOnClickListener(this);
        buttonFive.setOnClickListener(this);
        buttonSix.setOnClickListener(this);
        buttonSeven.setOnClickListener(this);
        buttonEight.setOnClickListener(this);
        buttonNine.setOnClickListener(this);
        buttonDot.setOnClickListener(this);
        buttonEquals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calResult();
            }
        });
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (textViewResult.getText().toString().equals("Error")) {
                    action = 5;
                }else {
                    arg1 = Double.parseDouble(textViewResult.getText().toString());
                    action = 1;
                }

                st.push("+");
            }
        });
        buttonSubtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (textViewResult.getText().toString().equals("Error")) {
                    action = 5;
                }else {
                    arg1 = Double.parseDouble(textViewResult.getText().toString());
                    action = 2;
                }
                st.push("-");
            }
        });
        buttonDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (textViewResult.getText().toString().equals("Error")) {
                    action = 5;
                }else {
                    arg1 = Double.parseDouble(textViewResult.getText().toString());
                    action = 3;
                }
                st.push("/");
            }
        });
        buttonMulti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (textViewResult.getText().toString().equals("Error")){
                    action = 5;
                }else {
                    arg1 = Double.parseDouble(textViewResult.getText().toString());
                    action = 4;
                }
                st.push("*");
            }
        });
        buttonAC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textViewResult.setText("");
                result = 0;
                arg1 = 0;
                arg2 = 0;
                while(!st.empty())
                  st.pop();
            }
        });



    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (!st.isEmpty()) {
            String test = (String) st.pop();
            if (test.equals("+") || test.equals("-") || test.equals("*") || test.equals("/"))
                textViewResult.setText("");
        }
        if (textViewResult.getText().toString().contains("."))
            textViewResult.setFilters(new InputFilter[]{new InputFilter.LengthFilter(15)});
        else
            textViewResult.setFilters(new InputFilter[]{new InputFilter.LengthFilter(14)});

        if (id == R.id.buttonZero){
                textViewResult.append("0");
        }else if (id == R.id.buttonOne){
                textViewResult.append("1");
        }else if (id == R.id.buttonTwo){
                textViewResult.append("2");
        }else if(id == R.id.buttonThree){
                textViewResult.append("3");
        }else if(id == R.id.buttonFour){
                textViewResult.append("4");
        }else if(id == R.id.buttonFive){
                textViewResult.append("5");
        }else if(id == R.id.buttonSix){
                textViewResult.append("6");
        }else if(id == R.id.buttonSeven){
                textViewResult.append("7");
        }else if(id == R.id.buttonEight){
                textViewResult.append("8");
        }else if(id == R.id.buttonNine){
                textViewResult.append("9");
        }else if (id == R.id.buttonDot){
                textViewResult.append(".");
        }
    }

    public void calResult(){
        arg2 = Double.parseDouble(textViewResult.getText().toString());
        switch (action){
            case 1:
                result = arg1 + arg2;
                break;
            case 2:

                result = arg1 - arg2;
                break;
            case 3:
                if (arg2 != 0)
                    result = arg1 / arg2;
                else if (arg2 == 0 && arg1 == 0)
                    result = 0;
                else
                    textViewResult.setText("Error");
                break;
            case 4:
                result = arg1 * arg2;
                break;
            case 5:
                textViewResult.setText("Error");
                break;
            default:
                textViewResult.setText("NA");

        }

        if (!(textViewResult.getText().toString().equals("Error"))){
            if (result >= 9.99999999999999E13) {
                textViewResult.setText(decimalFormat.format(result));
            }
            else if (result <= -9.99999999999999E11 && result >= -9.99999999999999E13) {
                textViewResult.setFilters(new InputFilter[]{new InputFilter.LengthFilter(15)});
                DecimalFormat decimalFormatLimitMinus = new DecimalFormat("###############");
                textViewResult.setText(decimalFormatLimitMinus.format(result));
                textViewResult.setFilters(new InputFilter[]{new InputFilter.LengthFilter(14)});
            }
            else if (result < -9.99999999999999E13) {
                DecimalFormat decimalFormatLimitBMinus = new DecimalFormat("#.######E+0");
                textViewResult.setText(decimalFormatLimitBMinus.format(result));
            }
            else if (result == 0)
                textViewResult.setText("0");
            else
                textViewResult.setText(decimalFormatLimit.format(result));
        }


    }

}
