package com.example.chengyonghui.normalbutton;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.chengyonghui.normalbutton.util.HttpDownloader;

/**
 * Created by chengyonghui on 2017/9/18.
 */
public class DownloadActivity extends AppCompatActivity {
    private Button download1 = null;
    private Button download2 = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.download_layout);
        download1 = (Button) findViewById(R.id.download1);
        download1.setOnClickListener(new downloadListener1());
        download2 = (Button) findViewById(R.id.download2);
        download2.setOnClickListener(new downloadListener2());
    }
    class downloadListener1 implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            HttpDownloader httpDownloader = new HttpDownloader();
            String lrc = httpDownloader.download("https://we.tl/SSHyV6EG8C");
            System.out.println(lrc);
        }
    }
    class downloadListener2 implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            HttpDownloader httpDownloader = new HttpDownloader();
            int result = httpDownloader.downFile("http://172.16.110.175:8080/","C:\\Users\\chengyonghui\\Desktop\\Entertainment\\music", "yanguichao");
            System.out.println(result);
        }
    }
}
