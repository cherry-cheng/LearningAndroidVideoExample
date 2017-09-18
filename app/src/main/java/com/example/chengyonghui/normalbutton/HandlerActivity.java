package com.example.chengyonghui.normalbutton;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by chengyonghui on 2017/9/15.
 */
public class HandlerActivity extends AppCompatActivity {
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //handler.post(r);
        Thread thread = new Thread(r);
        thread.start();
        setContentView(R.layout.handler_layout);
        System.out.println("activity----------->" + Thread.currentThread().getId());
        System.out.println("ctivity name--------->" + Thread.currentThread().getName());
    }

    Runnable r = new Runnable() {
        @Override
        public void run() {
            System.out.println("handler----------->" + Thread.currentThread().getId());
            System.out.println("handler name------------->" + Thread.currentThread().getName());
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    };
}
