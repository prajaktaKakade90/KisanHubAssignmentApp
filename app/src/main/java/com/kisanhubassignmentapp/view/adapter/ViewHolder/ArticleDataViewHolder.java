package com.kisanhubassignmentapp.view.adapter.ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.kisanhubassignmentapp.R;

/**
 * Created by Prajakta on 29-09-2018.
 */


public class ArticleDataViewHolder extends RecyclerView.ViewHolder {
    public TextView tvTitle,tvDescription,tvPublishedOn,tvArticleType;
    public ImageView ivFeaturedImage;

    public ArticleDataViewHolder(View itemView) {
        super(itemView);

        tvTitle = itemView.findViewById(R.id.tv_title);
        tvDescription = itemView.findViewById(R.id.tv_description);
        tvArticleType = itemView.findViewById(R.id.tv_article_type);
        tvPublishedOn = itemView.findViewById(R.id.tv_published_on);
        ivFeaturedImage = itemView.findViewById(R.id.iv_feature_img);
    }
}
