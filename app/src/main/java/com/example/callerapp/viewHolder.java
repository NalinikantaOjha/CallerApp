package com.example.callerapp;


import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class viewHolder extends RecyclerView.ViewHolder {
    private TextView mTvName;
    private LinearLayout linearLayout;

    private itemClickListner itemClickedListner;

    public viewHolder(@NonNull View itemView, itemClickListner itemClickedListner) {
        super(itemView);

        iniViwes(itemView);
        this.itemClickedListner=itemClickedListner;
    }



    private void iniViwes(View itemView) {
        mTvName=itemView.findViewById(R.id.tvName);
        linearLayout=itemView.findViewById(R.id.layout1);

    }
    public void setData(view student){
        mTvName.setText(student.getName());
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClickedListner.onItemClicked(student ,getAdapterPosition());

            }
        });

    }
}


