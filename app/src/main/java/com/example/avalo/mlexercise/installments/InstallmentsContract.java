package com.example.avalo.mlexercise.installments;

import android.content.Context;
import android.content.Intent;

import com.example.avalo.mlexercise.models.PayerCost;

import java.util.List;

public class InstallmentsContract {

        public interface View {
            void setProgressVisible(boolean visible);

            void showPayerCosts(List<PayerCost> payerCosts);

            void showRequestError();

            void launchActivity(Intent intent);

            Context getContextView();

            Intent getIntentView();

            void finishActivity(Intent intent);
        }

        public interface UserActionListener {
            void requestInstallments(String paymentMethodId, String issuerId, Double amount);

            void PayerCostDetail(PayerCost item, String paymentMethodId, String issuerId, Double amount);
        }
    }
