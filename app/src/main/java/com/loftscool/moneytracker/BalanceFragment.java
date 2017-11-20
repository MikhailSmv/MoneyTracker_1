package com.loftscool.moneytracker;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class BalanceFragment extends android.support.v4.app.Fragment{

    public static final String TYPE_BALANCE = "balance";
    public static final String KEY_TYPE = "TYPE";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View balanceview = inflater.inflate(R.layout.fragment_balance,container,false);
        return balanceview;
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onViewCreated(View balance, @Nullable Bundle savedInstanceState) {

    }
}