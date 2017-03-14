package com.github.mzule.fantasyslide.common;

import android.widget.Toast;

import com.github.mzule.fantasyslide.base.BaseApplication;

/**
 * Created by shanhong on 3/14/17.
 */

public class ToastUtil {

    public static void showShort(String msg) {
        Toast.makeText(BaseApplication.getAppContext(), msg, Toast.LENGTH_SHORT).show();
    }

    public static void showLong(String msg) {
        Toast.makeText(BaseApplication.getAppContext(), msg, Toast.LENGTH_LONG).show();
    }
}
