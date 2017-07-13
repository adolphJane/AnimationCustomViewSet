package com.jrm.adolp.animationcustomviewset;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;

import com.jrm.adolp.animationcustomviewset.tools.ToolbarHelper;

/**
 * Created by adolp on 2017/7/13.
 */

public class AnimationSetActivity extends BaseActivity{

    private Toolbar toolbar;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.animation_set_layout);

        initView();
    }

    @Override
    public void handleToolbar(ToolbarHelper helper) {
        super.handleToolbar(helper);
        helper.setTitle("ANIMATION-SET");
    }

    private void initView(){

    }
}
