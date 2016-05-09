package com.example.avalo.mlexercise.main;

import android.content.Context;
import android.content.Intent;

public class MainContract {

    public interface View {

        void launchActivity(Intent intent);

        Context getContextView();
    }

    public interface UserActionListener {

        void selectPaymentMethod(Double amount);
    }
}
