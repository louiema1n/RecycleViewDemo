package com.example.louiemain.recycleviewdemo.activity;

import android.os.Bundle;
import com.example.louiemain.recycleviewdemo.R;
import com.example.louiemain.recycleviewdemo.base.BaseAppCompatActivity;

public class TestActivity extends BaseAppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView();
        getToolbarTitle().setText("测试标题");
        getToolbarSubTitle().setText("测试副标题");
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_test;
    }
}
