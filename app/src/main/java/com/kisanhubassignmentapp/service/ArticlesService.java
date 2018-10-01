package com.kisanhubassignmentapp.service;

import com.kisanhubassignmentapp.api.ApiServiceGenerator;
import com.kisanhubassignmentapp.api.APICallback;
import com.kisanhubassignmentapp.api.APIError;
import com.kisanhubassignmentapp.api.ErrorUtils;
import com.kisanhubassignmentapp.api.api_service.ArticlesApiService;
import com.kisanhubassignmentapp.api.response.ArticleResponse;
import com.kisanhubassignmentapp.other.Initial;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Prajakta on 27-09-2018.
 */

public class ArticlesService {
    ArticlesApiService mArticlesApiService;

    public ArticlesService() {
        mArticlesApiService = ApiServiceGenerator.createService(ArticlesApiService.class, Initial.getInstance());
    }

    public void getArticlesData(final APICallback apiCallback) {
        try {
            mArticlesApiService.getArticlesData().subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeWith(new DisposableSingleObserver<ArticleResponse>() {
                        @Override
                        public void onSuccess(ArticleResponse s) {
                            try {
                                apiCallback.onSuccess(s);
                            } catch (Exception ex) {
                                ex.printStackTrace();
                            }
                        }

                        @Override
                        public void onError(Throwable e) {
                            APIError apiResponse = ErrorUtils.parseThrowable(e);
                            apiCallback.onError(apiResponse);
                        }
                    });

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
