package com.jrm.adolp.animationcustomviewset;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.jrm.adolp.animationcustomviewset.tools.ToolbarHelper;

/**
 * Created by adolp on 2017/7/13.
 */

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        if (toolbar != null){
            setSupportActionBar(toolbar);
            getSupportActionBar().setDisplayShowTitleEnabled(false);
            ToolbarHelper helper = new ToolbarHelper(toolbar);
            handleToolbar(helper);
        }
    }

    public void handleToolbar(ToolbarHelper helper){

    }
}
