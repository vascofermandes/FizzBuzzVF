package com.ee.vasco.fizzbuzzvf;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import android.widget.TextView;
import android.widget.Toast;


public class ResultActivity extends AppCompatActivity {



    // UI references.
    private TextView res;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        res = (TextView) findViewById(R.id.results);

        Intent intent = getIntent();
        int min = intent.getIntExtra("min", 0);
        int max = intent.getIntExtra("max", 0);
        boolean report = intent.getBooleanExtra("report", false);
        boolean step1 = intent.getBooleanExtra("step1", false);
        boolean step2 = intent.getBooleanExtra("step2", false);


        if (step1) {
            res.setText(RunRangeFB.step1((int)min,(int) max, report));
        }
        if(step2)
            res.setText(RunRangeFB.step2((int)min, (int)max, report));

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

            int min = data.getExtras().getInt("min");
            int max = data.getExtras().getInt("max");
            boolean report = data.getExtras().getBoolean("report");

            Toast.makeText(this, data.getExtras().getString("returnKey1"),
                    Toast.LENGTH_SHORT).show();

        if (data.hasExtra("step1")) {
            res.setText(RunRangeFB.step1(min, max, report));
        }
        else
            res.setText(RunRangeFB.step2(min, max, report));
    }

}

