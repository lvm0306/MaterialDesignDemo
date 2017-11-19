package com.apkbus.materialdesigndemo;

import android.content.Context;
import android.content.Intent;

/**
 * Created by shx on 2017/9/22.
 */
public class Utils {
    public static void goNextActivity(Context context, Class T) {
        Intent intent = new Intent();
        intent.setClass(context, T);
        context.startActivity(intent);
    }
}
