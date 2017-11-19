package com.apkbus.materialdesigndemo;

import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * SnackBar :轻量级的弹出框，可滑动关闭，屏幕同时只能有一个SnackBar,只有在CoorDinatorLayout下才能滑动删除
 * SnackBar 与 Toast 很相似，主观上可以认为，SnackBar 是 Toast 的升级版
 */
public class SnackBarActivity extends AppCompatActivity implements View.OnClickListener {
    TextView tvNoClick;
    CoordinatorLayout llSnackBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snack_bar);
        initView();
    }

    private void initView() {
        tvNoClick = (TextView) findViewById(R.id.tv_sb_noclick);
        llSnackBar = (CoordinatorLayout) findViewById(R.id.ll_snackbar);
        tvNoClick.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_sb_noclick:
                Snackbar.make(llSnackBar, "我是一只小青龙小呀嘛小青龙", 3000)
                        .setAction("666", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(SnackBarActivity.this, "Delete", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .show();
                break;
//            case :
//                break;
            default:
                break;
        }
    }
}
