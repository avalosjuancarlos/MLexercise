package com.example.avalo.mlexercise.installments;

import android.content.Intent;

import com.example.avalo.mlexercise.BuildConfig;
import com.example.avalo.mlexercise.data.InstallmentsRepository;
import com.example.avalo.mlexercise.models.Installment;
import com.example.avalo.mlexercise.models.PayerCost;
import com.example.avalo.mlexercise.utils.Constants;

import java.util.List;

public class InstallmentsPresenter implements InstallmentsContract.UserActionListener {

    private InstallmentsContract.View mView;
    private InstallmentsRepository mInstallmentsRepository;

    public InstallmentsPresenter(InstallmentsContract.View view, InstallmentsRepository installmentsRepository) {
        mView = view;
        this.mInstallmentsRepository = installmentsRepository;
    }

    @Override
    public void requestInstallments(String paymentMethodId, String issuerId, Double amount) {
        mView.setProgressVisible(true);
        mInstallmentsRepository.fetchInstallments(paymentMethodId, issuerId, amount, new InstallmentsRepository.FetchInstallmentsCallback() {
            @Override
            public void onSuccess(List<Installment> installments) {
                mView.setProgressVisible(false);
                mView.showPayerCosts((installments.get(0)).getPayerCosts()); //TODO: Verify get Payer Cost
            }

            @Override
            public void onError(Throwable t) {
                if (BuildConfig.DEBUG)
                    t.printStackTrace();

                mView.setProgressVisible(false);
                mView.showRequestError();
            }
        });
    }

    @Override
    public void PayerCostDetail(PayerCost item, String paymentMethodId, String issuerId, Double amount) {
        //Intent intent = new Intent();
        //intent.setClass(mView.getContextView(), InstallmentsActivity.class);

        Intent intent = mView.getIntentView();

        intent.putExtra(Constants.Api.RECOMMENDED_MESSAGE, item.getRecommendedMessage());
        intent.putExtra(Constants.Api.ISSUER_ID, issuerId);
        intent.putExtra(Constants.Api.PAYMENT_METHOD_ID, paymentMethodId);
        intent.putExtra(Constants.Api.AMOUNT, amount);

        mView.finishActivity(intent);
    }
}

