package com.example.avalo.mlexercise.data;

import com.example.avalo.mlexercise.models.Installment;

import java.util.List;

public interface InstallmentsApiService {
        interface InstallmentsApiCallback<T> {
            void onLoaded(T installments);

            void onError(Throwable t);
        }

        void fetchInstallments(String paymentMethodId, String issuerId, Double amount, InstallmentsApiCallback<List<Installment>> callback);
    }
