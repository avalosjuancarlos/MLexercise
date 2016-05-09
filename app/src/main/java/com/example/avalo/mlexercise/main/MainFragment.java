package com.example.avalo.mlexercise.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.text.TextUtilsCompat;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;

import com.example.avalo.mlexercise.BaseFragment;
import com.example.avalo.mlexercise.R;
import com.example.avalo.mlexercise.utils.Constants;

import butterknife.BindView;

public class MainFragment extends BaseFragment implements MainContract.View {

    @BindView(R.id.text_amount)
    TextInputEditText mTextAmount;

    @BindView(R.id.text_amount_layout)
    TextInputLayout mLayoutAmount;

    @BindView(R.id.button_process_payment)
    Button mProcessButton;


    MainContract.UserActionListener mActionListener;

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_main;
    }

    @Override
    public void initView(View view, Bundle savedInstanceState) {
        super.initView(view, savedInstanceState);
        initializeProcessButton(mProcessButton);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (mActionListener == null)
            mActionListener = new MainPresenter(this);

    }

    @Override
    public void launchActivity(Intent intent) {
        getActivity().startActivityForResult(intent, Constants.PAYMENT_METHOD_FINISHED);
    }

    @Override
    public Context getContextView() {
        return getContext();
    }


    private void initializeProcessButton(Button processButton) {
        processButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(validateAmount()) {
                    Double amount = Double.parseDouble(mTextAmount.getText().toString());
                    mActionListener.selectPaymentMethod(amount);
                }
            }
        });
    }

    private boolean validateAmount(){
        String text = mTextAmount.getText().toString();
        boolean isValid = false;
        if(!TextUtils.isEmpty(text)) {
            Double amount = Double.parseDouble(text);
            isValid = !amount.isNaN();
        }

        if(!isValid){
            mLayoutAmount.setError(getString(R.string.invalid_amount_message));
        } else {
            mLayoutAmount.setErrorEnabled(false);
        }

        return isValid;
    }

}
