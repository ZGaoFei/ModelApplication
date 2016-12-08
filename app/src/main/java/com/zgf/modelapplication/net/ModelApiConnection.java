package com.zgf.modelapplication.net;


import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ModelApiConnection {
    private final String basePath = "http://testcli.nggirl.com.cn/";
    private static final String url = "http://sns.maimaicha.com/";
    private ApiService apiService;

    /*public ModelApiConnection() {
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(5, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        return chain.proceed(chain.request());
                    }
                })
                .build();

        // 没有添加rxjava
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(basePath)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

        // 添加rxjava
        *//*Retrofit retrofit = new Retrofit
                .Builder()
                .baseUrl(basePath)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(client)
                .build();*//*

        apiService = retrofit.create(ApiService.class);
    }*/

    /*public ApiService getApiService() {
        return apiService;
    }*/

    public static ApiService getClient() {
        ApiService apiService;

        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(5, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        return chain.proceed(chain.request());
                    }
                })
                .build();

        // 没有添加rxjava
        /*Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();*/

        // 添加rxjava
        Retrofit retrofit = new Retrofit
                .Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(client)
                .build();

        apiService = retrofit.create(ApiService.class);
        return apiService;
    }
}
