package com.jrm.adolph.animationcustomviewset.view;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jrm.adolph.animationcustomviewset.R;

/**
 * Created by adolp on 2017/7/19.
 */

public class LeftDeleteViewHolder extends RecyclerView.ViewHolder {

    public ImageView itemImage;
    public TextView itemDelete,itemTime,itemContent,itemName;
    public LinearLayout itemLayout;

    public LeftDeleteViewHolder(View itemView) {
        super(itemView);
        itemImage = itemView.findViewById(R.id.item_image);
        itemName = itemView.findViewById(R.id.item_name);
        itemContent = itemView.findViewById(R.id.item_content);
        itemTime = itemView.findViewById(R.id.item_time);

        itemDelete = itemView.findViewById(R.id.btn_delete);
        itemLayout = itemView.findViewById(R.id.item_layout);
    }
}
