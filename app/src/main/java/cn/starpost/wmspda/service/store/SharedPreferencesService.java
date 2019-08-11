package cn.starpost.wmspda.service.store;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.alibaba.fastjson.JSON;

import cn.starpost.wmspda.service.app.AppApplication;

/**
 * 采用键值对的方式保存数据的方法，常用于保存程序设置；<br>
 * 一些安全不敏感的小规模数据；<br>
 * 优点是采用键值对方便读取；<br>
 * 缺点是采用XML可视化保存，安全性不足；<br>
 */
public class SharedPreferencesService {

    private volatile static SharedPreferences applicationSp = null;

    public static SharedPreferences getDefaultSharePreferences() {
        if (applicationSp == null) {
            applicationSp = PreferenceManager.getDefaultSharedPreferences(AppApplication.getContext());
        }
        return applicationSp;
    }

    /**
     * 保存全局级别数据,key会使用对象的完整类名
     *
     * @param data 对象
     */
    public static void saveLevelApplicationData(Object data) throws Exception {
        try {
            if (data == null) {
                throw new IllegalArgumentException("The argument 'data' is null.");
            }
            SharedPreferences applicationSp = getDefaultSharePreferences();
            SharedPreferences.Editor edit = applicationSp.edit();
            edit.putString(data.getClass().getName(), JSON.toJSONString(data));
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * 获取全局级别数据
     *
     * @param clazz 保存时的对象类信息，获取数据时根据类信息获取完整类名
     */
    public static <T> T getLevelApplicationData(Class<T> clazz) {
        try {
            if (clazz == null) {
                throw new IllegalArgumentException("The argument 'clazz' is null.");
            }
            SharedPreferences applicationSp = getDefaultSharePreferences();
            SharedPreferences.Editor edit = applicationSp.edit();
            String dataString = applicationSp.getString(clazz.getName(), null);
            return JSON.parseObject(dataString, clazz);
        } catch (Exception e) {
            throw e;
        }
    }
}
