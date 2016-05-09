package com.example.avalo.mlexercise.api;

import com.example.avalo.mlexercise.models.PaymentMethod;
import com.example.avalo.mlexercise.utils.Constants;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PaymentMethodRetrofitApiService {
    @GET(Constants.Api.URI_PAYMENT_METHOD)
    Call<List<PaymentMethod>> fetchPaymentMethod();

}
