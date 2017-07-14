package com.jrm.adolp.animationcustomviewset.animation;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.view.animation.Animation;
import android.view.animation.Transformation;

/**
 * Created by adolp on 2017/7/14.
 */

public class Rotate3DAnimation extends Animation {
    private float mFromDegree;
    private float mToDegree;
    private float mCenterX;
    private float mCenterY;
    private float mDepthZ;
    private boolean isReverse;
    private Camera mCamera;

    public Rotate3DAnimation(float mFromDegree, float mToDegree, float mCenterX, float mCenterY, float mDepthZ , boolean isReverse) {
        this.mFromDegree = mFromDegree;
        this.mToDegree = mToDegree;
        this.mCenterX = mCenterX;
        this.mCenterY = mCenterY;
        this.mDepthZ = mDepthZ;
        this.isReverse = isReverse;
    }

    @Override
    public void initialize(int width, int height, int parentWidth, int parentHeight) {
        super.initialize(width, height, parentWidth, parentHeight);
        this.mCamera = new Camera();
    }

    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {
        final float fromDegree = this.mFromDegree;
        final float degrees = fromDegree + (mToDegree - fromDegree) * interpolatedTime;
        final float centerX = this.mCenterX;
        final float centerY = this.mCenterY;
        final Camera camera = this.mCamera;
        final Matrix matrix = t.getMatrix();
        camera.save();
        if (isReverse){
            camera.translate(0.0f,0.0f,mDepthZ * interpolatedTime);
        }else {
            camera.translate(0.0f,0.0f,mDepthZ * (1 - interpolatedTime));
        }
        camera.rotateX(degrees);
        camera.getMatrix(matrix);
        camera.restore();
        matrix.preTranslate(-centerX,-centerY);
        matrix.postTranslate(centerX,centerY);
    }
}
