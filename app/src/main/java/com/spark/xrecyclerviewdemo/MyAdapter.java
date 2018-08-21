package com.spark.xrecyclerviewdemo;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter <MyAdapter.MyViewHodler> {

    private List<Integer> data = new ArrayList<Integer>();

    public MyAdapter(List<Integer> data) {
        this.data = data;
    }

    @Override
    public MyViewHodler onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, null);
        MyViewHodler myViewHodler = new MyViewHodler(view);
        return myViewHodler;
    }

    @Override
    public void onBindViewHolder(MyViewHodler holder, int position) {
        holder.itemTv.setText("item" + data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    public static class MyViewHodler extends RecyclerView.ViewHolder {

        private TextView itemTv;
        public MyViewHodler(View itemView) {
            super(itemView);
            this.itemTv = itemView.findViewById(R.id.itemTv);
        }
    }

}
