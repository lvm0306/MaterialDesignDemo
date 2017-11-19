package com.apkbus.materialdesigndemo.floatingactionbutton;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.apkbus.materialdesigndemo.R;

public class FloatingActionButtonActivity extends AppCompatActivity {
    FloatingActionButton fab;
    LinearLayout llFab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_floating_action_button);
        initView();
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(llFab, "FloatingActionBar", Snackbar.LENGTH_SHORT).setAction("点击", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(FloatingActionButtonActivity.this, "点击我", Toast.LENGTH_SHORT).show();
                    }
                }).show();
            }
        });

    }

    private void initView() {
        fab = (FloatingActionButton) findViewById(R.id.fab_fab);
        llFab = (LinearLayout) findViewById(R.id.ll_fab);
    }
}
