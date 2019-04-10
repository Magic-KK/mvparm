package com.btten.mvparm.http;


/**
 * @name zk
 * @class name：网络请求返回结果类 (需要根据不同公司后台定制)
 * @time 2018-08-23 上午 11:57
 */

public class ResponseBean {

    /**
     * 表示服务器请求是否成功 0表示失败 1表示成功 2表示未登录
     */
    private int code;

    /**
     * 请求信息
     */
    private String msg;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
