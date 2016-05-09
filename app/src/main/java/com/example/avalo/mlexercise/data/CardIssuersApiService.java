package com.example.avalo.mlexercise.data;

import com.example.avalo.mlexercise.models.CardIssuer;

import java.util.List;

public interface CardIssuersApiService {

    interface CardIssuerApiCallback<T> {
        void onLoaded(T cardIssuers);

        void onError(Throwable t);
    }

    void fetchCardIssuers(String paymentMethodId, CardIssuerApiCallback<List<CardIssuer>> callback);
}

