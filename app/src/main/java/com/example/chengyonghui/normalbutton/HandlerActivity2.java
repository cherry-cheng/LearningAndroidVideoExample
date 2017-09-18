package com.example.chengyonghui.normalbutton;

import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by chengyonghui on 2017/9/15.
 */
public class HandlerActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.handler_layout2);
        System.out.println("Activity ID------>" + Thread.currentThread().getId());
        HandlerThread handlerThread = new HandlerThread("handler_thread");
        handlerThread.start();
        MyHandler myHandler = new MyHandler(handlerThread.getLooper());
        Message msg = myHandler.obtainMessage();
        msg.obj = "adb";
        Bundle b = new Bundle();
        b.putInt("age", 20);
        b.putString("name", "John");
        msg.setData(b);
        msg.sendToTarget();
    }

    class MyHandler extends Handler {

        public MyHandler() {

        }
        public MyHandler(Looper looper) {
            super(looper);
        }
        @Override
        public void handleMessage(Message msg) {
            String s = msg.obj.toString();
            //取出Bundle对象
            Bundle b = msg.getData();
            int age = b.getInt("age");
            String name = b.getString("name");
            System.out.println("Handler--------->" + Thread.currentThread().getId());
            System.out.println("HandMessage---->" + s);
            System.out.println("Bundle---->>>" + "name is "+name +" age is "+ age);
        }
    }
}
