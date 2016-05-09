package com.example.avalo.mlexercise.api;


import com.example.avalo.mlexercise.BuildConfig;
import com.example.avalo.mlexercise.data.CardIssuersApiService;
import com.example.avalo.mlexercise.models.CardIssuer;
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

public class CardIssuersApiClient implements CardIssuersApiService {

        static CardIssuersApiClient mApiClient;
        CardIssuersRetrofitApiService mRetrofitApiService;

        public static CardIssuersApiClient getInstance() {
            if (mApiClient == null) {
                mApiClient = new CardIssuersApiClient();
            }

            return mApiClient;
        }

        private CardIssuersApiClient() {

            // Add the interceptor to OkHttpClient
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            PublicKeyInterceptor apiInterceptor = new PublicKeyInterceptor();
            builder.interceptors().add(apiInterceptor);

            if (BuildConfig.DEBUG) {
                addLoggingInterceptor(builder);
            }

            OkHttpClient client = builder.build();

            Gson gson = new GsonBuilder()
                    .registerTypeAdapter(CardIssuer.class, new CardIssuersDeserializer())
                    .create();

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(Constants.Api.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .client(client)
                    .build();

            mRetrofitApiService = retrofit.create(CardIssuersRetrofitApiService.class);
        }

        private static void addLoggingInterceptor(OkHttpClient.Builder client) {
            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

            client.interceptors().add(loggingInterceptor);
        }

    @Override
    public void fetchCardIssuers(String paymentMethodId, final CardIssuerApiCallback<List<CardIssuer>> callback) {

        mRetrofitApiService.fetchCardIssuers(paymentMethodId).enqueue(new Callback<List<CardIssuer>>() {
                @Override
                public void onResponse(Call<List<CardIssuer>> call, Response<List<CardIssuer>> response) {
                    callback.onLoaded(response.body());
                }

                @Override
                public void onFailure(Call<List<CardIssuer>> call, Throwable t) {
                    if (BuildConfig.DEBUG)
                        t.printStackTrace();

                    callback.onError(t);
                }
            });
        }
    }
