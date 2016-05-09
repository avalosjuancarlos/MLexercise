package com.example.avalo.mlexercise.data;

import com.example.avalo.mlexercise.models.PaymentMethod;

import java.util.List;

public interface PaymentMethodApiService {

    interface PaymentMethodApiCallback<T> {
        void onLoaded(T paymentMethods);

        void onError(Throwable t);
    }

    void fetchPaymentMethods(PaymentMethodApiCallback<List<PaymentMethod>> callback);
}
