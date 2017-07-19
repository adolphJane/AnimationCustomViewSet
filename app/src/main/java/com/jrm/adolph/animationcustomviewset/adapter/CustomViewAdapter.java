package com.jrm.adolph.animationcustomviewset.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by adolp on 2017/7/14.
 */

public class CustomViewAdapter extends FragmentStatePagerAdapter {

    public static final String TAG = AnimationAdapter.class.getSimpleName();
    private List<Fragment> mFragments = new ArrayList<>();

    public void addFragment(Fragment fragment){
        mFragments.add(fragment);
    }

    public void removeFragment(Fragment fragment){
        mFragments.remove(fragment);
    }

    public void setFragments(List<Fragment> fragments){
        mFragments = fragments;
    }

    public List<Fragment> getFragments(){
        return mFragments;
    }

    public void clear(){
        for (Fragment fragment : mFragments){
            if (fragment != null && fragment.isAdded()){
                fragment.onDestroy();
            }
        }
        mFragments.clear();
    }

    public CustomViewAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }
}
