package com.jrm.adolph.animationcustomviewset.activities;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.jrm.adolph.animationcustomviewset.R;
import com.jrm.adolph.animationcustomviewset.adapter.LeftDeleteAdapter;
import com.jrm.adolph.animationcustomviewset.data.LeftDeleteBean;
import com.jrm.adolph.animationcustomviewset.listener.LeftDeleteOnItemClickListener;
import com.jrm.adolph.animationcustomviewset.tools.ToolbarHelper;
import com.jrm.adolph.animationcustomviewset.view.LeftDeleteRecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by adolp on 2017/7/19.
 */

public class TestViewActivity extends BaseActivity {

    private LeftDeleteRecyclerView recyclerView;
    private List<LeftDeleteBean> mList;
    private LeftDeleteAdapter adapter;
    @Override
    protected void initView() {
        recyclerView = (LeftDeleteRecyclerView) findViewById(R.id.ry_left_delete);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected void initData() {
        mList = new ArrayList<>();
        LeftDeleteBean bean = new LeftDeleteBean(R.drawable.girl,"Adolph","Hello!!!!","12:50");
        LeftDeleteBean bean1 = new LeftDeleteBean(R.drawable.threed_1,"Magical","Hi!!!!","11:50");
        LeftDeleteBean bean2 = new LeftDeleteBean(R.drawable.threed_2,"Rice","ByBy!!!!","15:50");
        LeftDeleteBean bean3 = new LeftDeleteBean(R.drawable.threed_3,"KoZo","How are you!!!!","16:50");
        mList.add(bean);
        mList.add(bean1);
        mList.add(bean2);
        mList.add(bean3);
        adapter = new LeftDeleteAdapter(this,mList);
    }

    @Override
    protected void initListener() {
        recyclerView.setOnItemClickListener(new LeftDeleteOnItemClickListener() {
            @Override
            public void onDeleteClick(int position) {
                adapter.removeItem(position);
            }

            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(TestViewActivity.this,"This is " + position + "!!!",Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void handleToolbar(ToolbarHelper helper) {
        super.handleToolbar(helper);
        helper.setTitle("Test View");
    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_test_layout;
    }

    @Override
    public void onClick(View view) {

    }
}
