package com.example.avalo.mlexercise.api;

import com.example.avalo.mlexercise.data.CardIssuersLocalService;
import com.example.avalo.mlexercise.models.CardIssuer;

import java.io.IOException;
import java.util.List;

public class CardIssuersLocalServiceImpl implements CardIssuersLocalService {
    static CardIssuersLocalServiceImpl mInstance;

    public static CardIssuersLocalServiceImpl getInstance() {
        if (mInstance == null)
            mInstance = new CardIssuersLocalServiceImpl();

        return mInstance;
    }

    @Override
    public void getCardIssuersSaved(String paymentMethodId, CardIssuerLocalCallback<List<CardIssuer>> callback) {
        //TODO: Query to DB
        callback.onError(new IOException());
    }
}
