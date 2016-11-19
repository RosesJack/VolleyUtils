package com.example.administrator.volleydemo2.netutil;

import com.android.volley.Cache;
import com.android.volley.Network;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.ResponseDelivery;

/**
 * auther：wzy
 * date：2016/11/20 00 :18
 * desc:
 */

public class MRequestQueue extends RequestQueue {
    public MRequestQueue(Cache cache, Network network, int threadPoolSize, ResponseDelivery delivery) {
        super(cache, network, threadPoolSize, delivery);
    }

    public MRequestQueue(Cache cache, Network network, int threadPoolSize) {
        super(cache, network, threadPoolSize);
    }

    public MRequestQueue(Cache cache, Network network) {
        super(cache, network);
    }

    @Override
    public <T> Request<T> add(Request<T> request) {
        return super.add(request);
    }
}
