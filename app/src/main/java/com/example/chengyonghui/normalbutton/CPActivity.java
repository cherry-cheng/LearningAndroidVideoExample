package com.example.chengyonghui.normalbutton;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


/**
 * Created by chengyonghui on 2017/9/18.
 */
public class CPActivity extends AppCompatActivity {
    private Button insert = null;
    private Button query = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contentprovider_layout);
        insert = (Button)findViewById(R.id.insert);
        insert.setOnClickListener(new insertOnListener());
        query = (Button)findViewById(R.id.query);
        query.setOnClickListener(new queryOnlistener());
    }

    class insertOnListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            ContentValues values = new ContentValues();
            values.put(FirstProviderMetaData.UserTableMetaData.USER_NAME, "zhangsan");
            Uri uri = getContentResolver().insert(FirstProviderMetaData.UserTableMetaData.CONTENT_URI, values);
            System.out.println("uri------>" + uri.toString());
        }
    }

    class queryOnlistener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            Cursor c = getContentResolver().query(FirstProviderMetaData.UserTableMetaData.CONTENT_URI,
                    null, null, null, null);
            while (c.moveToNext()) {
                System.out.println(c.getString(c.getColumnIndex(FirstProviderMetaData.UserTableMetaData.USER_NAME)));
            }
        }
    }
}
