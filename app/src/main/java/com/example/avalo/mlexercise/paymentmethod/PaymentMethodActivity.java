package com.example.avalo.mlexercise.paymentmethod;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.widget.Toast;

import com.example.avalo.mlexercise.R;
import com.example.avalo.mlexercise.utils.Constants;

public class PaymentMethodActivity extends FragmentContainerActivity {

    @Override
    protected Fragment createFragment() {
        return PaymentMethodFragment.newInstance();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActionBar actionBar = getSupportActionBar();

        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowHomeEnabled(true);
            actionBar.setTitle(getResources().getString(R.string.activity_title_payment_method));
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == Constants.CARD_ISSUER_FINISHED) {
            if(resultCode == Activity.RESULT_OK){

                setResult(Activity.RESULT_OK, data);
                finish();
            }
            if (resultCode == Activity.RESULT_CANCELED) {
                //Write your code if there's no result
            }
        }
    }
}
