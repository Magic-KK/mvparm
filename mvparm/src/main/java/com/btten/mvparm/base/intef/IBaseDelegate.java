package com.btten.mvparm.base.intef;

import android.support.annotation.NonNull;

/**
 * @name zk
 * @class name：persenter和activity绑定
 * @time 2018-08-21 下午 5:35
 */


public interface IBaseDelegate<V extends IBaseView, P extends IPresenter<V>>
{


    /**
     * 初始化presenter
     */
    @NonNull
    P createPresenter();

    /**
     * 获取presenter
     */
    @NonNull
    P getPresenter();


}
