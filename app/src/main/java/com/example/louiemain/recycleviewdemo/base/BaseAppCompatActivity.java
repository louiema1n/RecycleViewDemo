package com.example.louiemain.recycleviewdemo.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.example.louiemain.recycleviewdemo.R;

/**
 * @Program: RecycleViewDemo
 * @Type: Class
 * @Description: AppCompatActivity公共类
 * @Author: louiemain
 * @Created: 2018-03-26 09:46
 **/
public abstract class BaseAppCompatActivity extends AppCompatActivity {

    private Toolbar tl_base_toolbar;
    private TextView tv_title;
    private TextView tv_sub_title;
    private boolean isShowBacking;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());

        initView();
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (tl_base_toolbar != null && isShowBacking()) {
            // 开启后退按钮
//            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            tl_base_toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        }
        getSupportActionBar().setDisplayShowTitleEnabled(false);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
        }
        return super.onOptionsItemSelected(item);
    }

    private void initView() {
        tl_base_toolbar = (Toolbar) findViewById(R.id.tl_base_toolbar);
        tv_title = (TextView) findViewById(R.id.tv_title);
        tv_sub_title = (TextView) findViewById(R.id.tv_sub_title);

        if (tl_base_toolbar != null) {
            // 显示到界面
            setSupportActionBar(tl_base_toolbar);
        }
        if (tv_title != null) {
            // 设置title
            //getTitle()的值是activity的android:lable属性值
            tv_title.setText(getTitle());
            // 不显示默认Title
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }
    }

    public TextView getToolbarTitle() {
        return this.tv_title;
    }

    public TextView getToolbarSubTitle() {
        return this.tv_sub_title;
    }


    /**
     * @param
     * @Description: 获取布局id-需子类重写该方法
     * @Author: louiemain
     * @Date: 2018-03-26 9:49
     * @return: int
     */
    public abstract int getLayoutId();

    /**
     * 是否显示后退按钮，默认显示
     *
     * @return
     */
    public boolean isShowBacking() {
        return true;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
