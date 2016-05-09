package com.example.avalo.mlexercise.api;

import com.example.avalo.mlexercise.models.Installment;
import com.example.avalo.mlexercise.utils.Constants;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface InstallmentsRetrofitApiService {
    @GET(Constants.Api.URI_PAYMENT_METHOD_INSTALLMENTS)
    Call<List<Installment>> fetchInstallments(
            @Query(Constants.Api.PAYMENT_METHOD_ID) String paymentMethodId,
            @Query(Constants.Api.ISSUER_ID) String issuerId,
            @Query(Constants.Api.AMOUNT) Double amount);
}
