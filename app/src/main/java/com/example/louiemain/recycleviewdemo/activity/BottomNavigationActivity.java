package com.example.louiemain.recycleviewdemo.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.example.louiemain.recycleviewdemo.R;
import com.example.louiemain.recycleviewdemo.base.BaseAppCompatActivity;
import com.example.louiemain.recycleviewdemo.base.BasePager;
import com.example.louiemain.recycleviewdemo.pager.ExamPager;
import com.example.louiemain.recycleviewdemo.pager.MinePager;
import com.example.louiemain.recycleviewdemo.pager.NoSlidingViewPager;
import com.example.louiemain.recycleviewdemo.pager.PracticePager;

import java.util.ArrayList;
import java.util.List;

public class BottomNavigationActivity extends BaseAppCompatActivity {

    private List<Fragment> basePagers;

    private NoSlidingViewPager vp_container;
    private BottomNavigationView navigation;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    vp_container.setCurrentItem(0, false);
                    return true;
                case R.id.navigation_dashboard:
                    vp_container.setCurrentItem(1, false);
                    return true;
                case R.id.navigation_notifications:
                    vp_container.setCurrentItem(2, false);
                    return true;
            }
            return false;
        }

    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.layout_view_pager);

        vp_container = (NoSlidingViewPager) findViewById(R.id.vp_container);

        basePagers = new ArrayList<>();
        basePagers.add(new ReplaceFragment(new PracticePager(this)));
        basePagers.add(new ReplaceFragment(new ExamPager(this)));
        basePagers.add(new ReplaceFragment(new MinePager(this)));

        FragmentPagerAdapter adapter = new FragmentPagerAdapter(getSupportFragmentManager()) {

            @Override
            public int getCount() {
                return basePagers.size();
            }

            @Override
            public Fragment getItem(int position) {
                return basePagers.get(position);
            }
        };

        vp_container.setAdapter(adapter);
        vp_container.setOffscreenPageLimit(2);  // 预加载

        // 设置BottomNavigation的点击事件
        navigation = (BottomNavigationView) findViewById(R.id.nv);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        // 设置viewpager的pageChange事件
        vp_container.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        Toast.makeText(BottomNavigationActivity.this, "您滑动到了" + position, Toast.LENGTH_SHORT).show();
//                        vp_container.setCurrentItem(0);
                        navigation.setSelectedItemId(R.id.navigation_home);
                        break;
                    case 1:
                        Toast.makeText(BottomNavigationActivity.this, "您滑动到了" + position, Toast.LENGTH_SHORT).show();
//                        vp_container.setCurrentItem(0);
                        navigation.setSelectedItemId(R.id.navigation_dashboard);
                        break;
                    case 2:
                        Toast.makeText(BottomNavigationActivity.this, "您滑动到了" + position, Toast.LENGTH_SHORT).show();
//                        vp_container.setCurrentItem(0);
                        navigation.setSelectedItemId(R.id.navigation_notifications);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public int getLayoutId() {
        return R.layout.layout_view_pager;
    }

    static class ReplaceFragment extends Fragment {

        private BasePager basePager;

        public ReplaceFragment(BasePager basePager) {
            this.basePager = basePager;
        }

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            if (basePager != null && !basePager.isInitData) {
                basePager.initData();
                basePager.isInitData = true;
                return basePager.rootView;
            }
            return null;
        }
    }

}
