package com.example.avalo.mlexercise.data;

import com.example.avalo.mlexercise.models.CardIssuer;

import java.util.List;

public interface CardIssuersRepository {

    interface FetchCardIssuersCallback {
        void onSuccess(List<CardIssuer> cardIssuers);

        void onError(Throwable t);
    }

    void fetchCardIssuers(String paymentMethodId, FetchCardIssuersCallback callback);
}
