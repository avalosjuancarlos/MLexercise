package com.example.avalo.mlexercise.api;

import com.example.avalo.mlexercise.BuildConfig;
import com.example.avalo.mlexercise.data.InstallmentsApiService;
import com.example.avalo.mlexercise.models.Installment;
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

public class InstallmentsApiClient implements InstallmentsApiService {

        static InstallmentsApiClient mApiClient;
    InstallmentsRetrofitApiService mRetrofitApiService;

        public static InstallmentsApiClient getInstance() {
            if (mApiClient == null) {
                mApiClient = new InstallmentsApiClient();
            }

            return mApiClient;
        }

        private InstallmentsApiClient() {

            // Add the interceptor to OkHttpClient
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            PublicKeyInterceptor apiInterceptor = new PublicKeyInterceptor();
            builder.interceptors().add(apiInterceptor);

            if (BuildConfig.DEBUG) {
                addLoggingInterceptor(builder);
            }

            OkHttpClient client = builder.build();

            Gson gson = new GsonBuilder()
                    .registerTypeAdapter(Installment.class, new InstallmentsDeserializer())
                    .create();

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(Constants.Api.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .client(client)
                    .build();

            mRetrofitApiService = retrofit.create(InstallmentsRetrofitApiService.class);
        }

        private static void addLoggingInterceptor(OkHttpClient.Builder client) {
            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

            client.interceptors().add(loggingInterceptor);
        }

        @Override
        public void fetchInstallments(String paymentMethodId, String issuerId, Double amount, final InstallmentsApiService.InstallmentsApiCallback<List<Installment>> callback) {

            mRetrofitApiService.fetchInstallments(paymentMethodId, issuerId, amount).enqueue(new Callback<List<Installment>>() {
                @Override
                public void onResponse(Call<List<Installment>> call, Response<List<Installment>> response) {
                    callback.onLoaded(response.body());
                }

                @Override
                public void onFailure(Call<List<Installment>> call, Throwable t) {
                    if (BuildConfig.DEBUG)
                        t.printStackTrace();

                    callback.onError(t);
                }
            });
        }
    }

