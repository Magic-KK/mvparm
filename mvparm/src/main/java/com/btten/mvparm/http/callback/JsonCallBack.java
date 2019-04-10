package com.btten.mvparm.http.callback;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.lzy.okgo.callback.AbsCallback;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import okhttp3.Response;
import okhttp3.ResponseBody;


/**
 * @name zk
 * @class name：处理json数据结构
 * @time 2018-08-23 上午 10:10
 */

public abstract class JsonCallBack<T> extends AbsCallback<T> {

    private Class<T> tClass;


    public JsonCallBack(Class<T> tClass) {
        this.tClass=tClass;
    }

//    public JsonCallBack() {
////
////    }


    @Override
    public T convertResponse(Response response) {
        ResponseBody body=response.body();
        if (body == null) {
            return null;
        }

        T data;
        Gson gson=new Gson();
        JsonReader jsonReader=new JsonReader(body.charStream());
        if (tClass != null) {
            data=gson.fromJson(jsonReader, tClass);
        } else {
            Type genType=getClass().getGenericSuperclass();
            Type type=((ParameterizedType) genType).getActualTypeArguments()[0];
            data=gson.fromJson(jsonReader, type);
        }
        return data;
    }
}
