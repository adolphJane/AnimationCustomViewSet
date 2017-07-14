package com.jrm.adolp.animationcustomviewset.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.jrm.adolp.animationcustomviewset.R;
import com.jrm.adolp.animationcustomviewset.activities.BaseActivity;
import com.jrm.adolp.animationcustomviewset.adapter.CustomViewAdapter;
import com.jrm.adolp.animationcustomviewset.fragments.customview.TheThreeDBoxFragment;
import com.jrm.adolp.animationcustomviewset.listener.ViewPagerListenter;

/**
 * Created by adolp on 2017/7/13.
 */

public class CustomViewSetActivity extends BaseActivity {

    private ViewPager customViewPager;
    private CustomViewAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected void initView() {
        customViewPager = (ViewPager) findViewById(R.id.customview_set_vp);
    }

    @Override
    protected void initData() {
        adapter = new CustomViewAdapter(getSupportFragmentManager());
        initFragment();
        customViewPager.setAdapter(adapter);
    }

    private void initFragment(){
        adapter.addFragment(new TheThreeDBoxFragment());
    }

    @Override
    protected void initListener() {
        customViewPager.addOnPageChangeListener(new ViewPagerListenter());
    }

    @Override
    protected int getContentViewId() {
        return R.layout.customview_set_layout;
    }


    @Override
    public void onClick(View view) {

    }
}
