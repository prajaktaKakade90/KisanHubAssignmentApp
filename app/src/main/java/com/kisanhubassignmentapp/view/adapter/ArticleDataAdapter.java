package com.kisanhubassignmentapp.view.adapter;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.bumptech.glide.Glide;
import com.kisanhubassignmentapp.R;
import com.kisanhubassignmentapp.api.response.Datum;
import com.kisanhubassignmentapp.other.Constants;
import com.kisanhubassignmentapp.utils.DateUtils;
import com.kisanhubassignmentapp.view.adapter.ViewHolder.ArticleDataViewHolder;
import com.kisanhubassignmentapp.view.interfaces.OnTransItemClickListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Prajakta on 29-09-2018.
 */

public class ArticleDataAdapter extends RecyclerView.Adapter<ArticleDataViewHolder> {

    final static String TAG = ArticleDataAdapter.class.getName();
    Context mContext;
    List<Datum> articleData;
    OnTransItemClickListener mListener;


    public ArticleDataAdapter(Context context, OnTransItemClickListener onTransItemClickListener) {
        mContext = context;
        articleData = new ArrayList<>();
        mListener = onTransItemClickListener;
    }

    @NonNull
    @Override
    public ArticleDataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.article_data_item_layout, parent, false);
        final ArticleDataViewHolder mViewHolder = new ArticleDataViewHolder(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    mListener.onItemClick(articleData
                            .get(mViewHolder.getAdapterPosition()), null);

                } catch (Exception e) {
                    Log.e(TAG, e.toString());
                }

            }
        });
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ArticleDataViewHolder holder, int position) {
        final Datum article = articleData.get(position);

        Animation animation = AnimationUtils.loadAnimation(mContext, R.anim.anim_recycler_item_show);
        holder.itemView.startAnimation(animation);

        holder.tvTitle.setText(article.getTitle());
        holder.tvDescription.setText(article.getDescription());
        holder.tvArticleType.setText(article.getGetArticleTypeDisplay());
        holder.tvPublishedOn.setText(mContext.getResources().getString(R.string.str_published_on) + " " + DateUtils.getDateInFormat(Constants.DISPLAY_DATE_TIME_FORMAT, article.getPublishDate()));

        if (article.getFeaturedImage() != null && article.getFeaturedImage().size() > 0) {
            Glide.with(mContext)
                    .load(article.getFeaturedImage().get(0).getImageFile())
                    .into(holder.ivFeaturedImage);
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.onItemClick(article,holder.ivFeaturedImage);
            }
        });
    }

    @Override
    public int getItemCount() {
        return articleData.size();
    }

    public void add(Datum r) {
        articleData.add(r);
        notifyItemInserted(articleData.size() - 1);
    }

    public void addAll(List<Datum> historyListDTOS) {
        for (Datum result : historyListDTOS) {
            add(result);
        }
    }

    public void removeAll() {
        articleData.clear();
        notifyDataSetChanged();
    }


    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

}
