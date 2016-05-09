package com.example.avalo.mlexercise.paymentmethod;

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
import com.example.avalo.mlexercise.models.PaymentMethod;
import com.example.avalo.mlexercise.utils.Constants;

import java.util.List;

import butterknife.BindView;

public class PaymentMethodFragment extends BaseFragment implements PaymentMethodContract.View {

    @BindView(R.id.list_payment_method)
    RecyclerView mPaymentMethodList;

    @BindView(R.id.progress)
    ProgressBar mProgressBar;

    @BindView(R.id.layout_error)
    LinearLayout mErrorLayout;

    @BindView(R.id.button_retry)
    ImageButton mRetryButton;

    PaymentMethodAdapter mPaymentMethodAdapter;

    PaymentMethodContract.UserActionListener mActionListener;

    Double amount;

    public static PaymentMethodFragment newInstance() {
        return new PaymentMethodFragment();
    }

    @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_payment_method;
    }

    @Override
    public void initView(View view, Bundle savedInstanceState) {
        super.initView(view, savedInstanceState);

        if (savedInstanceState == null) {
            savedInstanceState = getArguments();
        }

        amount = (Double) savedInstanceState.getSerializable(Constants.Api.AMOUNT);

        mPaymentMethodAdapter = createStoriesAdapter(new OnItemClickListener<PaymentMethod>() {
            @Override
            public void onItemClicked(int position, PaymentMethod item) {
                mActionListener.PaymentMethodDetail(item, amount);
            }
        });
        initializeList(mPaymentMethodList, mPaymentMethodAdapter);
        initializeRetryButton(mRetryButton);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (mActionListener == null)
            mActionListener = new PaymentMethodPresenter(this, Injection.providePaymentMethodRepository());

        mActionListener.requestPaymentMethods();
    }

    @Override
    public void setProgressVisible(boolean visible) {
        mProgressBar.setVisibility(visible ? View.VISIBLE : View.INVISIBLE);
    }

    @Override
    public void launchActivity(Intent intent) {
        getActivity().startActivityForResult(intent, Constants.CARD_ISSUER_FINISHED);
    }

    @Override
    public Context getContextView() {
        return getContext();
    }

    public void showPaymentMethods(List<PaymentMethod> paymentMethodList) {
        mPaymentMethodAdapter.setItems(paymentMethodList);
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
                mActionListener.requestPaymentMethods();
            }
        });
    }

    private PaymentMethodAdapter createStoriesAdapter(@Nullable OnItemClickListener<PaymentMethod> listener) {
        PaymentMethodAdapter adapter = new PaymentMethodAdapter();

        if (listener != null)
            adapter.setItemClickListener(listener);

        return adapter;
    }


}
