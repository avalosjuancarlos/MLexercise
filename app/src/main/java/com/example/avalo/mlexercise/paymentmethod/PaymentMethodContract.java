package com.example.avalo.mlexercise.paymentmethod;

import android.content.Context;
import android.content.Intent;

import com.example.avalo.mlexercise.models.PaymentMethod;

import java.util.List;

public class PaymentMethodContract {

    public interface View {
        void setProgressVisible(boolean visible);

        void showPaymentMethods(List<PaymentMethod> paymentMethods);

        void showRequestError();

        void launchActivity(Intent intent);

        Context getContextView();
    }

    public interface UserActionListener {
        void requestPaymentMethods();

        void PaymentMethodDetail(PaymentMethod item, Double amount);
    }
}
