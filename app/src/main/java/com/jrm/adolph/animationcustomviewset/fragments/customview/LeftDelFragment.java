package com.jrm.adolph.animationcustomviewset.fragments.customview;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.Toast;

import com.jrm.adolph.animationcustomviewset.R;
import com.jrm.adolph.animationcustomviewset.adapter.LeftDeleteAdapter;
import com.jrm.adolph.animationcustomviewset.data.LeftDeleteBean;
import com.jrm.adolph.animationcustomviewset.fragments.BaseFragment;
import com.jrm.adolph.animationcustomviewset.listener.LeftDeleteOnItemClickListener;
import com.jrm.adolph.animationcustomviewset.view.LeftDeleteRecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by adolp on 2017/7/19.
 */

public class LeftDelFragment extends BaseFragment {

    private LeftDeleteRecyclerView recyclerView;
    private LeftDeleteAdapter adapter;
    private List<LeftDeleteBean> mList;

    @Override
    protected void initListener() {
        recyclerView.setOnItemClickListener(new LeftDeleteOnItemClickListener() {
            @Override
            public void onDeleteClick(int position) {
                adapter.removeItem(position);
            }

            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(getActivity(),"This is "+position+"!!!!",Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_left_delete_recyclerview;
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        recyclerView = view.findViewById(R.id.left_delete_recycle);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    @Override
    protected void initData() {
        mList = new ArrayList<>();
        setJavaBean();
        adapter = new LeftDeleteAdapter(getActivity(),mList);
        recyclerView.setAdapter(adapter);
    }

    private void setJavaBean(){
        LeftDeleteBean bean = new LeftDeleteBean(R.drawable.girl,"Adolph","Hello!!!!","12:50");
        LeftDeleteBean bean1 = new LeftDeleteBean(R.drawable.threed_1,"Magical","Hi!!!!","11:50");
        LeftDeleteBean bean2 = new LeftDeleteBean(R.drawable.threed_2,"Rice","ByBy!!!!","15:50");
        LeftDeleteBean bean3 = new LeftDeleteBean(R.drawable.threed_3,"KoZo","How are you!!!!","16:50");
        mList.add(bean);
        mList.add(bean1);
        mList.add(bean2);
        mList.add(bean3);
    }

    @Override
    public void onClick(View view) {

    }
}
