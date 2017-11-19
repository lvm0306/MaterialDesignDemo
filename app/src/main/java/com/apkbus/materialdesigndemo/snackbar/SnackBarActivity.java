package com.apkbus.materialdesigndemo.snackbar;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.design.widget.BaseTransientBottomBar;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.apkbus.materialdesigndemo.R;
import com.apkbus.materialdesigndemo.util.SnackbarManager;

/**
 * SnackBar :轻量级的弹出框，可滑动关闭，屏幕同时只能有一个SnackBar,只有在CoorDinatorLayout下才能滑动删除
 * SnackBar 与 ToastUtil 很相似，主观上可以认为，SnackBar 是 介于Toast和Dialog的
 */
public class SnackBarActivity extends AppCompatActivity implements View.OnClickListener {
    TextView tvNoClick, tvOnClick, tvSlide, tvStyle, tvLayout;
    LinearLayout llSnackBar;
    CoordinatorLayout clSb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snack_bar);
        //初始化控件
        initView();
        tvStyle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Snackbar sb = Snackbar.make(
                        clSb,
                        "更改布局的SnackBar,图片可点击",
                        Snackbar.LENGTH_LONG);
                View view1 = sb.getView();
                Snackbar.SnackbarLayout sl = (Snackbar.SnackbarLayout) view1;
                View inflate = LayoutInflater.from(sb.getContext()).inflate(R.layout.item_sb_layout, null);
                ImageView imageView = (ImageView) inflate.findViewById(R.id.iv_sb);
                imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(
                                SnackBarActivity.this,
                                "点击了图片",
                                Toast.LENGTH_SHORT).show();
                        sb.dismiss();
                    }
                });

                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                layoutParams.gravity = Gravity.CENTER;
                sl.removeAllViews();
                sl.addView(inflate, layoutParams);
                sb.show();
            }
        });
    }

    private void initView() {
        tvNoClick = (TextView) findViewById(R.id.tv_sb_noclick);
        tvOnClick = (TextView) findViewById(R.id.tv_sb_click);
        tvSlide = (TextView) findViewById(R.id.tv_sb_slide);
        tvStyle = (TextView) findViewById(R.id.tv_sb_style);
        tvLayout = (TextView) findViewById(R.id.tv_sb_changelayout);
        llSnackBar = (LinearLayout) findViewById(R.id.ll_snackbar);
        clSb = (CoordinatorLayout) findViewById(R.id.cl_sb);
        tvNoClick.setOnClickListener(this);
        tvOnClick.setOnClickListener(this);
        tvSlide.setOnClickListener(this);
        tvStyle.setOnClickListener(this);
        tvLayout.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_sb_noclick:
                Snackbar.make(llSnackBar, "不不不带点击的SnackBar", 3000)
                        .setAction("", null)
                        .show();
                break;
            case R.id.tv_sb_click:
                Snackbar.make(llSnackBar, "带点击的SnackBar", 3000)
                        .setAction("点击", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(SnackBarActivity.this, "不能滑动哦", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .show();
                break;
            case R.id.tv_sb_slide:
                Snackbar.make(clSb, "可滑动取消的SnackBar", 3000)
                        .setAction("点击", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(SnackBarActivity.this, "可滑动删除哦", Toast.LENGTH_SHORT).show();

                                SnackbarManager.getInstance().dismiss(null, BaseTransientBottomBar.BaseCallback.DISMISS_EVENT_ACTION);
                            }
                        }).show();
                break;
            case R.id.tv_sb_style:
                final Snackbar sbSlide = Snackbar.make(clSb, "增加图标，颜色改变，文字可点击", 3000);
                View view = sbSlide.getView();
                TextView tvSbSuper = (TextView) view.findViewById(android.support.design.R.id.snackbar_text);
                Button btnSbSuper = (Button) view.findViewById(android.support.design.R.id.snackbar_action);
                tvSbSuper.setTextColor(getResources().getColor(R.color.colorPrimaryDark));

                sbSlide.setActionTextColor(getResources().getColor(R.color.green));
                btnSbSuper.setTextColor(Color.BLACK);

                tvSbSuper.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(SnackBarActivity.this, "点到了Tv", Toast.LENGTH_SHORT).show();
                        sbSlide.dismiss();
                    }
                });
                Drawable drawable = getResources().getDrawable(R.mipmap.ic_launcher);
                tvSbSuper.setCompoundDrawablesWithIntrinsicBounds(drawable, null, null, null);
                view.setBackgroundColor(Color.YELLOW);
                sbSlide.setAction("点击", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(SnackBarActivity.this, "可滑动删除哦", Toast.LENGTH_SHORT).show();
                    }
                }).show();
                break;
            case R.id.tv_sb_changelayout:
                //// TODO: 2017/9/25  snackBar 可添加view 可删除view,删除原Snackbar view后不能调用setAction()等跟原布局控件有关的方法，否则会崩溃
                final Snackbar sb = Snackbar.make(clSb, "更改布局的SnackBar,图片可点击", Snackbar.LENGTH_LONG);
                View view1 = sb.getView();
                Snackbar.SnackbarLayout sl = (Snackbar.SnackbarLayout) view1;
                View inflate = LayoutInflater.from(sb.getContext()).inflate(R.layout.item_sb_layout, null);
                ImageView imageView = (ImageView) inflate.findViewById(R.id.iv_sb);
                imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(SnackBarActivity.this, "点击了图片", Toast.LENGTH_SHORT).show();
                        sb.dismiss();
                    }
                });

                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                layoutParams.gravity = Gravity.CENTER;
                sl.removeAllViews();
                sl.addView(inflate, layoutParams);
                sb.show();
                break;

            default:
                break;
        }
    }
}
