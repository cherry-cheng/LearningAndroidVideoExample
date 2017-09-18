package com.example.chengyonghui.normalbutton;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by chengyonghui on 2017/9/14.
 */
public class ListActivity extends android.app.ListActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_layout);
        ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
        HashMap<String, String> map1 = new HashMap<String, String>();
        HashMap<String, String> map2 = new HashMap<String, String>();
        HashMap<String, String> map3 = new HashMap<String, String>();
        HashMap<String, String> map4 = new HashMap<String, String>();
        HashMap<String, String> map5 = new HashMap<String, String>();
        HashMap<String, String> map6 = new HashMap<String, String>();
        HashMap<String, String> map7 = new HashMap<String, String>();
        HashMap<String, String> map8 = new HashMap<String, String>();
        HashMap<String, String> map9 = new HashMap<String, String>();
        HashMap<String, String> map10 = new HashMap<String, String>();
        HashMap<String, String> map11 = new HashMap<String, String>();
        HashMap<String, String> map12 = new HashMap<String, String>();
        map1.put("user_name",  "chengyonghui");
        map1.put("user_ip", "192.0.0.1");
        map2.put("user_name", "yuanxin");
        map2.put("user_ip", "189.0.9.1");
        map3.put("user_name", "chengguizhong");
        map3.put("user_ip", "167.0.9.9");
        map4.put("user_name",  "chengyonghui");
        map4.put("user_ip", "192.0.0.1");
        map5.put("user_name", "yuanxin");
        map5.put("user_ip", "189.0.9.1");
        map6.put("user_name", "chengguizhong");
        map6.put("user_ip", "167.0.9.9");
        map7.put("user_name",  "chengyonghui");
        map7.put("user_ip", "192.0.0.1");
        map8.put("user_name", "yuanxin");
        map8.put("user_ip", "189.0.9.1");
        map9.put("user_name", "chengguizhong");
        map9.put("user_ip", "167.0.9.9");
        map10.put("user_name",  "chengyonghui");
        map10.put("user_ip", "192.0.0.1");
        map11.put("user_name", "yuanxin");
        map11.put("user_ip", "189.0.9.1");
        map12.put("user_name", "chengguizhong");
        map12.put("user_ip", "167.0.9.9");
        list.add(map1);
        list.add(map3);
        list.add(map2);
        list.add(map4);
        list.add(map5);
        list.add(map6);
        list.add(map7);
        list.add(map8);
        list.add(map9);
        list.add(map10);
        list.add(map11);
        list.add(map12);
        SimpleAdapter lisAdapter = new SimpleAdapter(this,
                list, R.layout.listview_data_layout,
                new String[] {"user_name", "user_ip"},
                new  int[] {R.id.user_name, R.id.user_ip});
        setListAdapter(lisAdapter);
    }

    @Override
    protected void onListItemClick(ListView listView, View v, int position, long id) {
        super.onListItemClick(listView, v, position, id);
        System.out.println("id--------------------" + id);
        System.out.println("position------------" + position);
    }
}
