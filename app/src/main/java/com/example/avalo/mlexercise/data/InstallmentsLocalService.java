package com.example.avalo.mlexercise.data;

import com.example.avalo.mlexercise.models.Installment;

import java.util.List;

public interface InstallmentsLocalService {
    interface InstallmentsLocalCallback<T> {
            void onLoaded(T installments);

            void onError(Throwable t);
        }

        void getInstallmentsSaved(String paymentMethodId, String issuerId, Double amount, InstallmentsLocalCallback<List<Installment>> callback);
    }

