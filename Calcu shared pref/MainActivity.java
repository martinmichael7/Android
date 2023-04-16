package com.example.calculatorsharedpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private double memory = 0.0;

    boolean isNewOperator = true;
    EditText edt1;
    String operator = "+";
    String initialNumber = "";

    // Shared preferences keys
    private static final String PREFS_NAME = "MyPrefsFile";
    private static final String MEMORY_KEY = "memory";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt1 = findViewById(R.id.editText);

        SharedPreferences sharedPrefs = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        memory = sharedPrefs.getFloat(MEMORY_KEY, 0);
        edt1.setText(String.valueOf(memory));

    }

    public void numberEvent(View view) {

        if (isNewOperator)
            edt1.setText("");
        isNewOperator = false;

        String number = edt1.getText().toString();

        if (view.getId() == R.id.btnOne) {
            number += "1";
        } else if (view.getId() == R.id.btnTwo) {
            number += "2";
        } else if (view.getId() == R.id.btnThree) {
            number += "3";
        } else if (view.getId() == R.id.btnFour) {
            number += "4";
        } else if (view.getId() == R.id.btnFive) {
            number += "5";
        } else if (view.getId() == R.id.btnSix) {
            number += "6";
        } else if (view.getId() == R.id.btnSeven) {
            number += "7";
        } else if (view.getId() == R.id.btnEight) {
            number += "8";
        } else if (view.getId() == R.id.btnNine) {
            number += "9";
        } else if (view.getId() == R.id.btnZero) {
            number += "0";
        } else if (view.getId() == R.id.btnDot) {
            number += ".";
        }
        edt1.setText(number);
    }

    public void operatorEvent(View view) {

        isNewOperator = true;
        initialNumber = edt1.getText().toString();

        if (view.getId() == R.id.btnMultiply) {
            operator = "*";
        } else if (view.getId() == R.id.btnMinus) {
            operator = "-";
        } else if (view.getId() == R.id.btnDivide) {
            operator = "/";
        } else if (view.getId() == R.id.btnPlus) {
            operator = "+";
        }
    }

    public void equalEvent(View view) {
        String newNumber = edt1.getText().toString();
        double output = 0.0;

        if (operator == "+")
            output = Double.parseDouble(initialNumber) + Double.parseDouble(newNumber);

        if (operator == "/")
            output = Double.parseDouble(initialNumber) / Double.parseDouble(newNumber);

        if (operator == "*")
            output = Double.parseDouble(initialNumber) * Double.parseDouble(newNumber);

        if (operator == "-")
            output = Double.parseDouble(initialNumber) - Double.parseDouble(newNumber);

        edt1.setText(output + "");

        // Save memory to shared preferences
        SharedPreferences sharedPrefs = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPrefs.edit();
        editor.putFloat(MEMORY_KEY, (float) output);
        editor.apply();

    }
    public void memoryPlusEvent(View view) {
        String number = edt1.getText().toString();
        double value = Double.parseDouble(number);
        memory += value;
    }

    public void memoryMinusEvent(View view) {
        String number = edt1.getText().toString();
        double value = Double.parseDouble(number);
        memory -= value;
    }

    public void memoryRecallEvent(View view) {
        edt1.setText(String.valueOf(memory));
    }

    public void memoryClearEvent(View view) {
        memory = 0.0;
    }
}