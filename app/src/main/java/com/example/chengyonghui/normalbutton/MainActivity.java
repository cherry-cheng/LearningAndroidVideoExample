package com.example.chengyonghui.normalbutton;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    private ProgressBar firstBar;
    private ProgressBar secondBar;
    private Button myButton;
    private int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firstBar = (ProgressBar) findViewById(R.id.firstBar);
        secondBar = (ProgressBar) findViewById(R.id.secondBar);
        myButton = (Button) findViewById(R.id.myButton);
        myButton.setOnClickListener(new myButtonListner());
        firstBar.setMax(180);
    }

    class myButtonListner implements View.OnClickListener {

        @Override
        public void onClick(View v) {
                if (i == 0) {
                    firstBar.setVisibility(View.VISIBLE);
                    secondBar.setVisibility(View.VISIBLE);
                } else if (i < firstBar.getMax()) {
                    firstBar.setProgress(i);
                    firstBar.setSecondaryProgress(i + 10);
                } else {
                    firstBar.setVisibility(View.GONE);
                    secondBar.setVisibility(View.GONE);
                }
            i = i + 10;
        }
    }
}
