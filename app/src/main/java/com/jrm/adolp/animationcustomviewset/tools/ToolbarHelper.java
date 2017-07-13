package com.jrm.adolp.animationcustomviewset.tools;

import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.TextView;

import com.jrm.adolp.animationcustomviewset.R;

/**
 * Created by adolp on 2017/7/13.
 */

public class ToolbarHelper {
    private Toolbar mToolbar;
    public ToolbarHelper(Toolbar toolbar){
        this.mToolbar = toolbar;
    }

    public Toolbar getToolbar(){
        return this.mToolbar;
    }

    public void setTitle(String title){
        TextView text = (TextView) mToolbar.findViewById(R.id.toolbar_top_tv);
        Log.e("TopTitle",title);
        text.setText(title);
    }
}
