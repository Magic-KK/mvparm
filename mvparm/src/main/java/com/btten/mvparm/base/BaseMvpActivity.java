package com.btten.mvparm.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.btten.mvparm.base.intef.IBaseDelegate;
import com.btten.mvparm.base.intef.IBaseView;
import com.btten.mvparm.base.intef.IPresenter;
import com.btten.mvparm.util.mvp.PresenterDispatch;
import com.btten.mvparm.util.mvp.PresenterProviders;
import com.noober.background.BackgroundLibrary;

/**
 * 采用注解的方式实现依赖注入，减少耦合
 * 本mvp框架可以可以无缝切换mvp mvc，如果无需用到mvp 用mvc即可
 * <p>
 * 本mvp框架 可以实现一个activity，fragment 多个P层和实现view层接口，一个p层对应多个model层，类似金字塔结构，这样代码复用性会更高
 *
 * @name zk
 * @class name：activity mvp 基类
 * @time 2018-08-21 下午 3:35
 */
public abstract class BaseMvpActivity<P extends BasePresenter> extends BaseActivity implements IBaseView {
    private PresenterProviders mPresenterProviders;
    private PresenterDispatch mPresenterDispatch;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        mPresenterProviders=PresenterProviders.inject(this);
        mPresenterDispatch=new PresenterDispatch(mPresenterProviders);
        mPresenterDispatch.attachView(this, this);
        mPresenterDispatch.onCreatePresenter(savedInstanceState);
        super.onCreate(savedInstanceState);

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mPresenterDispatch.onSaveInstanceState(outState);
    }


    /**
     * 加载时可以调用
     */
    @Override
    public void showLoading() {

    }

    /**
     * 关闭是可以调用
     */
    @Override
    public void dismiss() {

    }

    @Override
    public void loadEmpty(int type, String content) {

    }

    /**
     * 单个p层时可以调用获取p层对象
     *
     * @return
     */
    protected P getPresenter() {
        return mPresenterProviders.getPresenter(0);
    }

    public PresenterProviders getPresenterProviders() {
        return mPresenterProviders;
    }


    @Override
    protected String[] getPermissionArrays() {
        return new String[0];
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        //释放接口，防止内存泄露
        if (null != mPresenterDispatch)
            mPresenterDispatch.detachView();
    }
}
