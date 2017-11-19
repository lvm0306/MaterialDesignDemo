package com.apkbus.materialdesigndemo.util;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by shx on 2017/9/26.
 */
public class ToastUtil {
    private static Toast toast;
    private static Context context;
    private static int DEFAULT_TIME = Toast.LENGTH_SHORT;

    public ToastUtil(Context context) {
        this.context = context;
    }

    public static void showToast(Context context, String content, int time) {
        if (toast == null) {
            toast = Toast.makeText(context, content, time);
        } else {
            toast.setText(content);
        }
        toast.show();

    }

    public static void show(String content) {
        if (toast == null) {
            toast = Toast.makeText(context, content, DEFAULT_TIME);
        } else {
            toast.setText(content);
        }
        toast.show();

    }
}
