package com.example.avalo.mlexercise.api;

import com.example.avalo.mlexercise.data.CardIssuersRepository;
import com.example.avalo.mlexercise.data.InstallmentsRepository;
import com.example.avalo.mlexercise.data.MercadoPagoRepositories;
import com.example.avalo.mlexercise.data.PaymentMethodRepository;

public class Injection {

    public static PaymentMethodRepository providePaymentMethodRepository(){
        return MercadoPagoRepositories.getPaymentMethods(PaymentMethodApiClient.getInstance(),
                PaymentMethodLocalServiceImpl.getInstance());
    }

    public static CardIssuersRepository provideCardIssuersRepository(){
        return MercadoPagoRepositories.getCardIssuers(CardIssuersApiClient.getInstance(),
                CardIssuersLocalServiceImpl.getInstance());
    }

    public static InstallmentsRepository provideInstallmentsRepository(){
        return MercadoPagoRepositories.getInstallments(InstallmentsApiClient.getInstance(),
                InstallmentsLocalServiceImpl.getInstance());
    }
}

