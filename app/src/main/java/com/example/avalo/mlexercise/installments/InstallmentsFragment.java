package com.example.avalo.mlexercise.installments;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import com.example.avalo.mlexercise.BaseFragment;
import com.example.avalo.mlexercise.OnItemClickListener;
import com.example.avalo.mlexercise.R;
import com.example.avalo.mlexercise.SimpleSpaceDecorator;
import com.example.avalo.mlexercise.api.Injection;
import com.example.avalo.mlexercise.cardissuers.CardIssuersFragment;
import com.example.avalo.mlexercise.models.PayerCost;
import com.example.avalo.mlexercise.utils.Constants;

import java.util.List;

import butterknife.BindView;

public class InstallmentsFragment extends BaseFragment implements InstallmentsContract.View {

    @BindView(R.id.list_installments)
    RecyclerView mInstallmentsList;

    @BindView(R.id.progress)
    ProgressBar mProgressBar;

    @BindView(R.id.layout_error)
    LinearLayout mErrorLayout;

    @BindView(R.id.button_retry)
    ImageButton mRetryButton;

    InstallmentsAdapter mInstallmentsAdapter;

    InstallmentsContract.UserActionListener mActionListener;

    static Double amount;
    static String paymentMethodId;
    static String issuerId;

    public static InstallmentsFragment newInstance() {
        return new InstallmentsFragment();
    }

    @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_installments;
    }

    @Override
    public void initView(View view, Bundle savedInstanceState) {
        super.initView(view, savedInstanceState);

        if (savedInstanceState == null) {
            savedInstanceState = getArguments();
        }

        issuerId = (String) savedInstanceState.getSerializable(Constants.Api.ISSUER_ID);
        amount = (Double) savedInstanceState.getSerializable(Constants.Api.AMOUNT);
        paymentMethodId = (String) savedInstanceState.getSerializable(Constants.Api.PAYMENT_METHOD_ID);

        mInstallmentsAdapter = createInstallmentsAdapter(new OnItemClickListener<PayerCost>() {
            @Override
            public void onItemClicked(int position, PayerCost item) {
                mActionListener.PayerCostDetail(item, paymentMethodId, issuerId, amount);
            }
        });
        initializeList(mInstallmentsList, mInstallmentsAdapter);
        initializeRetryButton(mRetryButton);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (mActionListener == null)
            mActionListener = new InstallmentsPresenter(this, Injection.provideInstallmentsRepository());

        if (paymentMethodId == null) {
            issuerId = (String) getArguments().getSerializable(Constants.Api.ISSUER_ID);
            amount = (Double) getArguments().getSerializable(Constants.Api.AMOUNT);
            paymentMethodId = (String) getArguments().getSerializable(Constants.Api.PAYMENT_METHOD_ID);
        }
        mActionListener.requestInstallments(paymentMethodId, issuerId, amount);
    }

    @Override
    public void setProgressVisible(boolean visible) {
        mProgressBar.setVisibility(visible ? View.VISIBLE : View.INVISIBLE);
    }

    @Override
    public void launchActivity(Intent intent) {
        startActivity(intent);
    }

    @Override
    public Context getContextView() {
        return getContext();
    }

    @Override
    public Intent getIntentView() {
        return getActivity().getIntent();
    }

    @Override
    public void finishActivity(Intent intent) {
        getActivity().setResult(Activity.RESULT_OK, intent);
        getActivity().finish();
    }

    @Override
    public void showPayerCosts(List<PayerCost> payerCostsList) {
        mInstallmentsAdapter.setItems(payerCostsList);
    }

    @Override
    public void showRequestError() {
        mErrorLayout.setVisibility(View.VISIBLE);
    }

    private void initializeList(RecyclerView list, RecyclerView.Adapter adapter) {
        list.setLayoutManager(new LinearLayoutManager(getContext()));
        list.addItemDecoration(new SimpleSpaceDecorator(getContext(), R.dimen.spacing_medium));
        list.setAdapter(adapter);
    }

    private void initializeRetryButton(ImageButton retryButton) {
        retryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mErrorLayout.setVisibility(View.INVISIBLE);
                mActionListener.requestInstallments(paymentMethodId, issuerId, amount);
            }
        });
    }

    private InstallmentsAdapter createInstallmentsAdapter(@Nullable OnItemClickListener<PayerCost> listener) {
        InstallmentsAdapter adapter = new InstallmentsAdapter();

        if (listener != null)
            adapter.setItemClickListener(listener);

        return adapter;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        if (outState.isEmpty()) {
            outState = getArguments();
        }

        super.onSaveInstanceState(outState);
    }
}
