package com.btten.mvparm.base;

import android.app.Activity;
import android.app.Application;

import com.blankj.utilcode.util.BarUtils;
import com.blankj.utilcode.util.SPUtils;
import com.btten.mvparm.http.HttpConfig;

import java.lang.ref.WeakReference;
import java.util.Stack;

/**
 * @name zk
 * @class name：Application 抽象类，初始化程序相关
 * @time 2018-08-29 上午 10:59
 */

public abstract class MvpApplication extends Application {


    private static MvpApplication MvpApplication; // 单例模式
    private Stack<WeakReference<Activity>> activities; // Activity栈集合

    @Override
    public void onCreate() {
        super.onCreate();
        MvpApplication=this;
        activities=new Stack<>();
        initConfig();
    }

    /**
     * 获取application实例
     *
     * @return
     */
    public static MvpApplication getApplication() {
        return MvpApplication;
    }

    /**
     * 添加Activity
     *
     * @param activity activity对象
     */
    public void addActivity(Activity activity) {
        if (activity != null) {
            activities.add(new WeakReference<>(activity));
        }
    }

    /**
     * 初始化配置相关
     */
    private void initConfig() {
        //初始化网络配置相关
        HttpConfig.init(this);
    }

    /**
     * 退出程序
     */
    public void exit() {
        for (int i=0; i < activities.size(); i++) {
            if (activities.get(i) != null && activities.get(i).get() != null) {
                activities.get(i).get().finish();
            }
        }
        System.exit(0);
    }


}
