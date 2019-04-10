package com.btten.mvparm.base;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.btten.mvparm.R;

import org.greenrobot.eventbus.EventBus;

import java.util.Objects;

import me.yokeyword.fragmentation.ExtraTransaction;
import me.yokeyword.fragmentation.ISupportFragment;
import me.yokeyword.fragmentation.SupportFragment;
import me.yokeyword.fragmentation.SupportFragmentDelegate;
import me.yokeyword.fragmentation.SupportHelper;
import me.yokeyword.fragmentation.anim.FragmentAnimator;

/**
 * @name zk
 * @class name：BaseFragment 抽象类
 * @time 2018-08-29 上午 10:59
 */

public abstract class BaseFragment extends SupportFragment implements View.OnClickListener {
    private View mView;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        init(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return mView = inflater.inflate(getContentView(), container, false);
    }

    public View getView() {
        return mView;
    }

    /**
     * 初始化相关
     */
    private void init(@Nullable Bundle savedInstanceState) {
        initView();
        initListener();
        initData();
    }

    /**
     * 通过资源Id查找控件
     *
     * @param id
     * @param <T> 返回继承至View的对象
     * @return
     */
    protected <T extends View> T findView(int id) {
        return (T) getView().findViewById(id);
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
     * 置顶布局资源
     *
     * @return 布局资源
     */
    protected abstract int getContentView();

    @Override
    public void onClick(View v) {

    }

    /*******************************************
     *
     * 以下所有方法为ISupportFragment中需要实现或者可选实现的方法
     *
     *******************************************/
    public void jump(Class<?> clazz, Bundle bundle, boolean isFinish) {
        Intent intent = new Intent(getActivity(), clazz);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
        if (isFinish) {
            Objects.requireNonNull(getActivity()).finish();
        }
    }

    public void jump(Class<?> clazz, Bundle bundle, boolean isFinish, int requestCode) {
        Intent intent = new Intent(getActivity(), clazz);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivityForResult(intent, requestCode);
        if (isFinish) {
            Objects.requireNonNull(getActivity()).finish();
        }
    }

    protected void jump(Class<?> clazz, Activity activity) {
        Intent intent = new Intent(activity, clazz);
        startActivity(intent);
        activity.overridePendingTransition(R.anim.right_in_anim,
                R.anim.left_out_anim);
    }

    protected void jump(Class<?> clazz, Bundle bundle, Activity activity) {
        Intent intent = new Intent(activity, clazz);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
        activity.overridePendingTransition(R.anim.right_in_anim,
                R.anim.left_out_anim);
    }

    /**
     * 加载fragment
     *
     * @param toFragment
     */
    public void startFr(ISupportFragment toFragment) {
        extraTransaction().setCustomAnimations(R.anim.start_fragment_enter, 0, 0, 0).start(toFragment);
    }
}
