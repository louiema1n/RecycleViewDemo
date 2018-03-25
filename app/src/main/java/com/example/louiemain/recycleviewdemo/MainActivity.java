package com.example.louiemain.recycleviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.example.louiemain.recycleviewdemo.adapter.RecyclerViewAdapter;
import com.example.louiemain.recycleviewdemo.domain.News;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<News> newsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recycleView);

        // 使用layoutmanager
        LinearLayoutManager manager = new LinearLayoutManager(this);
        
        // initData
        initData();

        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, newsList);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);

    }

    private void initData() {
        newsList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            newsList.add(new News("测试新闻" + i));
        }
    }
}
