package com.kisanhubassignmentapp.api;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiServiceGenerator {
    public static String BASE_URL = "http://s3.eu-west-2.amazonaws.com/interview-question-data/";

    private static int REQUEST_TIMEOUT = 0;
    private static OkHttpClient.Builder httpClient = new OkHttpClient.Builder()
            //.connectTimeout(REQUEST_TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(REQUEST_TIMEOUT, TimeUnit.SECONDS)
            .writeTimeout(REQUEST_TIMEOUT, TimeUnit.SECONDS);
    static Gson gson = new GsonBuilder()
            .setLenient()
            .create();
    private static Retrofit.Builder builder =
            new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create(gson));
    private static Retrofit retrofit = builder.build();

//    public static <S> S createService(Class<S> serviceClass) {
//        return createService(serviceClass, null);
//    }
//
//    public static <S> S createService(
//            Class<S> serviceClass, String clientId, String clientSecret) {
//        if (!TextUtils.isEmpty(clientId)
//                && !TextUtils.isEmpty(clientSecret)) {
//            String authToken = Credentials.basic(clientId, clientSecret);
//            return createService(serviceClass, authToken);
//        }
//
//        return createService(serviceClass, null, null);
//    }

    private static HttpLoggingInterceptor logging =
            new HttpLoggingInterceptor()
                    .setLevel(HttpLoggingInterceptor.Level.BODY);

    public static <S> S createService(
            Class<S> serviceClass, Context context) {


        if (!httpClient.interceptors().contains(logging)) {
            httpClient.addInterceptor(logging);
            builder.client(httpClient.build());
            retrofit = builder.build();
        }

        return retrofit.create(serviceClass);
    }

    public static void changeApiBaseUrl() {


        builder = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson));
        httpClient =
                new OkHttpClient.Builder();
    }

    public static Retrofit getRetrofit() {
        return retrofit;
    }

}
