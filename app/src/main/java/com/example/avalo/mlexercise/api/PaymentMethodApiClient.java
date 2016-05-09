package com.example.avalo.mlexercise.api;

import com.example.avalo.mlexercise.BuildConfig;
import com.example.avalo.mlexercise.data.PaymentMethodApiService;
import com.example.avalo.mlexercise.models.PaymentMethod;
import com.example.avalo.mlexercise.utils.Constants;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PaymentMethodApiClient implements PaymentMethodApiService {

    static PaymentMethodApiClient mApiClient;
    PaymentMethodRetrofitApiService mRetrofitApiService;

    public static PaymentMethodApiClient getInstance() {
        if (mApiClient == null) {
            mApiClient = new PaymentMethodApiClient();
        }

        return mApiClient;
    }

    private PaymentMethodApiClient() {

        // Add the interceptor to OkHttpClient
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        PublicKeyInterceptor apiInterceptor = new PublicKeyInterceptor();
        builder.interceptors().add(apiInterceptor);

        if (BuildConfig.DEBUG) {
            addLoggingInterceptor(builder);
        }

        OkHttpClient client = builder.build();

        Gson gson = new GsonBuilder()
                .registerTypeAdapter(PaymentMethod.class, new PaymentMethodDeserializer())
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(client)
                .build();

        mRetrofitApiService = retrofit.create(PaymentMethodRetrofitApiService.class);
    }

    private static void addLoggingInterceptor(OkHttpClient.Builder client) {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        client.interceptors().add(loggingInterceptor);
    }

    @Override
    public void fetchPaymentMethods(final PaymentMethodApiCallback<List<PaymentMethod>> callback) {
        mRetrofitApiService.fetchPaymentMethod().enqueue(new Callback<List<PaymentMethod>>() {
            @Override
            public void onResponse(Call<List<PaymentMethod>> call, Response<List<PaymentMethod>> response) {
                callback.onLoaded(response.body());
            }

            @Override
            public void onFailure(Call<List<PaymentMethod>> call, Throwable t) {
                if (BuildConfig.DEBUG)
                    t.printStackTrace();

                callback.onError(t);
            }
        });
    }
}
