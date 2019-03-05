package com.test.asus.myanime;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class AnimeAdapterActivity extends RecyclerView.Adapter<AnimeAdapterActivity.ViewHolder> {
    private Context context;
    private ArrayList<AnimeModelActivity> List;

    public AnimeAdapterActivity(Context context){
        this.context = context;
    }

    public ArrayList<AnimeModelActivity> getAnimList(){
        return List;
    }

    public void setAnimlList(ArrayList<AnimeModelActivity> animList){
        this.List = animList;


    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemRow = LayoutInflater.from(viewGroup.getContext()).
                inflate(R.layout.item_animelist,viewGroup,false);
        return new ViewHolder(itemRow);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        Glide.with(context).load(getAnimList().get(i).getThumbnail()).into(viewHolder.ivThumbail);
        viewHolder.tvTitle.setText(getAnimList().get(i).getTitle());

        viewHolder.btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,AnimeDescriptActivity.class);


                intent.putExtra("img_url", getAnimList().get(i).getThumbnail());
                intent.putExtra("title",getAnimList().get(i).getTitle());
                intent.putExtra("detail",getAnimList().get(i).getDetail());
                context.startActivity(intent);
            }
        });
        viewHolder.btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                String teamName = "Your Character is "+getAnimList().get(i).getTitle();
                intent.putExtra(Intent.EXTRA_TEXT,teamName);
                context.startActivity(Intent.createChooser(intent,"Share Using"));
            }
        });

    }

    @Override
    public int getItemCount() {
        return getAnimList().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivThumbail;
        TextView tvTitle;
        Button btnShow,btnShare;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivThumbail = itemView.findViewById(R.id.team_thumbnail);
            tvTitle = itemView.findViewById(R.id.team_name);
            btnShow = itemView.findViewById(R.id.btn_lihat);
            btnShare = itemView.findViewById(R.id.btn_share);
        }
    }}