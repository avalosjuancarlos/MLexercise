package com.example.avalo.mlexercise.paymentmethod;

import android.content.Intent;

import com.example.avalo.mlexercise.BuildConfig;
import com.example.avalo.mlexercise.cardissuers.CardIssuersActivity;
import com.example.avalo.mlexercise.data.PaymentMethodRepository;
import com.example.avalo.mlexercise.models.PaymentMethod;
import com.example.avalo.mlexercise.utils.Constants;

import java.util.List;

public class PaymentMethodPresenter implements PaymentMethodContract.UserActionListener {

    private PaymentMethodContract.View mView;
    private PaymentMethodRepository mPaymentMethodRepository;

    public PaymentMethodPresenter(PaymentMethodContract.View view, PaymentMethodRepository storiesRepository) {
        mView = view;
        mPaymentMethodRepository = storiesRepository;
    }

    @Override
    public void requestPaymentMethods() {
        mView.setProgressVisible(true);
        mPaymentMethodRepository.fetchPaymentMethods(new PaymentMethodRepository.FetchPaymentMethodsCallback() {
            @Override
            public void onSuccess(List<PaymentMethod> paymentMethods) {
                mView.setProgressVisible(false);
                mView.showPaymentMethods(paymentMethods);
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
    public void PaymentMethodDetail(PaymentMethod item, Double amount) {
        Intent intent = new Intent();

        intent.setClass(mView.getContextView(), CardIssuersActivity.class);
        intent.putExtra(Constants.Api.PAYMENT_METHOD_ID, item.getId());
        intent.putExtra(Constants.Api.AMOUNT, amount);

        mView.launchActivity(intent);
    }
}
