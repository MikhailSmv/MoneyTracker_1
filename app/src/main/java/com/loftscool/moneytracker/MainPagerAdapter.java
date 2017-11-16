package com.loftscool.moneytracker;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


public class MainPagerAdapter extends FragmentPagerAdapter {
    private final static int PAGE_EXPENSES = 0;
    private final static int PAGE_INCOMES = 1;
    private final static int PAGE_BALANSE = 2;


    private  String[] titles;
    public MainPagerAdapter(FragmentManager fm, Resources resources) {
        super(fm);

        titles = resources.getStringArray(R.array.tabs_tittles);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case PAGE_EXPENSES: {
                Bundle bundle = new Bundle();
                bundle.putInt(ItemsFragment.KEY_TYPE, ItemsFragment.TYPE_EXPENSE);
                Fragment fragment = new ItemsFragment();
                fragment.setArguments(bundle);
                return fragment;
            }

            case PAGE_INCOMES: {
                Bundle bundle = new Bundle();
                bundle.putInt(ItemsFragment.KEY_TYPE, ItemsFragment.TYPE_INCOME);
                Fragment fragment = new ItemsFragment();
                fragment.setArguments(bundle);
                return fragment;
            }
            case PAGE_BALANSE:
                Bundle bundle = new Bundle();
                bundle.putInt(BalanceFragment.KEY_TYPE,BalanceFragment.TYPE_BALANCE);

                Fragment fragment = new BalanceFragment();
                fragment.setArguments(bundle);
                return fragment;

            default:
                return null;
        }

    }

    @Override
    public int getCount() {
        return titles.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}
