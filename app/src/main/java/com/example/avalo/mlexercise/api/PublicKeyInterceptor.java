package com.example.avalo.mlexercise.api;

import com.example.avalo.mlexercise.BuildConfig;
import com.example.avalo.mlexercise.utils.Constants;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class PublicKeyInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request original = chain.request();
        HttpUrl newUrl = original.url().newBuilder()
                .addQueryParameter(Constants.Api.PUBLIC_KEY, BuildConfig.MP_PUBLIC_KEY).build();

        Request request = original.newBuilder()
                .method(original.method(), original.body())
                .url(newUrl)
                .build();

        return chain.proceed(request);
    }
}

