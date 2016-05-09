package com.example.avalo.mlexercise.cardissuers;


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
import com.example.avalo.mlexercise.installments.InstallmentsFragment;
import com.example.avalo.mlexercise.models.CardIssuer;
import com.example.avalo.mlexercise.utils.Constants;

import java.util.List;

import butterknife.BindView;

public class CardIssuersFragment extends BaseFragment implements CardIssuersContract.View {

    @BindView(R.id.list_card_issuers)
    RecyclerView mCardIssuersList;

    @BindView(R.id.progress)
    ProgressBar mProgressBar;

    @BindView(R.id.layout_error)
    LinearLayout mErrorLayout;

    @BindView(R.id.button_retry)
    ImageButton mRetryButton;

    CardIssuersAdapter mCardIssuersAdapter;

    CardIssuersContract.UserActionListener mActionListener;

    Double amount;
    static String paymentMethodId;

    public static CardIssuersFragment newInstance() {
        return new CardIssuersFragment();
    }

    @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_card_issuers;
    }

    @Override
    public void initView(View view, Bundle savedInstanceState) {
        super.initView(view, savedInstanceState);

        if (savedInstanceState == null) {
            savedInstanceState = getArguments();
        }

        amount = (Double) savedInstanceState.getSerializable(Constants.Api.AMOUNT);
        paymentMethodId = (String) savedInstanceState.getSerializable(Constants.Api.PAYMENT_METHOD_ID);

        mCardIssuersAdapter = createCardIssuersAdapter(new OnItemClickListener<CardIssuer>() {
            @Override
            public void onItemClicked(int position, CardIssuer item) {
                mActionListener.CardIssuerDetail(item, paymentMethodId, amount);
            }
        });
        initializeList(mCardIssuersList, mCardIssuersAdapter);
        initializeRetryButton(mRetryButton);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (mActionListener == null)
            mActionListener = new CardIssuersPresenter(this, Injection.provideCardIssuersRepository());

        if (paymentMethodId == null) {
            paymentMethodId = (String) getArguments().getSerializable(Constants.Api.PAYMENT_METHOD_ID);
        }
        mActionListener.requestCardIssuers(paymentMethodId);
    }

    @Override
    public void setProgressVisible(boolean visible) {
        mProgressBar.setVisibility(visible ? View.VISIBLE : View.INVISIBLE);
    }

    @Override
    public void launchActivity(Intent intent) {
        getActivity().startActivityForResult(intent, Constants.INSTALLMENT_FINISHED);
    }

    @Override
    public Context getContextView() {
        return getContext();
    }

    public void showCardIssuers(List<CardIssuer> cardIssuerList) {
        mCardIssuersAdapter.setItems(cardIssuerList);
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
                mActionListener.requestCardIssuers(paymentMethodId);
            }
        });
    }

    private CardIssuersAdapter createCardIssuersAdapter(@Nullable OnItemClickListener<CardIssuer> listener) {
        CardIssuersAdapter adapter = new CardIssuersAdapter();

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
