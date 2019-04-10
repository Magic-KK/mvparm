package com.btten.mvparm.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.btten.mvparm.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.target.ViewTarget;
import com.bumptech.glide.request.transition.Transition;

import java.io.File;

import static com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade;


public class GlideUtils {

    /**
     * 获取当前默认的配置
     *
     * @return
     */
    public static RequestOptions getDefaultOptions() {
        return new RequestOptions().centerCrop().placeholder(R.drawable.main_brand_place_holder).error(R.drawable.main_brand_place_holder);
    }

    /**
     * 加载图片
     *
     * @param context
     * @param url     http头地址
     * @param into    需要加载图片的View
     */
    public static void load(Context context, String url, ImageView into) {
        load(context, url, into, getDefaultOptions());

    }

    /**
     * 加载图片
     *
     * @param context
     * @param url     http头地址
     * @param into    需要加载图片的View
     */
    public static void load(Context context, String url, ImageView into, RequestOptions requestOptions) {
        Glide.with(context).load(url).apply(requestOptions).transition(withCrossFade()).into(into);
    }


    /**
     * 加载自定义 View 背景
     *
     * @param context
     * @param url
     * @param into
     */
    public static void loadView(Context context, final String url, final View into) {
        Glide.with(context).load(url).apply(getDefaultOptions()).transition(withCrossFade()).into(new SimpleTarget<Drawable>() {
            @Override
            public void onResourceReady(@NonNull Drawable resource, @Nullable Transition<? super Drawable> transition) {
                into.setBackground(resource);
            }
        });


    }


    /**
     * Fragment中的加载图片
     *
     * @param fragment
     * @param url      http头地址
     * @param into     需要加载的View
     */
    public static void load(Fragment fragment, String url, ImageView into) {
        load(fragment, url, into, getDefaultOptions());
    }

    /**
     * Fragment中的加载图片
     *
     * @param fragment
     * @param url      http头地址
     * @param into     需要加载的View
     */
    public static void load(Fragment fragment, String url, ImageView into, RequestOptions requestOptions) {
        Glide.with(fragment).load(url).apply(requestOptions).transition(withCrossFade()).into(into);
    }

    /**
     * 加载图片
     *
     * @param context
     * @param file    图片文件
     * @param into    需要加载图片的View
     */
    public static void load(Context context, File file, ImageView into) {
        load(context, file, into, getDefaultOptions());
    }

    /**
     * 加载图片
     *
     * @param context
     * @param file    图片文件
     * @param into    需要加载图片的View
     */
    public static void load(Context context, File file, ImageView into, RequestOptions requestOptions) {
        Glide.with(context).load(file).apply(requestOptions).transition(withCrossFade()).into(into);
    }

    /**
     * Fragment中的加载图片
     *
     * @param fragment
     * @param file     图片文件
     * @param into     需要加载图片的View
     */
    public static void load(Fragment fragment, File file, ImageView into) {
        load(fragment, file, into, getDefaultOptions());
    }

    /**
     * Fragment中的加载图片
     *
     * @param fragment
     * @param file     图片文件
     * @param into     需要加载图片的View
     */
    public static void load(Fragment fragment, File file, ImageView into, RequestOptions requestOptions) {
        Glide.with(fragment).load(file).apply(requestOptions).transition(withCrossFade()).into(into);
    }

    /**
     * 加载图片
     *
     * @param context
     * @param uri     Uri地址
     * @param into    需要加载图片的View
     */
    public static void load(Context context, Uri uri, ImageView into) {
        load(context, uri, into, getDefaultOptions());
    }

    /**
     * 加载图片
     *
     * @param context
     * @param uri     Uri地址
     * @param into    需要加载图片的View
     */
    public static void load(Context context, Uri uri, ImageView into, RequestOptions requestOptions) {
        Glide.with(context).load(uri).apply(requestOptions).transition(withCrossFade()).into(into);
    }

    /**
     * Fragment中的加载图片
     *
     * @param fragment
     * @param uri      Uri地址
     * @param into     需要加载图片的View
     */
    public static void load(Fragment fragment, Uri uri, ImageView into) {
        load(fragment, uri, into, getDefaultOptions());
    }

    /**
     * Fragment中的加载图片
     *
     * @param fragment
     * @param uri      Uri地址
     * @param into     需要加载图片的View
     */
    public static void load(Fragment fragment, Uri uri, ImageView into, RequestOptions requestOptions) {
        Glide.with(fragment).load(uri).apply(requestOptions).transition(withCrossFade()).into(into);
    }

    public static void load(Context context, int resId, ImageView imageView) {
        Glide.with(context).load(resId).apply(getDefaultOptions()).into(imageView);
    }

    public static void load(Context context, String url, int width, int height, final ImageView imageView) {
        Glide.with(context).load(url).apply(getDefaultOptions()).into(new SimpleTarget<Drawable>(width, height) {
            @Override
            public void onResourceReady(@NonNull Drawable resource, @Nullable Transition<? super Drawable> transition) {
                imageView.setImageDrawable(resource);
            }
        });
    }

    public static void load(Context context, Uri uri, int width, int height, final ImageView imageView) {
        Glide.with(context).load(uri).apply(getDefaultOptions()).into(new SimpleTarget<Drawable>(width, height) {
            @Override
            public void onResourceReady(@NonNull Drawable resource, @Nullable Transition<? super Drawable> transition) {
                imageView.setImageDrawable(resource);
            }
        });
    }
}
