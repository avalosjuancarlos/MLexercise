package com.example.avalo.mlexercise.api;

import com.example.avalo.mlexercise.data.InstallmentsLocalService;
import com.example.avalo.mlexercise.models.Installment;

import java.io.IOException;
import java.util.List;

public class InstallmentsLocalServiceImpl implements InstallmentsLocalService {
    static InstallmentsLocalServiceImpl mInstance;

    public static InstallmentsLocalServiceImpl getInstance() {
        if (mInstance == null)
            mInstance = new InstallmentsLocalServiceImpl();

        return mInstance;
    }

    @Override
    public void getInstallmentsSaved(String paymentMethodId, String issuerId, Double amount, InstallmentsLocalService.InstallmentsLocalCallback<List<Installment>> callback) {
        //TODO: Query to DB
        callback.onError(new IOException());
    }
}
