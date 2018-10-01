package com.kisanhubassignmentapp.view;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.kisanhubassignmentapp.R;
import com.kisanhubassignmentapp.api.response.ArticleResponse;
import com.kisanhubassignmentapp.api.response.Datum;
import com.kisanhubassignmentapp.controller.ArticlesListController;
import com.kisanhubassignmentapp.other.Constants;
import com.kisanhubassignmentapp.view.adapter.ArticleDataAdapter;
import com.kisanhubassignmentapp.view.interfaces.OnTransItemClickListener;

public class ArticleListActivity extends AppCompatActivity implements OnTransItemClickListener {

    RecyclerView rvArticleList;
    ArticlesListController mArticlesListController;
    ArticleDataAdapter mArticleDataAdapter;
    LinearLayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            initializeComponents();
            addEvents();
            mArticlesListController = new ArticlesListController(this);
            mArticlesListController.getArticlesdata();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initializeComponents() throws Exception {
        rvArticleList = findViewById(R.id.rvArticleList);
        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        //llEmptyView = mView.findViewById(R.id.ll_empty_order);
        rvArticleList.setLayoutManager(layoutManager);
        rvArticleList.setItemAnimator(new DefaultItemAnimator());
        DividerItemDecoration itemDecor = new DividerItemDecoration(this, DividerItemDecoration.HORIZONTAL);
        rvArticleList.addItemDecoration(itemDecor);

        mArticleDataAdapter = new ArticleDataAdapter(this, this);
        rvArticleList.setAdapter(mArticleDataAdapter);

    }

    private void addEvents() throws Exception {
    }

    public void setData(ArticleResponse articleResponse) {
        mArticleDataAdapter.removeAll();
        if (articleResponse.getData() != null) {
            mArticleDataAdapter.addAll(articleResponse.getData());
        }
    }

    @Override
    public void onItemClick(Object o, View view) {
        Datum article = (Datum) o;

        Intent intent = new Intent(this, ArticleDetailsActivity.class);
        intent.putExtra(Constants.ARTICLE_DATA, article);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            startActivity(intent, ActivityOptions.makeSceneTransitionAnimation
                    (this, view, "shareView").toBundle());
        } else {
            startActivity(intent);
        }

    }
}
