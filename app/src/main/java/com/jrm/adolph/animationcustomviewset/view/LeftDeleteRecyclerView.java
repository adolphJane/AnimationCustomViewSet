package com.jrm.adolph.animationcustomviewset.view;


import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Scroller;
import android.widget.TextView;

import com.jrm.adolph.animationcustomviewset.listener.LeftDeleteOnItemClickListener;

/**
 * Created by adolp on 2017/7/19.
 */

public class LeftDeleteRecyclerView extends RecyclerView{

    private Context mContext;

    private LinearLayout mItemLayout;
    private TextView mItemDelete;

    private int mMaxBtnSize;
    private int mDelBtnState;
    private int mPosition;
    private int mLastX;
    private int mLastY;
    private boolean isItemMoving;
    private boolean isStartScroll;

    private VelocityTracker mVelocityTracker;
    private Scroller mScroller;

    private LeftDeleteOnItemClickListener mListener;

    public LeftDeleteRecyclerView(Context context) {
        this(context,null);
    }

    public LeftDeleteRecyclerView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public LeftDeleteRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        mContext = context;
        mScroller = new Scroller(mContext,new LinearInterpolator());
        mVelocityTracker = VelocityTracker.obtain();
    }

    @Override
    public boolean onTouchEvent(MotionEvent e) {
        mVelocityTracker.addMovement(e);

        int x = (int) e.getX();
        int y = (int) e.getY();

        switch (e.getAction()){
            case MotionEvent.ACTION_DOWN:
                if (mDelBtnState == 0){
                    View view = findChildViewUnder(x,y);
                    if (view == null){
                        return false;
                    }
                    LeftDeleteViewHolder viewHolder = (LeftDeleteViewHolder) getChildViewHolder(view);
                    mItemLayout = viewHolder.itemLayout;
                    mItemDelete = viewHolder.itemDelete;
                    mMaxBtnSize = mItemDelete.getWidth();
                    mPosition = viewHolder.getAdapterPosition();

                    mItemDelete.setOnClickListener(new OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            mListener.onDeleteClick(mPosition);
                            mItemLayout.scrollTo(0,0);
                            mDelBtnState = 0;
                        }
                    });
                }else if (mDelBtnState == 3){
                    mScroller.startScroll(mItemLayout.getScrollX(),0,-mMaxBtnSize,0,200);
                    invalidate();
                    mDelBtnState = 0;
                    return false;
                }else {
                    return false;
                }
                break;
            case MotionEvent.ACTION_MOVE:
                int dx = mLastX - x;
                int dy = mLastY - y;

                int scrollX = mItemLayout.getScrollX();
                if (Math.abs(dx) > Math.abs(dy)){
                    isItemMoving = true;
                    if (scrollX + dx < 0){
                        mItemLayout.scrollTo(0,0);
                        return true;
                    }else if (scrollX + dx >= mMaxBtnSize){
                        mItemLayout.scrollTo(mMaxBtnSize,0);
                        return true;
                    }
                    mItemLayout.scrollBy(dx,0);
                }
                break;
            case MotionEvent.ACTION_UP:
                if (!isItemMoving && mListener != null){
                    mListener.onItemClick(mItemLayout,mPosition);
                }
                isItemMoving = false;
                mVelocityTracker.computeCurrentVelocity(1000);
                float xVelocity = mVelocityTracker.getXVelocity();
                float yVelocity = mVelocityTracker.getYVelocity();

                int deltaX = 0;             //距离完全显示删除按钮X轴上所相差的距离,或完全隐藏按钮的距离
                int upScrollX = mItemLayout.getScrollX();
                if (Math.abs(xVelocity) > 100 && Math.abs(xVelocity) > Math.abs(yVelocity)){
                    if (xVelocity <= -100){
                        deltaX = mMaxBtnSize - upScrollX;
                        mDelBtnState = 2;
                    }else if (xVelocity >= 100){
                        deltaX = -upScrollX;
                        mDelBtnState = 1;
                    }
                }else {
                    if (upScrollX <= mMaxBtnSize / 2){
                        deltaX = mMaxBtnSize - upScrollX;
                        mDelBtnState = 2;
                    }else if (upScrollX >= mMaxBtnSize / 2){
                        deltaX = -upScrollX;
                        mDelBtnState = 1;
                    }
                }

                mScroller.startScroll(upScrollX,0,deltaX,0,200);

                isStartScroll = true;
                invalidate();
                mVelocityTracker.clear();

                break;
        }

        mLastX = x;
        mLastY = y;
        return super.onTouchEvent(e);
    }

    @Override
    public void computeScroll() {
        if (mScroller.computeScrollOffset()){
            mItemLayout.scrollTo(mScroller.getCurrX(),mScroller.getCurrY());
            postInvalidate();
        }else if (isStartScroll){
            isStartScroll = false;
            if (mDelBtnState == 1){
                mDelBtnState = 0;
            }else if (mDelBtnState == 2){
                mDelBtnState = 3;
            }
        }
    }

    @Override
    protected void onDetachedFromWindow() {
        mVelocityTracker.recycle();
        super.onDetachedFromWindow();
    }

    public void setOnItemClickListener(LeftDeleteOnItemClickListener listener){
        this.mListener = listener;
    }
}
