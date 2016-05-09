package com.example.avalo.mlexercise.cardissuers;

import android.content.Intent;

import com.example.avalo.mlexercise.BuildConfig;
import com.example.avalo.mlexercise.data.CardIssuersRepository;
import com.example.avalo.mlexercise.installments.InstallmentsActivity;
import com.example.avalo.mlexercise.models.CardIssuer;
import com.example.avalo.mlexercise.utils.Constants;

import java.util.List;

public class CardIssuersPresenter implements CardIssuersContract.UserActionListener {

        private CardIssuersContract.View mView;
        private CardIssuersRepository mCardIssuersRepository;

        public CardIssuersPresenter(CardIssuersContract.View view, CardIssuersRepository cardIssuersRepository) {
            mView = view;
            this.mCardIssuersRepository = cardIssuersRepository;
        }

        @Override
        public void requestCardIssuers(String paymentMethodId) {
            mView.setProgressVisible(true);
            mCardIssuersRepository.fetchCardIssuers(paymentMethodId, new CardIssuersRepository.FetchCardIssuersCallback() {
                @Override
                public void onSuccess(List<CardIssuer> cardIssuers) {
                    mView.setProgressVisible(false);
                    mView.showCardIssuers(cardIssuers);
                }

                @Override
                public void onError(Throwable t) {
                    if (BuildConfig.DEBUG)
                        t.printStackTrace();

                    mView.setProgressVisible(false);
                    mView.showRequestError();
                }
            });
        }

        @Override
        public void CardIssuerDetail(CardIssuer item,  String paymentMethod, Double amount) {
            Intent intent = new Intent();

            intent.setClass(mView.getContextView(), InstallmentsActivity.class);
            intent.putExtra(Constants.Api.ISSUER_ID, item.getId());
            intent.putExtra(Constants.Api.PAYMENT_METHOD_ID, paymentMethod);
            intent.putExtra(Constants.Api.AMOUNT, amount);

            mView.launchActivity(intent);
        }
    }

