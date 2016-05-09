package com.example.avalo.mlexercise.cardissuers;

import android.content.Context;
import android.content.Intent;

import com.example.avalo.mlexercise.models.CardIssuer;

import java.util.List;

public class CardIssuersContract {

        public interface View {
            void setProgressVisible(boolean visible);

            void showCardIssuers(List<CardIssuer> cardIssuers);

            void showRequestError();

            void launchActivity(Intent intent);

            Context getContextView();
        }

        public interface UserActionListener {
            void requestCardIssuers(String paymentMethodId);

            void CardIssuerDetail(CardIssuer item,  String paymentMethod, Double amount);
        }
    }
