package com.example.administrator.volleydemo2.netutil;

import android.view.MotionEvent;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response.Listener;
import com.android.volley.Response.ErrorListener;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.administrator.volleydemo2.App;

import java.util.Map;

/**
 * auther：wzy
 * date：2016/11/20 00 :10
 * desc:
 */

public class VolleyUtil {
    private static VolleyUtil mVolleyUtil;

    //实现单例
    public static VolleyUtil newVolleyUtilInstance() {
        if (mVolleyUtil == null) {
            synchronized (VolleyUtil.class) {
                if (mVolleyUtil == null) {
                    mVolleyUtil = new VolleyUtil();
                }
            }
        }
        return mVolleyUtil;
    }

    private static RequestQueue mRequestQueue;
    //默认方式GET
    private int mDefaultMethod = Request.Method.GET;

    private VolleyUtil() {
        getRequestQueue();
    }

    public RequestQueue getRequestQueue() {
        if (mRequestQueue == null) {
            synchronized (VolleyUtil.class) {
                if (mRequestQueue == null) {
                    mRequestQueue =
                            Volley.newRequestQueue(App.getGlobalContext());
                }
            }
        }
        return mRequestQueue;
    }

    private String mUrl;

    /**
     * 执行Get请求
     *
     * @param url
     * @return
     */
    public VolleyUtil doGet(String url) {
        this.mUrl = url;
        this.mDefaultMethod = Request.Method.GET;
        return this;
    }

    /**
     * String型数据返回值的监听
     */
    private Listener<String> mSucessStringListener;
    private ErrorListener mErrorListener;

    public VolleyUtil setSucessListener(Listener mSucessListener) {
        this.mSucessStringListener = mSucessListener;
        return this;
    }

    public VolleyUtil setErrorListener(ErrorListener mErrorListener) {
        this.mErrorListener = mErrorListener;
        return this;
    }

    /**
     * 执行Post请求
     *
     * @param url
     * @param parameter
     * @return
     */
    public VolleyUtil doPost(String url, final Map<String, String> parameter) {
        StringRequest request = new StringRequest(Request.Method.POST, url, mSucessStringListener, mErrorListener) {
            @Override
            protected Map<String, String> getParams() {
                return parameter;
            }
        };
        mRequestQueue.add(request);
        return this;
    }

    private static final int STRING_TYPE = 1;
    private static final int JSON_TYPE = 2;
    /**
     * 响应返回的数据类型
     */
    private int responseType = STRING_TYPE;

    public void start() {
        Request request = null;
        switch (responseType) {
            case STRING_TYPE:
                request = new StringRequest(mDefaultMethod, mUrl, mSucessStringListener, mErrorListener);
                break;
            case JSON_TYPE:
                //TODO 加入JsonRequest解析 业务定制用Gson
                break;
        }
        mRequestQueue.add(request);
        mRequestQueue.start();
    }

    public void stop() {
        mRequestQueue.stop();
    }
}
