package com.example.avalo.mlexercise.data;

import com.example.avalo.mlexercise.models.PaymentMethod;

import java.util.List;

public class PaymentMethodRepositoryImpl implements PaymentMethodRepository {

    PaymentMethodApiService mApiService;
    PaymentMethodLocalService mLocalService;

    public PaymentMethodRepositoryImpl(PaymentMethodApiService apiService, PaymentMethodLocalService localService) {
        mApiService = apiService;
        mLocalService = localService;
    }

    @Override
    public void fetchPaymentMethods(final FetchPaymentMethodsCallback callback) {
        mApiService.fetchPaymentMethods(new PaymentMethodApiService.PaymentMethodApiCallback<List<PaymentMethod>>() {
            @Override
            public void onLoaded(List<PaymentMethod> paymentMethods) {
                callback.onSuccess(paymentMethods);
            }

            @Override
            public void onError(Throwable t) {
                mLocalService.getPaymentMethodsSaved(new PaymentMethodLocalService.PaymentMethodLocalCallback<List<PaymentMethod>>() {
                    @Override
                    public void onLoaded(List<PaymentMethod> paymentMethods) {
                        callback.onSuccess(paymentMethods);
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
