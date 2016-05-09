package com.example.avalo.mlexercise.main;

import android.content.Intent;

import com.example.avalo.mlexercise.paymentmethod.PaymentMethodActivity;
import com.example.avalo.mlexercise.utils.Constants;

public class MainPresenter implements MainContract.UserActionListener {

    private MainContract.View mView;

    public MainPresenter(MainContract.View view) {
        mView = view;
    }

    @Override
    public void selectPaymentMethod(Double amount) {
        Intent intent = new Intent();

        intent.setClass(mView.getContextView(), PaymentMethodActivity.class);
        intent.putExtra(Constants.Api.AMOUNT, amount);

        mView.launchActivity(intent);
    }
}
