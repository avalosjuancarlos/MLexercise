package com.example.avalo.mlexercise.cardissuers;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.example.avalo.mlexercise.R;

public abstract class FragmentContainerActivity extends AppCompatActivity{

    protected abstract Fragment createFragment();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_issuers);

        setupToolbar();

        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fragment_container_card_issuers);

        if(savedInstanceState == null){
            savedInstanceState = getIntent().getExtras();
        }

        if (fragment == null){
            fragment = createFragment();
            fragment.setArguments(savedInstanceState);
            fm.beginTransaction()
                    .add(R.id.fragment_container_card_issuers, fragment)
                    .commit();
        }
    }

    private void setupToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        if (toolbar != null){
            setSupportActionBar(toolbar);
            toolbar.setNavigationIcon(R.mipmap.ic_launcher);
        }
    }
}

