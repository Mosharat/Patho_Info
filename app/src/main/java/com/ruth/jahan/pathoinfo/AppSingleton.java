package com.ruth.jahan.pathoinfo;

import android.content.Context;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class AppSingleton {
    private static AppSingleton mAppSingleton1Instance;
        private RequestQueue mRequestQueue;
        private static Context mContext;

        private AppSingleton(Context context) {
            mContext = context;
            mRequestQueue = getRequestQueue();
        }

        public static synchronized AppSingleton getInstance(Context context) {
            if (mAppSingleton1Instance == null) {
                mAppSingleton1Instance = new AppSingleton(context);
            }
            return mAppSingleton1Instance;
        }

        public RequestQueue getRequestQueue() {
            if (mRequestQueue == null) {
                mRequestQueue = Volley.newRequestQueue(mContext.getApplicationContext());
            }
            return mRequestQueue;
        }

        public <T> void addToRequestQueue(Request<T> req, String tag) {
            req.setTag(tag);
            getRequestQueue().add(req);
        }

        public void cancelPendingRequests(Object tag) {
            if (mRequestQueue != null) {
                mRequestQueue.cancelAll(tag);
            }
        }
}