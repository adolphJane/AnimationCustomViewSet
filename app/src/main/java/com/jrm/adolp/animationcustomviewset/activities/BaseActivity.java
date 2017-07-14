package com.jrm.adolp.animationcustomviewset.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Toast;

import com.jrm.adolp.animationcustomviewset.R;
import com.jrm.adolp.animationcustomviewset.tools.ToolbarHelper;

import java.util.List;
import java.util.Stack;

/**
 * Created by adolp on 2017/7/13.
 */

public abstract class BaseActivity extends AppCompatActivity implements View.OnClickListener{

//    protected List<Fragment> fragments;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentViewId());
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        if (toolbar != null){
            setSupportActionBar(toolbar);
            getSupportActionBar().setDisplayShowTitleEnabled(false);
            handleToolbar(new ToolbarHelper(toolbar));
        }

        initView();
        initData();
        initListener();

    }

    protected abstract void initView();

    protected abstract void initData();

    protected abstract void initListener();

//    protected void initFragment(){
//        fragments = new Stack<>();
//    }
//
//    protected void addFragment(Fragment fragment){
//        fragments.add(fragment);
//    }
//
//    protected void removeFragment(Fragment fragment){
//        fragments.remove(fragment);
//    }
//
//    protected void removeTopFragment(){
//        fragments.pop();
//    }
//
//    protected void clearFragments(){
//        for (Fragment fragment : fragments){
//            fragment.onDestroy();
//            fragments.pop();
//        }
//        fragments.clear();
//    }

    /**
     * 设置全屏
     */
    private void setBase() {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
    }

    /**
     * 处理Toolbar
     * @param helper
     */
    public void handleToolbar(ToolbarHelper helper){
    }

    protected abstract int getContentViewId();

    /**
     * 页面跳转
     * @param targetActivityClass
     * @param bundle
     */
    protected void openActivity(Class<?> targetActivityClass, Bundle bundle){
        Intent intent = new Intent(this,targetActivityClass);
        if (bundle != null){
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }

    protected void openActivity(Class<?> targetActivityClass){
        openActivity(targetActivityClass,null);
    }

    /**
     * 跳转下一页面，并且关闭当前页面
     * @param targetActivityClass
     */
    protected void openActivityAndCloseThis(Class<?> targetActivityClass){
        openActivity(targetActivityClass,null);
        this.finish();
    }

    /**
     * 展示短Toast
     * @param toastText
     */
    protected void showShortToast(String toastText){
        Toast.makeText(this,toastText,Toast.LENGTH_SHORT).show();
    }

    /**
     * 展示长Toast
     * @param toastText
     */
    protected void showLongToast(String toastText){
        Toast.makeText(this,toastText,Toast.LENGTH_LONG).show();
    }
}
