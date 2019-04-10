package com.btten.mvparm.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;

import com.btten.mvparm.base.MvpApplication;

/**
 * 功能：显示Toast信息工具类
 */
public class ShowToast {
    /**
     * 表示无效的值，用于判断颜色与资源id值
     */
    private static final int INVALID=-1;
    /**
     * 默认的自定义的Toast显示的时间长度
     */
    public static final int DEFAULT_CUSTOM_DURATION=1500;
    /**
     * 长时间显示Toast的时间长度
     */
    public static final int LONG_CUSTOM_DURATION=3 * 1000;

    /**
     * 显示Toast提示信息
     *
     * @param msg 提示内容
     */
    public static void showToast(String msg) {
        showToast(MvpApplication.getApplication().getApplicationContext(), msg);
    }

    /**
     * @param context
     * @param msg
     * @author：Frj 功能:显示Toast提示信息 使用方法：
     */
    public static void showToast(Context context, String msg) {
        showToast(context, msg, false);
    }

    /**
     * 显示Toast提示信息
     *
     * @param value 提示内容
     */
    public static void showToast(int value) {
        showToast(MvpApplication.getApplication().getApplicationContext(), value);
    }

    /**
     * @param context
     * @param value
     * @author：Frj 功能:显示Toast提示信息 使用方法：
     */
    public static void showToast(Context context, int value) {
        showToast(context, String.valueOf(value), false);
    }

    /**
     * 显示Toast提示信息
     *
     * @param value 提示内容
     */
    public static void showToast(float value) {
        showToast(MvpApplication.getApplication().getApplicationContext(), value);
    }

    /**
     * @param context
     * @param value
     * @author：Frj 功能:显示Toast提示信息 使用方法：
     */
    public static void showToast(Context context, float value) {
        showToast(context, String.valueOf(value), false);
    }

    /**
     * 显示Toast提示信息
     *
     * @param value 提示内容
     */
    public static void showToast(double value) {
        showToast(MvpApplication.getApplication().getApplicationContext(), value);
    }

    /**
     * @param context
     * @param value
     * @author：Frj 功能:显示Toast提示信息 使用方法：
     */
    public static void showToast(Context context, double value) {
        showToast(context, String.valueOf(value), false);
    }

    /**
     * 显示Toast提示信息
     *
     * @param value 提示内容
     */
    public static void showToast(boolean value) {
        showToast(MvpApplication.getApplication().getApplicationContext(), value);
    }

    /**
     * @param context
     * @param value
     * @author：Frj 功能:显示Toast提示信息 使用方法：
     */
    public static void showToast(Context context, boolean value) {
        showToast(context, String.valueOf(value), false);
    }

    /**
     * @param context
     * @param msg
     * @param isLong  表示是否是长时间显示 TRUE表示是
     * @author：Frj 功能:显示Toast提示信息 使用方法：
     */
    static final Looper mainLooper=Looper.getMainLooper();

    private static Handler handler=new Handler(mainLooper);

    public static void runOnuiThread(Runnable task) {
        handler.post(task);
    }

    private static Toast toast;

    @SuppressLint("ShowToast")
    public static void showToast(final Context context, final String msg, boolean isLong) {
        if (context != null && msg != null) {
            runOnuiThread(new Runnable() {
                @Override
                public void run() {
                    if (toast == null) {
                        toast=Toast.makeText(context, "", Toast.LENGTH_SHORT);
                    }
                    toast.setText(msg);
                    toast.show();
                }
            });
        }

    }

    /**
     * @param context
     * @param value
     * @author：Frj 功能:显示Toast提示信息 使用方法：
     */
    public static void showToast(Context context, int value, boolean isLong) {
        showToast(context, String.valueOf(value), isLong);
    }

    /**
     * @param context
     * @param value
     * @author：Frj 功能:显示Toast提示信息 使用方法：
     */
    public static void showToast(Context context, float value, boolean isLong) {
        showToast(context, String.valueOf(value), isLong);
    }

    /**
     * @param context
     * @param value
     * @author：Frj 功能:显示Toast提示信息 使用方法：
     */
    public static void showToast(Context context, double value, boolean isLong) {
        showToast(context, String.valueOf(value), isLong);
    }

    /**
     * @param context
     * @param value
     * @author：Frj 功能:显示Toast提示信息 使用方法：
     */
    public static void showToast(Context context, boolean value, boolean isLong) {
        showToast(context, String.valueOf(value), isLong);
    }


}
