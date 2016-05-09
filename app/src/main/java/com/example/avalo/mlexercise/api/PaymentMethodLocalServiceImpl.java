package com.example.avalo.mlexercise.api;

import com.example.avalo.mlexercise.data.PaymentMethodLocalService;
import com.example.avalo.mlexercise.models.PaymentMethod;

import java.io.IOException;
import java.util.List;

public class PaymentMethodLocalServiceImpl implements PaymentMethodLocalService{
    static PaymentMethodLocalServiceImpl mInstance;

    public static PaymentMethodLocalServiceImpl getInstance(){
        if (mInstance== null)
            mInstance = new PaymentMethodLocalServiceImpl();

        return mInstance;
    }

    @Override
    public void getPaymentMethodsSaved(PaymentMethodLocalCallback<List<PaymentMethod>> callback) {
        //TODO: Query to DB
        callback.onError(new IOException());
    }

}