package com.jrm.adolph.animationcustomviewset.fragments.animation;

import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.jrm.adolph.animationcustomviewset.R;
import com.jrm.adolph.animationcustomviewset.animation.Rotate3DAnimation;
import com.jrm.adolph.animationcustomviewset.fragments.BaseFragment;

/**
 * Created by adolp on 2017/7/14.
 */

public class Rotate3DFragment extends BaseFragment {

    private Button btnRotate;
    private EditText edRotateStart,edRotateEnd;
    private ImageView imgRotate;

    @Override
    protected void initListener() {
        btnRotate.setOnClickListener(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_rotate3d;
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        btnRotate = view.findViewById(R.id.rotate3d_btn);
        edRotateStart = view.findViewById(R.id.rotate3d_start_ed);
        edRotateEnd = view.findViewById(R.id.rotate3d_end_ed);
        imgRotate = view.findViewById(R.id.rotate3d_img);
    }

    @Override
    protected void initData() {
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.rotate3d_btn:
                float rotateStart = Float.parseFloat(edRotateStart.getText().toString());
                float rotateEnd = Float.parseFloat(edRotateEnd.getText().toString());
                Rotate3DAnimation animation = (Rotate3DAnimation) applyRotation(rotateStart,rotateEnd);
                imgRotate.startAnimation(animation);
                break;
        }
    }

    private Animation applyRotation(float start, float end){
        final float centerX = imgRotate.getWidth() / 2.0f;
        final float centerY = 0;
        Rotate3DAnimation animation = new Rotate3DAnimation(start,end,centerX,centerY,310f, false);
        animation.setDuration(500);
        animation.setFillAfter(true);
        animation.setInterpolator(new AccelerateInterpolator());
        return animation;
    }
}
