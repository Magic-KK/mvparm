package com.btten.mvparm.base.intef;


/**
 * @name zk
 * @class name：抽象出来 UI界面接口
 * @time 2018-08-21 下午 5:09
 */

public interface IBaseView {
    /**
     * 显示加载
     */
    void showLoading();

    /**
     * 完成加载
     */
    void dismiss();


    /**
     * 加载挡板
     *
     * @param type    加载类型
     * @param content 加载文本
     */
    void loadEmpty(int type, String content);


}
