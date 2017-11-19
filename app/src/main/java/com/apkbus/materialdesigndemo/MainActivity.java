package com.apkbus.materialdesigndemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.apkbus.materialdesigndemo.appbarlayout.AppBarLayoutActivity;
import com.apkbus.materialdesigndemo.bottomnavigation.BottomNavigationActivity;
import com.apkbus.materialdesigndemo.coordinatorlayout.CoordingatorLayoutActivity;
import com.apkbus.materialdesigndemo.floatingactionbutton.FloatingActionButtonActivity;
import com.apkbus.materialdesigndemo.navigationview.NavigationViewActivity;
import com.apkbus.materialdesigndemo.snackbar.SnackBarActivity;
import com.apkbus.materialdesigndemo.tablayout.TabLayoutActivity;
import com.apkbus.materialdesigndemo.textinputlayout.TextInputLayoutActivity;
import com.apkbus.materialdesigndemo.toolbar.ToolBarActivity;
import com.apkbus.materialdesigndemo.util.Utils;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView tvSnackBar, tvBottomNavigationView, tvToolbar, tvCoordinatorLayout, tvTextInput,
            tvTabLayout, tvFloatingBar, tvAppBar, tvNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        tvSnackBar = (TextView) findViewById(R.id.tv_snackbar);
        tvBottomNavigationView = (TextView) findViewById(R.id.tv_bottomnavigation);
        tvToolbar = (TextView) findViewById(R.id.tv_toolbar);
        tvCoordinatorLayout = (TextView) findViewById(R.id.tv_coordinatorlayout);
        tvTextInput = (TextView) findViewById(R.id.tv_textinput);
        tvTabLayout = (TextView) findViewById(R.id.tv_tablayout);
        tvFloatingBar = (TextView) findViewById(R.id.tv_floatingbar);
        tvAppBar = (TextView) findViewById(R.id.tv_appbar);
        tvNavigationView = (TextView) findViewById(R.id.tv_navigationview);

        tvSnackBar.setOnClickListener(this);
        tvBottomNavigationView.setOnClickListener(this);
        tvToolbar.setOnClickListener(this);
        tvCoordinatorLayout.setOnClickListener(this);
        tvTextInput.setOnClickListener(this);
        tvTabLayout.setOnClickListener(this);
        tvFloatingBar.setOnClickListener(this);
        tvAppBar.setOnClickListener(this);
        tvNavigationView.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_snackbar:
                Utils.goNextActivity(this, SnackBarActivity.class);
                break;
            case R.id.tv_bottomnavigation:
                Utils.goNextActivity(this, BottomNavigationActivity.class);
                break;
            case R.id.tv_toolbar:
                Utils.goNextActivity(this, ToolBarActivity.class);
                break;
            case R.id.tv_coordinatorlayout:
                Utils.goNextActivity(this, CoordingatorLayoutActivity.class);
                break;
            case R.id.tv_textinput:
                Utils.goNextActivity(this, TextInputLayoutActivity.class);
                break;
            case R.id.tv_tablayout:
                Utils.goNextActivity(this, TabLayoutActivity.class);
                break;
            case R.id.tv_floatingbar:
                Utils.goNextActivity(this, FloatingActionButtonActivity.class);
                break;
            case R.id.tv_appbar:
                Utils.goNextActivity(this, AppBarLayoutActivity.class);
                break;
            case R.id.tv_navigationview:
                Utils.goNextActivity(this, NavigationViewActivity.class);
                break;
            default:
                break;
        }
    }
}
