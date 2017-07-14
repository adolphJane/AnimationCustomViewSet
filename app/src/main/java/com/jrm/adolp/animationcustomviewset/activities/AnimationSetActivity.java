package com.jrm.adolp.animationcustomviewset.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.jrm.adolp.animationcustomviewset.R;
import com.jrm.adolp.animationcustomviewset.adapter.AnimationAdapter;
import com.jrm.adolp.animationcustomviewset.fragments.animation.Rotate3DFragment;
import com.jrm.adolp.animationcustomviewset.fragments.customview.TheThreeDBoxFragment;
import com.jrm.adolp.animationcustomviewset.listener.ViewPagerListenter;
import com.jrm.adolp.animationcustomviewset.tools.ToolbarHelper;

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
        return R.layout.animation_set_layout;
    }

    @Override
    protected void initView(){
        animationViewPager = (ViewPager) findViewById(R.id.animation_set_vp);
    }

    @Override
    protected void initData() {
        adapter = new AnimationAdapter(getSupportFragmentManager());
        initFragment();
        animationViewPager.setAdapter(adapter);
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
