package com.jrm.adolph.animationcustomviewset.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.jrm.adolph.animationcustomviewset.R;
import com.jrm.adolph.animationcustomviewset.adapter.CustomViewAdapter;
import com.jrm.adolph.animationcustomviewset.fragments.customview.LeftDelFragment;
import com.jrm.adolph.animationcustomviewset.fragments.customview.TheThreeDBoxFragment;
import com.jrm.adolph.animationcustomviewset.listener.ViewPagerListenter;
import com.jrm.adolph.animationcustomviewset.view.MyViewPager;

/**
 * Created by adolp on 2017/7/13.
 */

public class CustomViewSetActivity extends BaseActivity {

    private MyViewPager customViewPager;
    private CustomViewAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected void initView() {
        customViewPager = (MyViewPager) findViewById(R.id.customview_set_vp);
        customViewPager.setPageMargin(100);
        customViewPager.setAdapter(adapter);
    }

    @Override
    protected void initData() {
        adapter = new CustomViewAdapter(getSupportFragmentManager());
        initFragment();
    }

    private void initFragment(){
        adapter.addFragment(new TheThreeDBoxFragment());
        adapter.addFragment(new LeftDelFragment());
    }

    @Override
    protected void initListener() {
        customViewPager.addOnPageChangeListener(new ViewPagerListenter());
    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_customview_set_layout;
    }


    @Override
    public void onClick(View view) {

    }
}
