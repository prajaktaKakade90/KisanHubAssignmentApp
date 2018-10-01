package com.kisanhubassignmentapp.controller;

import android.util.Log;

import com.kisanhubassignmentapp.api.APICallback;
import com.kisanhubassignmentapp.api.response.ArticleResponse;
import com.kisanhubassignmentapp.service.ArticlesService;
import com.kisanhubassignmentapp.view.ArticleListActivity;

/**
 * Created by Prajakta on 27-09-2018.
 */

public class ArticlesListController {

    ArticleListActivity mArticleListActivity;
    ArticlesService mArticlesService;

    public ArticlesListController(ArticleListActivity articleListActivity) {
        this.mArticleListActivity = articleListActivity;
        // service initialization..
        mArticlesService = new ArticlesService();
    }


    public void getArticlesdata() {

        mArticlesService.getArticlesData(new APICallback() {
            @Override
            public <T> void onSuccess(T serviceResponse) {
                mArticleListActivity.setData((ArticleResponse) serviceResponse);
            }

            @Override
            public <T> void onError(T apiErrorModel) {

            }

            @Override
            public <T> void onFailure(T apiErrorModel) {

            }
        });
    }
}
