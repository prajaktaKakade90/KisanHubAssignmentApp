package com.kisanhubassignmentapp.view;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.kisanhubassignmentapp.R;
import com.kisanhubassignmentapp.api.response.Author;
import com.kisanhubassignmentapp.api.response.Datum;
import com.kisanhubassignmentapp.other.Constants;
import com.kisanhubassignmentapp.utils.DateUtils;

public class ArticleDetailsActivity extends AppCompatActivity {

    Datum articleData;
    ImageView ivFeaturedImage;
    TextView tvTitle, tvDescription, tvStatus, tvPublishedOn, tvAuther;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article_details);

        if (getIntent().getExtras() != null) {
            articleData = (Datum) getIntent().getExtras().getSerializable(Constants.ARTICLE_DATA);
            intViews();
            setData();
        } else {
            finish();
        }
    }

    private void intViews() {
        ivFeaturedImage = findViewById(R.id.iv_featured_image);
        tvTitle = findViewById(R.id.tv_title);
        tvDescription = findViewById(R.id.tv_description);
        tvPublishedOn = findViewById(R.id.tv_published_on);
        tvStatus = findViewById(R.id.tv_article_type);
        tvAuther = findViewById(R.id.tv_author);
    }


    private void setData() {
        if (articleData.getFeaturedImage() != null && articleData.getFeaturedImage().size() > 0) {
            Glide.with(this)
                    .load(articleData.getFeaturedImage().get(0).getImageFile())
                    .into(ivFeaturedImage);
        }

        tvTitle.setText(articleData.getTitle());
        tvDescription.setText(articleData.getDescription());
        tvStatus.setText(getResources().getString(R.string.article_type) + " " + articleData.getGetArticleTypeDisplay());
        tvPublishedOn.setText(getResources().getString(R.string.str_published_on) + " " + DateUtils.getDateInFormat(Constants.DISPLAY_DATE_TIME_FORMAT2, articleData.getPublishDate()));

        StringBuilder stringBuilder = new StringBuilder();
        if (articleData.getAuthors() != null) {
            for (Author auther : articleData.getAuthors()) {
                stringBuilder.append(auther.getFullName() + ",");
            }
        }
        tvAuther.setText(stringBuilder.toString());
    }

}
