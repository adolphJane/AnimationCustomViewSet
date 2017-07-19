package com.jrm.adolph.animationcustomviewset.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.jrm.adolph.animationcustomviewset.R;
import com.jrm.adolph.animationcustomviewset.tools.ToolbarHelper;

public class MainActivity extends BaseActivity {

    private Button btnAnimation,btnCustomView,btnTestView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initView() {
        btnAnimation = (Button) findViewById(R.id.btn_animation);
        btnCustomView = (Button) findViewById(R.id.btn_customview);
        btnTestView = (Button) findViewById(R.id.btn_testView);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {
        btnAnimation.setOnClickListener(this);
        btnCustomView.setOnClickListener(this);
        btnTestView.setOnClickListener(this);
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
            case R.id.btn_testView:
                openActivity(TestViewActivity.class);
                break;
        }
    }
}
