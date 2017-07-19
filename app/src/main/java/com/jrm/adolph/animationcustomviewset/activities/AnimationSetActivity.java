package com.jrm.adolph.animationcustomviewset.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.jrm.adolph.animationcustomviewset.R;
import com.jrm.adolph.animationcustomviewset.adapter.AnimationAdapter;
import com.jrm.adolph.animationcustomviewset.fragments.animation.Rotate3DFragment;
import com.jrm.adolph.animationcustomviewset.listener.ViewPagerListenter;
import com.jrm.adolph.animationcustomviewset.tools.ToolbarHelper;

/**
 * Created by adolp on 2017/7/13.
 */

public class AnimationSetActivity extends BaseActivity {

    private ViewPager animationViewPager;
    private AnimationAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void handleToolbar(ToolbarHelper helper) {
        super.handleToolbar(helper);
        helper.setTitle("AnimationSet");
    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_animation_set_layout;
    }

    @Override
    protected void initView(){
        animationViewPager = (ViewPager) findViewById(R.id.animation_set_vp);
        animationViewPager.setPageMargin(100);
        animationViewPager.setAdapter(adapter);
    }

    @Override
    protected void initData() {
        adapter = new AnimationAdapter(getSupportFragmentManager());
        initFragment();
    }

    private void initFragment(){
        adapter.addFragment(new Rotate3DFragment());
    }

    @Override
    protected void initListener() {
        animationViewPager.addOnPageChangeListener(new ViewPagerListenter());
    }

    @Override
    public void onClick(View view) {

    }
}
