package com.example.avalo.mlexercise.main;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.widget.Toast;

import com.example.avalo.mlexercise.R;
import com.example.avalo.mlexercise.utils.Constants;

public class MainActivity extends FragmentContainerActivity {

    @Override
    protected Fragment createFragment() {
        return MainFragment.newInstance();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActionBar actionBar = getSupportActionBar();

        if (actionBar != null) {
            actionBar.setTitle(getResources().getString(R.string.activity_title_main));
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == Constants.PAYMENT_METHOD_FINISHED) {
            if(resultCode == Activity.RESULT_OK){
                Double amount = data.getDoubleExtra(Constants.Api.AMOUNT, 0);
                String paymentMethodId = data.getStringExtra(Constants.Api.PAYMENT_METHOD_ID);
                String issuerId = data.getStringExtra(Constants.Api.ISSUER_ID);
                String recommendedMessage = data.getStringExtra(Constants.Api.RECOMMENDED_MESSAGE);

                Toast.makeText(this,String.format(getString(R.string.message), amount.toString(), paymentMethodId, issuerId, recommendedMessage), Toast.LENGTH_LONG).show();
            }
            if (resultCode == Activity.RESULT_CANCELED) {
                //Write your code if there's no result
            }
        }
    }
}
