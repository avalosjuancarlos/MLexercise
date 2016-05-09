package com.example.avalo.mlexercise.api;

import com.example.avalo.mlexercise.models.CardIssuer;
import com.example.avalo.mlexercise.utils.Constants;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface CardIssuersRetrofitApiService {
    @GET(Constants.Api.URI_PAYMENT_METHOD_CARD_ISSUERS)
    Call<List<CardIssuer>> fetchCardIssuers(@Query(Constants.Api.PAYMENT_METHOD_ID) String paymentMethodId);

}
