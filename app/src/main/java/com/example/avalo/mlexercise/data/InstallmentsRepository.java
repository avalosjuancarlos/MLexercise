package com.example.avalo.mlexercise.data;

import com.example.avalo.mlexercise.models.Installment;

import java.util.List;

public interface InstallmentsRepository {

        interface FetchInstallmentsCallback {
            void onSuccess(List<Installment> installments);

            void onError(Throwable t);
        }

        void fetchInstallments(String paymentMethodId, String issuerId, Double amount, FetchInstallmentsCallback callback);
    }
