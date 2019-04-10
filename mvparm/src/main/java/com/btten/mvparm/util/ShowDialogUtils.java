package com.btten.mvparm.util;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Handler;
import android.view.WindowManager;

/**
 * @name zk
 * @class name：加载框加载
 * @time 2018-09-04 下午 5:03
 */


public class ShowDialogUtils {
    private static ShowDialogUtils mShowDialogUtils;
    private ProgressDialog progressDialog;

    public static ShowDialogUtils getInstance() {
        if (mShowDialogUtils == null) {
            synchronized (ShowDialogUtils.class) {
                mShowDialogUtils=new ShowDialogUtils();
            }
        }
        return mShowDialogUtils;
    }

    public void showProgressDialog(Context mContext, String text) {

        if (progressDialog == null) {
            progressDialog=new ProgressDialog(mContext);
            progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        }
        progressDialog.setMessage(text);    //设置内容
        progressDialog.setCancelable(false);//点击屏幕和按返回键都不能取消加载框
        progressDialog.show();
    }

    public void dismiss() {
        if (progressDialog != null) {
            progressDialog.dismiss();
            progressDialog=null;
        }
    }
}
