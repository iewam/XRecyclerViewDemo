package com.spark.xrecyclerviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;

import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private XRecyclerView xRecyclerView;
    private List<Integer> data =  new ArrayList<Integer>();
    private MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();

        xRecyclerView = (XRecyclerView) findViewById(R.id.xRecyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        xRecyclerView.setLayoutManager(linearLayoutManager);
        View header = LayoutInflater.from(this).inflate(R.layout.header, null);
        xRecyclerView.addHeaderView(header);
        xRecyclerView.setRefreshProgressStyle(ProgressStyle.BallClipRotateMultiple);
        xRecyclerView.setLoadingMoreProgressStyle(ProgressStyle.BallBeat);
        xRecyclerView.setArrowImageView(R.drawable.arrow);
        myAdapter = new MyAdapter(data);
        xRecyclerView.setAdapter(myAdapter);

        xRecyclerView.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                initData();
                myAdapter.notifyDataSetChanged();
                xRecyclerView.refreshComplete();
            }

            @Override
            public void onLoadMore() {
                addData();
                xRecyclerView.loadMoreComplete();
            }
        });


    }


    /**
     *上拉加载添加数据
     */
    private void addData() {
        for (int i=0;i<20;i++){
            Integer r= Integer.valueOf((int) (Math.random()*100));
            data.add(r);
        }
        myAdapter.notifyDataSetChanged();
    }

    /**
     *初始化数据
     */
    private void initData() {
        data.clear();
        for (int i=0;i<40;i++){
            Integer r= Integer.valueOf(i);
            data.add(r);
        }
    }


}
