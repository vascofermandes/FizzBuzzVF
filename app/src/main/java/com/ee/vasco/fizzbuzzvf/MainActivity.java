package com.ee.vasco.fizzbuzzvf;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;

import android.text.TextWatcher;
import android.view.View;

import android.widget.CheckBox;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {


    // UI references.
    private EditText minValue;
    private EditText maxValue;
    private CheckBox report;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set up the initial form.
        minValue = (EditText) findViewById(R.id.min);
        minValue.setInputType(InputType.TYPE_CLASS_NUMBER);
        minValue.setMaxEms(5);
        maxValue = (EditText) findViewById(R.id.max);
        maxValue.setInputType(InputType.TYPE_CLASS_NUMBER);
        maxValue.setMaxEms(5);



        TextWatcher validNumber = new TextWatcher()  {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                minValue.setError(null);
                maxValue.setError(null);

            }

            @Override
            public void afterTextChanged(Editable s)  {

            }
        };

        minValue.addTextChangedListener(validNumber);
        maxValue.addTextChangedListener(validNumber);

        report = (CheckBox) findViewById(R.id.checkboxs3);

    }

    public boolean previousCheck(int min,int max){
        if(!isValidNumber(min)){
            minValue.setError("Numbers should be between 1-99.999");
            return false;
        }
        if(!isValidNumber(max)){
            maxValue.setError("Numbers should be between 1-99.999");
            return false;
        }
        if(!isValidDif(min,max)){
            maxValue.setError("Max value should be bigger than Min value");
            return false;
        }
        if(!isValidRange(min,max)){
            maxValue.setError("Max range is 1000");
            return false;
        }

     return true;
    }

    public void runStep1(View view) {
        int min = Integer.parseInt(minValue.getText().toString());
        int max = Integer.parseInt(maxValue.getText().toString());

        if(previousCheck(min,max)) {

            Intent step = new Intent(this, ResultActivity.class);
            step.putExtra("step1", true);
            step.putExtra("step2", false);
//It looks strange but its related to intent rules when using int and conversion to Integer
            step.putExtra("min", min);
            step.putExtra("max", max);
            step.putExtra("report", report.isChecked());

            startActivity(step);
        }
    }

    public void runStep2(View view) {
        int min = Integer.parseInt(minValue.getText().toString());
        int max = Integer.parseInt(maxValue.getText().toString());

        if(previousCheck(min,max)) {
            Intent step = new Intent(this, ResultActivity.class);
            step.putExtra("step1", false);
            step.putExtra("step2", true);
            //It looks strange but its related to intent rules when using int and conversion to Integer
            step.putExtra("min", min);
            step.putExtra("max", max);
            step.putExtra("report", report.isChecked());

            startActivity(step);
        }
    }




    private boolean isValidRange(int min, int max) {
        return (max-min)<1001;
    }

    private boolean isValidNumber (int value) {
        return value < 1000000 & value > 0 ;
    }

    private boolean isValidDif (int min, int max) {
        return max > min ;
    }





}

