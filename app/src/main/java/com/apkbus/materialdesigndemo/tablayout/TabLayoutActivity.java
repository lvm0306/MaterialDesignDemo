package com.apkbus.materialdesigndemo.tablayout;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;

import com.apkbus.materialdesigndemo.R;

import java.util.ArrayList;
import java.util.List;

public class TabLayoutActivity extends AppCompatActivity {
    FrameLayout flTab;
    ViewPager vpTab;
    List<String> listTab=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_layout);
        initView();
        initData();
    }

    private void initData() {
        listTab.add("首页");
        listTab.add("商城");
        listTab.add("我的");

    }

    private void initView() {
        flTab= (FrameLayout) findViewById(R.id.fl_tab);
//        tabTab= (TabLayout) findViewById(R.id.tab_tab);
    }
}
