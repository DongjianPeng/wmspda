package cn.starpost.wmspda.service.api;

import cn.starpost.wmspda.util.http.HTTPUtil;
import cn.starpost.wmspda.util.http.HttpCallBackListener;

/**
 * 访问Wms系统的Url配置类
 */
public class WmsApiClient {
    private static final String TAG = "WmsApiClient";

    public static void checkLogin(HttpCallBackListener listener) {
        try {
            HTTPUtil httpUtil = new HTTPUtil(listener);



        } catch (Exception e) {


        }

    }
}
