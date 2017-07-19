package com.jrm.adolph.animationcustomviewset.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.jrm.adolph.animationcustomviewset.R;
import com.jrm.adolph.animationcustomviewset.data.LeftDeleteBean;
import com.jrm.adolph.animationcustomviewset.view.LeftDeleteViewHolder;

import java.util.List;

/**
 * Created by adolp on 2017/7/19.
 */

public class LeftDeleteAdapter extends RecyclerView.Adapter<LeftDeleteViewHolder> {

    private List<LeftDeleteBean> mList;
    private Context mContext;
    private LayoutInflater inflater;

    public LeftDeleteAdapter(Context context,List<LeftDeleteBean> mList){
        this.mList = mList;
        this.mContext = context;
        inflater = LayoutInflater.from(this.mContext);
    }

    @Override
    public LeftDeleteViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LeftDeleteViewHolder viewHolder = new LeftDeleteViewHolder(inflater.inflate(R.layout.recycler_left_del_item,parent,false));
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(LeftDeleteViewHolder holder, int position) {
        holder.itemImage.setImageResource(mList.get(position).getImageId());
        holder.itemTime.setText(mList.get(position).getTime());
        holder.itemContent.setText(mList.get(position).getContent());
        holder.itemName.setText(mList.get(position).getName());
    }


    @Override
    public int getItemCount() {
        return mList != null ? mList.size() : 0;
    }

    public void removeItem(int position){
        mList.remove(position);
        notifyItemRemoved(position);
    }
}
