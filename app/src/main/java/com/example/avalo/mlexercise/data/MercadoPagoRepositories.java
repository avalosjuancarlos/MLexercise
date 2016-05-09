package com.example.avalo.mlexercise.data;

import android.support.annotation.NonNull;

public class MercadoPagoRepositories {

    public static PaymentMethodRepository sPaymentMethodRepository = null;
    public static CardIssuersRepository sCardIssuersRepository = null;
    public static InstallmentsRepository sInstallmentsRepository = null;

    public static PaymentMethodRepository getPaymentMethods(@NonNull PaymentMethodApiService apiService, PaymentMethodLocalService localService) {
        if (sPaymentMethodRepository == null)
            sPaymentMethodRepository = new PaymentMethodRepositoryImpl(apiService, localService);

        return sPaymentMethodRepository;
    }

    public static CardIssuersRepository getCardIssuers(@NonNull CardIssuersApiService apiService, CardIssuersLocalService localService) {
        if (sCardIssuersRepository == null)
            sCardIssuersRepository = new CardIssuersRepositoryImpl(apiService, localService);

        return sCardIssuersRepository;
    }

    public static InstallmentsRepository getInstallments(@NonNull InstallmentsApiService apiService, InstallmentsLocalService localService) {
        if (sInstallmentsRepository == null)
            sInstallmentsRepository = new InstallmentsRepositoryImpl(apiService, localService);

        return sInstallmentsRepository;
    }
}
