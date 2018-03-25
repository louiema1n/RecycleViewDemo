package com.example.louiemain.recycleviewdemo.adapter;/**
 * @description
 * @author&date Created by louiemain on 2018/3/25 23:56
 */

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.louiemain.recycleviewdemo.R;
import com.example.louiemain.recycleviewdemo.domain.News;

import java.util.List;

/**
 * @Pragram: RecycleViewDemo
 * @Type: Class
 * @Description: RecyclerViewAdapter
 * @Author: louiemain
 * @Created: 2018/3/25 23:56
 **/
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List<News> newsList;

    public RecyclerViewAdapter(Context context, List<News> newsList) {
        this.context = context;
        this.newsList = newsList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.news_item, parent, false);
        return new NewsHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        NewsHolder newsHolder = (NewsHolder) holder;
        newsHolder.base_swipe_item_icon.setImageResource(R.mipmap.ic_launcher);
        newsHolder.base_swipe_item_title.setText(newsList.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }

    class NewsHolder extends RecyclerView.ViewHolder {

        CardView cardView;
        ImageView base_swipe_item_icon;
        TextView base_swipe_item_title;

        public NewsHolder(View itemView) {
            super(itemView);
            cardView = (CardView) itemView.findViewById(R.id.cardView);
            base_swipe_item_icon = (ImageView) itemView.findViewById(R.id.base_swipe_item_icon);
            base_swipe_item_title = (TextView) itemView.findViewById(R.id.base_swipe_item_title);
        }
    }
}
