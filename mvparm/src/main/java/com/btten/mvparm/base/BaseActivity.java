package com.btten.mvparm.base;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import com.blankj.utilcode.util.ActivityUtils;
import com.blankj.utilcode.util.BarUtils;
import com.blankj.utilcode.util.PermissionUtils;
import com.btten.mvparm.R;
import com.btten.mvparm.util.ShowToast;
import com.noober.background.BackgroundLibrary;

import me.yokeyword.fragmentation.ExtraTransaction;
import me.yokeyword.fragmentation.ISupportActivity;
import me.yokeyword.fragmentation.ISupportFragment;
import me.yokeyword.fragmentation.SupportActivity;
import me.yokeyword.fragmentation.SupportActivityDelegate;
import me.yokeyword.fragmentation.SupportFragment;
import me.yokeyword.fragmentation.SupportHelper;
import me.yokeyword.fragmentation.anim.FragmentAnimator;

/**
 * 再次抽象一层activity,这里主要封装一些简单的常用功能
 *
 * @name zk
 * @class name：activity 抽象类
 * @time 2018-08-21 下午 4:25
 */
public abstract class BaseActivity extends SupportActivity implements View.OnClickListener {

    final SupportActivityDelegate mDelegate=new SupportActivityDelegate(this);
    /**
     * 界面传整形值中，key的值
     */
    public static final String KEY="activity_num";

    /**
     * 界面传字符串类型的值时，key的值
     */
    protected static final String KEY_STR="activity_str";

    /**
     * 是否开启沉浸式 默认开启
     */
    private boolean isImmersive=true;

    private long prevClickTime=0;

    /**
     * 是否开启沉浸式
     */
    protected void isImmersive(boolean isImmersive) {
        this.isImmersive=isImmersive;
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        BackgroundLibrary.inject(this);
        super.onCreate(savedInstanceState);
        //将activity 添加到栈中
        MvpApplication.getApplication().addActivity(this);
        mDelegate.onCreate(savedInstanceState);
        doPermissionCheck();
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDelegate.onPostCreate(savedInstanceState);
    }

    @Override
    protected void onDestroy() {
        mDelegate.onDestroy();
        super.onDestroy();
    }

    /**
     * Note： return mDelegate.dispatchTouchEvent(ev) || super.dispatchTouchEvent(ev);
     */
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return mDelegate.dispatchTouchEvent(ev) || super.dispatchTouchEvent(ev);
    }

    /**
     * 设置沉浸式
     *
     * @param isImmersive
     */
    private void initImmersive(boolean isImmersive) {
        if (isImmersive) {
            //沉浸式开启
            BarUtils.setStatusBarAlpha(this, 0);
            BarUtils.setStatusBarLightMode(this, true);
        }
    }

    @Override
    public void onClick(View v) {
        long currentClickTime=System.currentTimeMillis();
        long diff=currentClickTime - prevClickTime;
        Log.d("DIFF_TIME", diff + "");

        if (0 < diff && diff < 1000) {
            //prevClickTime = SystemClock.currentThreadTimeMillis();
            return;
        }
        prevClickTime=System.currentTimeMillis();
    }

    /**
     * 初始化相关
     */
    private void init() {
        initView();
        initListener();
        initData();
    }

    /**
     * 初始化控件
     */
    protected abstract void initView();

    /**
     * 初始化监听
     */
    protected abstract void initListener();

    /**
     * 初始化数据获取
     */
    protected abstract void initData();

    /**
     * 设置布局文件
     *
     * @return
     */
    protected abstract int getContentView();

    /**
     * @param clazz    要跳转的类
     * @param isFinish 表示是否关闭当前的Activity true表示关闭当前的Activity
     * @param bundle   传输的参数
     * @author：Frj 功能:Activity跳转的方法 使用方法：
     */
    public void jump(Class<? extends Activity> clazz, Bundle bundle, boolean isFinish) {
        Intent intent=new Intent(this, clazz);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
        overridePendingTransition(R.anim.right_in_anim, R.anim.left_out_anim);
        if (isFinish) {
            this.finish();
        }
    }

    /**
     * @param clazz    要填转到的类
     * @param param    参数
     * @param isFinish 是否关闭当前Activity
     * @author：Frj 功能:传输一个String类型的参数，跳转到下一个Activity 使用方法：
     */
    public void jump(Class<? extends Activity> clazz, String param, boolean isFinish) {
        Bundle bundle=new Bundle();
        bundle.putString(KEY_STR, param);
        jump(clazz, bundle, isFinish);
        overridePendingTransition(R.anim.right_in_anim, R.anim.left_out_anim);
    }

    /**
     * @param clazz    要填转到的类
     * @param param    参数
     * @param isFinish 是否关闭当前Activity
     * @author：Frj 功能:传输一个整形的参数跳转到下一个Activity 使用方法：
     */
    public void jump(Class<? extends Activity> clazz, int param, boolean isFinish) {
        Bundle bundle=new Bundle();
        bundle.putInt(KEY, param);
        jump(clazz, bundle, isFinish);
        overridePendingTransition(R.anim.right_in_anim, R.anim.left_out_anim);
    }

    /**
     * @param clazz    要填转到的类
     * @param isFinish 是否关闭当前Activity
     * @author：Frj 功能:跳转界面，无参数传输 使用方法：
     */
    public void jump(Class<? extends Activity> clazz, boolean isFinish) {
        jump(clazz, "", isFinish);
        overridePendingTransition(R.anim.right_in_anim, R.anim.left_out_anim);
    }

    /**
     * @param clazz 要填转到的类
     * @param param 参数
     * @author：Frj 功能:传输一个String类型的参数，跳转到下一个Activity(不关闭当前的Activity) 使用方法：
     */
    public void jump(Class<? extends Activity> clazz, String param) {
        jump(clazz, param, false);
    }

    /**
     * @param paramClass 跳转到的页面
     * @author：Frj 功能:跳转Activity（不finish当前页） 使用方法：
     */
    public void jump(Class<? extends Activity> paramClass) {
        jump(paramClass, "", false);
        overridePendingTransition(R.anim.right_in_anim, R.anim.left_out_anim);
    }


    /****************************************以下为可选方法(Optional methods)******************************************************/


    protected abstract String[] getPermissionArrays();

    private void doPermissionCheck() {
        if (getPermissionArrays() == null || getPermissionArrays().length == 0) {
            initImmersive(isImmersive);
            setContentView(getContentView());
            init();
        } else {
            PermissionUtils.permission(getPermissionArrays()).callback(new PermissionUtils.SimpleCallback() {
                @Override
                public void onGranted() {
                    initImmersive(isImmersive);
                    setContentView(getContentView());
                    init();
                }

                @Override
                public void onDenied() {
                    ShowToast.showToast(getString(R.string.permission_refuse));
                    finish();
                }
            }).request();
        }
    }
}
