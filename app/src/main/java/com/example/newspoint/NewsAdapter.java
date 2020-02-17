package com.example.newspoint;

import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsHolder> {
    private ArrayList<News> dataset;
    private AdapterView.OnItemClickListener onItemClickListener;

    public NewsAdapter(ArrayList<News> dataset, AdapterView.OnItemClickListener onItemClickListener) {
        this.dataset = dataset;
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public NewsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout_news, parent, false);
        return new NewsHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsHolder holder, int position) {

        Picasso.get().load(dataset.get(position).getImage()).into(holder.ivNewsImage);
        holder.tvNewsTitle.setText(dataset.get(position).getTitle());
        holder.tvNewsDetail.setText(dataset.get(position).getDetail());
        holder.tvPublishDate.setText(dataset.get(position).getPublishDate());
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public class NewsHolder extends RecyclerView.ViewHolder {
        ImageView ivNewsImage;
        TextView tvNewsTitle;
        TextView tvNewsDetail;
        TextView tvPublishDate;




        public NewsHolder(@NonNull View itemView) {
            super(itemView);

            ivNewsImage = itemView.findViewById(R.id.ivNewsImage);
            tvNewsTitle = itemView.findViewById(R.id.tvNewsTitle);
            tvNewsDetail = itemView.findViewById(R.id.tvNewsDetail);
            tvPublishDate = itemView.findViewById(R.id.tvPublishDate);

        }
    }

}