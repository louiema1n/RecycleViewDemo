package com.example.louiemain.recycleviewdemo.adapter;
/**
 * @description
 * @author&date Created by louiemain on 2018/3/25 22:22
 */

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.louiemain.recycleviewdemo.MainActivity;
import com.example.louiemain.recycleviewdemo.R;
import com.example.louiemain.recycleviewdemo.domain.News;

import java.util.List;

/**
 * @Pragram: RecycleViewDemo
 * @Type: Class
 * @Description: RecycleView数据适配器
 * 注意泛型参数必须继承RecyclerView.ViewHolder
 * @Author: louiemain
 * @Created: 2018/3/25 22:22
 **/
public class NewsListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int NORMAL_ITEM = 0;
    private static final int GROUP_ITEM = 1;
    private MainActivity context;
    private List<News> newsList;
    private LayoutInflater layoutInflater;

    public NewsListAdapter(MainActivity context, List<News> newsList) {
        this.context = context;
        this.newsList = newsList;
        this.layoutInflater = LayoutInflater.from(context);
    }

    /**
     * @param parent   ViewHolder容器
     * @param viewType 布局类型
     * @return android.support.v7.widget.RecyclerView.ViewHolder
     * @description 渲染具体的ViewHolder
     * @author louiemain
     * @date Created on 2018/3/25 22:43
     */
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == NORMAL_ITEM) {
            return new NormalItemHolder(layoutInflater.inflate(R.layout.fragment_base_swipe_item, parent, false));
        }
        return new GroupItemHolder(layoutInflater.inflate(R.layout.fragment_base_swipe_group_item, parent, false));

    }

    /**
     * @param holder   具体的viewholder
     * @param position 数据源List index
     * @return void
     * @description 绑定ViewHolder数据
     * @author louiemain
     * @date Created on 2018/3/25 22:44
     */
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        News news = newsList.get(position);
        if (holder instanceof NormalItemHolder) {
            // 如果绑定的是无日期的
            NormalItemHolder normalItemHolder = (NormalItemHolder) holder;
            bindNormalItem(news, normalItemHolder.newsTitle, normalItemHolder.newsIcon);
        } else {
            // 绑定的是带日期的
            bindGroupItem(news, (GroupItemHolder) holder);
        }
    }

    /**
     * @description 绑定带日期的item
     * @author louiemain
     * @date Created on 2018/3/25 23:35
     * @param news
     * @param holder
     * @return void
     */
    private void bindGroupItem(News news, GroupItemHolder holder) {
    }

    /**
     * @description 绑定无日期的item
     * @author louiemain
     * @date Created on 2018/3/25 23:35
     * @param news
     * @param newsTitle
     * @param newsIcon
     * @return void
     */
    private void bindNormalItem(News news, TextView newsTitle, ImageView newsIcon) {
    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }

    /**
     * @param position 数据源List的index
     * @return int 返回一个int标志，传递给onCreateViewHolder的viewType
     * @description 决定元素的布局使用哪种类型
     * @author louiemain
     * @date Created on 2018/3/25 22:42
     */
    @Override
    public int getItemViewType(int position) {
        // 第一个要显示日期
        if (position == 0) {
            return GROUP_ITEM;
        }
        return super.getItemViewType(position);
    }

    /**
     * 不带日期的新闻item
     */
    public class NormalItemHolder extends RecyclerView.ViewHolder {

        TextView newsTitle;
        ImageView newsIcon;

        public NormalItemHolder(View itemView) {
            super(itemView);
            newsTitle = (TextView) itemView.findViewById(R.id.base_swipe_item_title);
            newsIcon = (ImageView) itemView.findViewById(R.id.base_swipe_item_icon);
            itemView.findViewById(R.id.base_swipe_item_container).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
        }
    }

    /**
     * 带时间的新闻item
     */
    public class GroupItemHolder extends NormalItemHolder {

        TextView newsTime;

        public GroupItemHolder(View itemView) {
            super(itemView);
            newsTime = (TextView) itemView.findViewById(R.id.base_swipe_group_item_time);
        }
    }
}
