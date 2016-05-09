package com.example.avalo.mlexercise.data;

import com.example.avalo.mlexercise.models.CardIssuer;

import java.util.List;

public class CardIssuersRepositoryImpl implements CardIssuersRepository {

        CardIssuersApiService mApiService;
        CardIssuersLocalService mLocalService;

        public CardIssuersRepositoryImpl(CardIssuersApiService apiService, CardIssuersLocalService localService) {
            mApiService = apiService;
            mLocalService = localService;

        }


    @Override
    public void fetchCardIssuers(final String paymentMethodId, final FetchCardIssuersCallback callback) {

        mApiService.fetchCardIssuers(paymentMethodId, new CardIssuersApiService.CardIssuerApiCallback<List<CardIssuer>>() {
            @Override
            public void onLoaded(List<CardIssuer> cardIssuers) {
                callback.onSuccess(cardIssuers);
            }

            @Override
            public void onError(Throwable t) {
                mLocalService.getCardIssuersSaved(paymentMethodId, new CardIssuersLocalService.CardIssuerLocalCallback<List<CardIssuer>>() {
                    @Override
                    public void onLoaded(List<CardIssuer> cardIssuers) {
                        callback.onSuccess(cardIssuers);
                    }

                    @Override
                    public void onError(Throwable t) {
                        callback.onError(t);
                    }
                });
            }
        });
    }
}
