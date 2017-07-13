package com.jrm.adolp.animationcustomviewset.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.jrm.adolp.animationcustomviewset.R;
import com.jrm.adolp.animationcustomviewset.activities.BaseActivity;

/**
 * Created by adolp on 2017/7/13.
 */

public class CustomViewSetActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getContentViewId() {
        return R.layout.customview_set_layout;
    }


}
