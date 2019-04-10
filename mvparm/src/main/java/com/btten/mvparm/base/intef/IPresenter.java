package com.btten.mvparm.base.intef;


import android.view.View;

/**
 * @name zk
 * @class name：定义Presenter 接口
 * @time 2018-08-21 下午 4:16
 */
public interface IPresenter<V extends IBaseView> {
    /**
     * 绑定接口
     *
     * @param view
     */
    void attach(V view);

    /**
     * 释放接口
     * <p>
     * 如果不释放接口，可能会导致内存泄露风险
     */
    void detach();

}
