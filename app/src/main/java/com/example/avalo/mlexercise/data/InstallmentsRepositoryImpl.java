package com.example.avalo.mlexercise.data;


import com.example.avalo.mlexercise.models.Installment;

import java.util.List;

public class InstallmentsRepositoryImpl implements InstallmentsRepository {

    InstallmentsApiService mApiService;
    InstallmentsLocalService mLocalService;

        public InstallmentsRepositoryImpl(InstallmentsApiService apiService, InstallmentsLocalService localService) {
            mApiService = apiService;
            mLocalService = localService;

        }

    @Override
    public void fetchInstallments(final String paymentMethodId, final String issuerId, final Double amount, final FetchInstallmentsCallback callback) {

            mApiService.fetchInstallments(paymentMethodId,issuerId, amount,  new InstallmentsApiService.InstallmentsApiCallback<List<Installment>>() {
                @Override
                public void onLoaded(List<Installment> installments) {
                    callback.onSuccess(installments);
                }

                @Override
                public void onError(Throwable t) {
                    mLocalService.getInstallmentsSaved(paymentMethodId, issuerId, amount, new InstallmentsLocalService.InstallmentsLocalCallback<List<Installment>>() {
                        @Override
                        public void onLoaded(List<Installment> installments) {
                            callback.onSuccess(installments);
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
