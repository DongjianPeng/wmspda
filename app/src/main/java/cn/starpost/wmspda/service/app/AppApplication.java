package cn.starpost.wmspda.service.app;

import android.app.Application;
import android.content.Context;

import cn.starpost.wmspda.value.profile.UserContext;

/**
 * 为保存全局变量设定的基本类，可在此暴露全局共同访问的context</br>
 * 注意1：此context与当前活动的context并不是同一个context实例；
 * 注意2：调试时如需要重新加载此context需要重新install，不能使用apply changes热加载
 */
public class AppApplication extends Application {
    private static Context context;
    private static UserContext userContext;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }

    public static Context getContext() {
        return context;
    }

    public static UserContext getUserContext() {
        return userContext;
    }
}
