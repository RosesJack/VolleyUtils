package com.example.administrator.volleydemo2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.administrator.volleydemo2.netutil.VolleyUtil;

import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

public class MainActivity extends AppCompatActivity {

    private String TAG = this.getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
     /*   StringRequest stringRequest = new StringRequest(Request.Method.GET, "http://www.baidu.com", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.i(TAG, "成功结果：" + response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
        requestQueue.start();*/


        /**
         * 测试  BlockingQueue<String> queue = new PriorityBlockingQueue();
         *//*
        BlockingQueue<String> queue = new PriorityBlockingQueue();
        try {
            change(queue);
            Iterator<String> iterator = queue.iterator();
            if (iterator.hasNext()) {
                String next = iterator.next();
                Log.i(TAG, "元素是:" + next);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void change(BlockingQueue<String> queue) throws InterruptedException {
        queue.put("gaibiangshi");
    }*/
        VolleyUtil.newVolleyUtilInstance()
                .doGet("http://www.baidu.com")
                .setSucessListener(new Response.Listener() {
                    @Override
                    public void onResponse(Object response) {
                        String result = (String) response;
                        Toast.makeText(MainActivity.this, result, Toast.LENGTH_SHORT).show();
                    }
                })
                .setErrorListener(new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                    }
                })
                .start();
    }
}
