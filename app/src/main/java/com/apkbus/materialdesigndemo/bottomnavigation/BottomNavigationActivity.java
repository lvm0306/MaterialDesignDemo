package com.apkbus.materialdesigndemo.bottomnavigation;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.apkbus.materialdesigndemo.R;
import com.apkbus.materialdesigndemo.util.BottomNavigationViewHelper;
import com.apkbus.materialdesigndemo.util.ToastUtil;

/**
 * 1.BottomNavigationView 显示
 * 2.更改图标的颜色
 * 3.超过3个menu item 默认的显示方式变成当前选中的选项显示文字，其他选项不显示文字，想变成传统的显示方式，需要通过反射的方式去改变控件的默认设置
 * 4.BottomNavigationView 与 Fragment 的组合使用
 */
public class BottomNavigationActivity extends AppCompatActivity {
    private BottomNavigationView view_bottom, view_center;
    private ToastUtil util;
    private ViewPager pager;
    private MenuItem menuItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_navigation);
        util = new ToastUtil(this);
        view_bottom = (BottomNavigationView) findViewById(R.id.bnv_bna_bottom);
        view_center = (BottomNavigationView) findViewById(R.id.bnv_bna_center);
        pager = (ViewPager) findViewById(R.id.vp_bnv);
        BottomNavigationViewHelper.disableShiftMode(view_bottom);
        view_bottom.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.page_main:
                        ToastUtil.show("主页");
                        break;
                    case R.id.page_list:
                        ToastUtil.show("分类");
                        break;
                    case R.id.page_mine:
                        Toast.makeText(BottomNavigationActivity.this, "列表", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.page_discovery:
                        ToastUtil.show("发现");
                        break;
                    default:
                        break;
                }

                return true;
            }
        });
        view_center.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.page_main:
                        //Logical processing
                        pager.setCurrentItem(0);
                        break;
                    case R.id.page_list:
                        pager.setCurrentItem(1);
                        break;
                    case R.id.page_mine:
                        pager.setCurrentItem(2);
                        break;

                    case R.id.page_discovery:
                        pager.setCurrentItem(3);
                        break;
                    default:
                        break;
                }

                return true;
            }
        });
        pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                if (menuItem != null) {
                    menuItem.setChecked(false);
                } else {
                    view_center.getMenu().getItem(0).setChecked(false);
                }
                menuItem = view_center.getMenu().getItem(position);
                menuItem.setChecked(true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        setupViewPager(pager);
    }

    private void setupViewPager(ViewPager pager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());

        adapter.addFragment(NewFragment.newInstance("新闻"));
        adapter.addFragment(NewFragment.newInstance("图书"));
        adapter.addFragment(NewFragment.newInstance("发现"));
        adapter.addFragment(NewFragment.newInstance("更多"));
        pager.setAdapter(adapter);
    }
}
