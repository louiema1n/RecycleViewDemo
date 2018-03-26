package com.example.louiemain.recycleviewdemo.pager;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;

/**
 * @Program: RecycleViewDemo
 * @Type: Class
 * @Description: 屏蔽滑动的Viewpager
 * @Author: louiemain
 * @Created: 2018-03-26 16:17
 **/
public class NoSlidingViewPager extends ViewPager {
    public NoSlidingViewPager(Context context) {
        super(context);
    }

    public NoSlidingViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
}
