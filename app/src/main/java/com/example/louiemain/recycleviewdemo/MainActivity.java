package com.example.louiemain.recycleviewdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import com.example.louiemain.recycleviewdemo.activity.BottomNavigationActivity;
import com.example.louiemain.recycleviewdemo.adapter.RecyclerViewAdapter;
import com.example.louiemain.recycleviewdemo.base.BaseAppCompatActivity;
import com.example.louiemain.recycleviewdemo.base.BasePager;
import com.example.louiemain.recycleviewdemo.domain.News;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseAppCompatActivity {

    private RecyclerView recyclerView;
    private List<News> newsList;
    private Button test;

    private List<BasePager> basePagers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        getToolbarTitle().setText("主页");
        getToolbarSubTitle().setText("测试");

        recyclerView = (RecyclerView) findViewById(R.id.recycleView);
        test = (Button) findViewById(R.id.test);
        test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, BottomNavigationActivity.class);
                startActivity(intent);
            }
        });

        // 使用layoutmanager
        LinearLayoutManager manager = new LinearLayoutManager(this);

        // initData
        initData();

        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, newsList);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public boolean isShowBacking() {
        return false;
    }

    private void initData() {
        newsList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            newsList.add(new News("测试新闻" + i));
        }
    }
}
