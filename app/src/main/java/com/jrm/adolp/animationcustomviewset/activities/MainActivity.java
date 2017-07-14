package com.jrm.adolp.animationcustomviewset.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.jrm.adolp.animationcustomviewset.R;
import com.jrm.adolp.animationcustomviewset.tools.ToolbarHelper;

public class MainActivity extends BaseActivity {

    private Button btnAnimation,btnCustomView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initView() {
        btnAnimation = (Button) findViewById(R.id.btn_animation);
        btnCustomView = (Button) findViewById(R.id.btn_customview);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {
        btnAnimation.setOnClickListener(this);
        btnCustomView.setOnClickListener(this);
    }

    @Override
    public void handleToolbar(ToolbarHelper helper) {
        super.handleToolbar(helper);
        helper.setTitle("MagicalView");
    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_main;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_animation:
                openActivity(AnimationSetActivity.class);
                break;
            case R.id.btn_customview:
                openActivity(CustomViewSetActivity.class);
                break;
        }
    }
}
