package com.example.newspoint;

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

public class News2Adapter extends RecyclerView.Adapter<News2Adapter.News2Holder> {
private ArrayList<News2> dataset;
private AdapterView.OnItemClickListener onItemClickListener;

    public News2Adapter(ArrayList<News2> dataset, AdapterView.OnItemClickListener onItemClickListener) {
        this.dataset = dataset;
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public News2Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout_news2,parent,false);

        return new News2Holder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull News2Holder holder, int position) {

        Picasso.get().load(dataset.get(position).getImage()).into(holder.ivNews2Image);
        holder.tvNews2Title.setText(dataset.get(position).getTitle());
        holder.tvNews2Detail.setText(dataset.get(position).getDetail());
        holder.tvPublishDate2.setText(dataset.get(position).getPublishDate());

    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public class News2Holder extends RecyclerView.ViewHolder{

   ImageView ivNews2Image;
   TextView tvNews2Title;
   TextView tvNews2Detail;
   TextView tvPublishDate2;

        public News2Holder(@NonNull View itemView) {
            super(itemView);
            ivNews2Image=itemView.findViewById(R.id.ivNews2Image);
            tvNews2Title=itemView.findViewById(R.id.tvNews2Title);
            tvNews2Detail=itemView.findViewById(R.id.tvNews2Detail);
            tvPublishDate2=itemView.findViewById(R.id.tvPublishDate2);

        }
    }
}
