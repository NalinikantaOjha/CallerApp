package com.example.callerapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<viewHolder> {
    private ArrayList<view> studentList;
    private itemClickListner itemClickListner;
    public  Adapter(ArrayList<view>studentList,itemClickListner itemClickedListner){
        this.studentList=studentList;
        this.itemClickListner=itemClickedListner;

    }
    @NonNull

    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.itemlayout,parent,false);
        return new viewHolder(view ,itemClickListner);
    }


    @Override
    public void onBindViewHolder(@NonNull  viewHolder holder, int position) {
        view view =studentList.get(position);
        holder.setData(view);
    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }
}
