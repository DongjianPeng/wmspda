package cn.starpost.wmspda.util.http;

import android.util.Log;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;


public class HTTPUtil {

    private static final String TAG = "HTTPUtil";
    public static final MediaType MEDIA_TYPE_JSON
            = MediaType.get("application/json; charset=utf-8");

    private static final OkHttpClient client = new OkHttpClient.Builder()
            .callTimeout(60, TimeUnit.SECONDS)
            .connectTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .cookieJar(new CookieJar() {
                private final Map<String, List<Cookie>> cookiesMap = new ConcurrentHashMap<>();

                @Override
                public void saveFromResponse(@NotNull HttpUrl httpUrl, @NotNull List<Cookie> list) {
                    String host = httpUrl.host();
                    Log.d(TAG, "saveFromResponse: httpUrl.host()" + host);
                    Log.d(TAG, "saveFromResponse: list" + list.size());

                    if (list != null && !list.isEmpty()) {
                        if (cookiesMap.containsKey(host)) {
                            //替换
                        } else {
                            List<Cookie> cookies = new ArrayList<>();
                            cookies.addAll(list);
                            cookiesMap.put(host, cookies);
                        }
                    }

                    if (!list.isEmpty()) {
                        for (Cookie cookie : list) {
                            Log.d(TAG, "cookie.name()" + cookie.name() + "cookie.value()" + cookie.value());
                        }
                    }
                }

                @NotNull
                @Override
                public List<Cookie> loadForRequest(@NotNull HttpUrl httpUrl) {
                    String host = httpUrl.host();
                    Log.d(TAG, "loadForRequest: httpUrl.host()" + host);
                    if (cookiesMap.containsKey(host)) {
                        return cookiesMap.get(host);
                    } else {
                        return new ArrayList<>();
                    }
                }
            })
            .build();

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

    public String doGet(String url, String params) {

        final Request request = new Request.Builder()
                .url(url)
                .addHeader("SID", "XXX")
                .get()
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
                Log.d(TAG, "code:" + code + ";response: " + responseStr);
                listener.httpCallBack(new HttpResponse(code, responseStr));
            } catch (IOException e) {
                Log.e(TAG, "run: ", e);
            }
        }
    }


}
