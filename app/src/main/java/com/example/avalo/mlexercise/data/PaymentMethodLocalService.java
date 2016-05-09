package com.example.avalo.mlexercise.data;

import com.example.avalo.mlexercise.models.PaymentMethod;

import java.util.List;

public interface PaymentMethodLocalService {
    interface PaymentMethodLocalCallback<T> {
        void onLoaded(T paymentMethods);

        void onError(Throwable t);
    }

    void getPaymentMethodsSaved(PaymentMethodLocalCallback<List<PaymentMethod>> callback);
}
