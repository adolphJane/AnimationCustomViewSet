package com.jrm.adolp.animationcustomviewset.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.jrm.adolp.animationcustomviewset.R;
import com.jrm.adolp.animationcustomviewset.tools.ToolbarHelper;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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

    public void startAnimation(View view){
        if (view.getId() == R.id.btn_animation) {
            Intent intent = new Intent(MainActivity.this, AnimationSetActivity.class);
            startActivity(intent);
        }
    }

    public void startCustomView(View view){
        if (view.getId() == R.id.btn_customview) {
            Intent intent = new Intent(MainActivity.this, CustomViewSetActivity.class);
            startActivity(intent);
        }
    }
}
