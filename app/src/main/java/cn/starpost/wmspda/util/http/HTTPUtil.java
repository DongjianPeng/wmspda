package cn.starpost.wmspda.util.http;

import android.util.Log;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;


public class HTTPUtil {

    public static final MediaType MEDIA_TYPE_JSON
            = MediaType.get("application/json; charset=utf-8");

    private static final OkHttpClient client = new OkHttpClient();

    static {
        //配置OKHttpClient参数

    }

    private final HttpCallBackListener listener;

    /**
     * 必须实现异步网络请求回调
     *
     * @param listener
     */
    public HTTPUtil(HttpCallBackListener listener) {
        this.listener = listener;
    }

    public String doPost(String url, Object params) {


        RequestBody body = RequestBody.create("{\"value\":\"wwd\"}", MEDIA_TYPE_JSON);

        final Request request = new Request.Builder()
                .url(url)
                .addHeader("SID", "XXX")
                .post(body)
                .build();

        Log.d("TAG", "run2: " + Thread.currentThread().getId());
        new HttpTaskExecutor(listener, client, request).start();

        return null;
    }

    class HttpTaskExecutor extends Thread {
        private static final String TAG = "HttpTaskExecutor";

        private final HttpCallBackListener listener;
        private final OkHttpClient client;
        private final Request request;

        public HttpTaskExecutor(HttpCallBackListener listener, OkHttpClient client, Request request) {
            this.listener = listener;
            this.client = client;
            this.request = request;
        }

        @Override
        public void run() {
            try {
                Response response = client.newCall(request).execute();
                int code = response.code();
                String responseStr = response.body().string();
                Log.d(TAG, "response: " + responseStr);
                listener.httpCallBack(new HttpResponse(code, responseStr));
            } catch (IOException e) {
                Log.e(TAG, "run: ", e);
            }
        }
    }


}
