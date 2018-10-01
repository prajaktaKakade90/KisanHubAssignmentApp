package com.kisanhubassignmentapp.api.api_service;

import com.kisanhubassignmentapp.api.response.ArticleResponse;

import io.reactivex.Single;
import retrofit2.http.GET;

/**
 * Created by Prajakta on 27-09-2018.
 */

public interface ArticlesApiService {

    @GET("articles/articles.json")
    Single<ArticleResponse> getArticlesData();


}
