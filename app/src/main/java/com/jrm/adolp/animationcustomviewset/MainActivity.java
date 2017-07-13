package com.jrm.adolp.animationcustomviewset;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.jrm.adolp.animationcustomviewset.tools.ToolbarHelper;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void handleToolbar(ToolbarHelper helper) {
        super.handleToolbar(helper);
        helper.setTitle("Animation&CustomViewSet");
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
