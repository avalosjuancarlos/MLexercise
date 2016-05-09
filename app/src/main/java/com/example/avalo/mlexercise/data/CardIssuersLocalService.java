package com.example.avalo.mlexercise.data;

import com.example.avalo.mlexercise.models.CardIssuer;

import java.util.List;

public interface CardIssuersLocalService {
    interface CardIssuerLocalCallback<T> {
        void onLoaded(T cardIssuers);

        void onError(Throwable t);
    }

    void getCardIssuersSaved(String paymentMethodId, CardIssuerLocalCallback<List<CardIssuer>> callback);
}
