package com.btten.mvparm.base;


/**
 * @name zk
 * @class name：model的基类 业务具体处理，包括负责存储、检索、操纵数据等
 * @time 2018-08-21 下午 6:00
 */

public abstract class BaseModel<SubP> {
    protected SubP mPresenter;

    public BaseModel(SubP presenter) {
        this.mPresenter=presenter;
    }
}
