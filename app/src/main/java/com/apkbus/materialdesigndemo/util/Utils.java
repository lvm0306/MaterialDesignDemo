package com.apkbus.materialdesigndemo.util;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by ivm
 * 简书:ivm
 */
public class Utils {
    /**
     * Go Next Activity
     *
     * @param context context
     * @param T       class type
     */
    public static void goNextActivity(Context context, Class T) {
        Intent intent = new Intent();
        intent.setClass(context, T);
        context.startActivity(intent);
    }

    /**
     * go  next Activity with bundle
     *
     * @param context context
     * @param T       class type
     * @param bundle  budle
     */
    public static void goNextActivityWithBundle(Context context, Class T, Bundle bundle) {
        Intent intent = new Intent();
        intent.setClass(context, T);
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

}
