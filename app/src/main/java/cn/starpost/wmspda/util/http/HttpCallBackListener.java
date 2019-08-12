package cn.starpost.wmspda.util.http;

/**
 * 异步网络请求回调方法
 */
public interface HttpCallBackListener {
    void httpCallBack(HttpResponse response);
}
