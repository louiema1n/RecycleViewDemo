package com.example.louiemain.recycleviewdemo.pager;

import android.content.Context;
import android.view.View;
import com.example.louiemain.recycleviewdemo.R;
import com.example.louiemain.recycleviewdemo.base.BasePager;

/**
 * @author & date Created by ${user} on ${date} ${time}
 * /**
 * @description
 * @Program: PrimaryPathological
 * @Type: Class
 * @Description: 练习页面
 * @Author: louiemain
 * @Created: 2018-03-19 11:15
 **/
public class PracticePager extends BasePager {

    public PracticePager(Context context) {
        super(context);
    }

    @Override
    public View initView() {
        View view = View.inflate(context, R.layout.layout_practice, null);
        // 初始化组件
        return view;
    }

    @Override
    public void initData() {
        super.initData();
    }
}
