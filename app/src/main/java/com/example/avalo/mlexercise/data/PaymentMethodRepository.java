package com.example.avalo.mlexercise.data;

import com.example.avalo.mlexercise.models.PaymentMethod;

import java.util.List;

public interface PaymentMethodRepository {

    interface FetchPaymentMethodsCallback {
        void onSuccess(List<PaymentMethod> paymentMethods);

        void onError(Throwable t);
    }

    void fetchPaymentMethods(FetchPaymentMethodsCallback callback);
}
