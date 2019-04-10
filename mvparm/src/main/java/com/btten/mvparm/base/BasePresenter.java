package com.btten.mvparm.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.btten.mvparm.util.ShowToast;

/**
 * @name zk
 * @class name：presenter抽象类
 * @time 2018-08-24 上午 11:39
 */
public abstract class BasePresenter<V> {

    /**
     * 上下文对象
     */
    protected Context mContext;
    /**
     * view层引用
     */
    protected V mView;

    /**
     * 强制绑定model
     */
    public abstract void ModelBinding();


    public void onCleared() {

    }


    /**
     * view 绑定
     *
     * @param context 上下文
     * @param view    v层
     */
    public void attachView(Context context, V view) {
        this.mContext=context;
        this.mView=view;
        ModelBinding();
    }

    /**
     * view层销毁
     */
    public void detachView() {
        this.mView=null;
    }

    /**
     * 判断view层是否为null
     *
     * @return
     */
    public boolean isAttachView() {
        return this.mView != null;
    }

    /**
     * 创建p层
     *
     * @param savedState
     */
    public void onCreatePresenter(@Nullable Bundle savedState) {

    }

    /**
     * 销毁p层
     */
    public void onDestroyPresenter() {
        this.mContext=null;
        detachView();
    }

    public void onSaveInstanceState(Bundle outState) {

    }
}

