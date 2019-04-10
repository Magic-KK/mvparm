package com.btten.mvparm.http.interf;

import com.lzy.okgo.model.Response;

/**
 * @name zk
 * @class name：网络请求结果回调
 * @time 2018-08-23 上午 11:19
 */
public interface ICallBackData<T> {

    /**
     * 网络请求成功回调
     *
     * @param body
     */
    void onSuccess(T body);


    /**
     * 请求错误回调
     *
     * @param err
     */
    void onError(String err);


}
