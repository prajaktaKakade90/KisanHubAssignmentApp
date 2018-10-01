package com.kisanhubassignmentapp.api.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Datum implements Serializable {

    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("slug")
    @Expose
    private String slug;
    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("content_code")
    @Expose
    private Object contentCode;
    @SerializedName("authors")
    @Expose
    private List<Author> authors = null;
    @SerializedName("approvers")
    @Expose
    private List<Integer> approvers = null;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("video_content")
    @Expose
    private Object videoContent;
    @SerializedName("article_type_fk")
    @Expose
    private String articleTypeFk;
    @SerializedName("featured_article")
    @Expose
    private Boolean featuredArticle;
    @SerializedName("featured_image")
    @Expose
    private List<FeaturedImage> featuredImage = null;
    @SerializedName("publish_date")
    @Expose
    private Date publishDate;
    @SerializedName("publish_date_readable")
    @Expose
    private String publishDateReadable;
    @SerializedName("created_readable")
    @Expose
    private String createdReadable;
    @SerializedName("region_list")
    @Expose
    private List<RegionList> regionList = null;
    @SerializedName("tag_list")
    @Expose
    private List<TagList> tagList = null;
    @SerializedName("report_slug")
    @Expose
    private Object reportSlug;
    @SerializedName("get_article_type_display")
    @Expose
    private String getArticleTypeDisplay;
    @SerializedName("get_status_display")
    @Expose
    private String getStatusDisplay;
    @SerializedName("subscription_package")
    @Expose
    private List<SubscriptionPackage> subscriptionPackage = null;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Object getContentCode() {
        return contentCode;
    }

    public void setContentCode(Object contentCode) {
        this.contentCode = contentCode;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public List<Integer> getApprovers() {
        return approvers;
    }

    public void setApprovers(List<Integer> approvers) {
        this.approvers = approvers;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Object getVideoContent() {
        return videoContent;
    }

    public void setVideoContent(Object videoContent) {
        this.videoContent = videoContent;
    }

    public String getArticleTypeFk() {
        return articleTypeFk;
    }

    public void setArticleTypeFk(String articleTypeFk) {
        this.articleTypeFk = articleTypeFk;
    }

    public Boolean getFeaturedArticle() {
        return featuredArticle;
    }

    public void setFeaturedArticle(Boolean featuredArticle) {
        this.featuredArticle = featuredArticle;
    }

    public List<FeaturedImage> getFeaturedImage() {
        return featuredImage;
    }

    public void setFeaturedImage(List<FeaturedImage> featuredImage) {
        this.featuredImage = featuredImage;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public String getPublishDateReadable() {
        return publishDateReadable;
    }

    public void setPublishDateReadable(String publishDateReadable) {
        this.publishDateReadable = publishDateReadable;
    }

    public String getCreatedReadable() {
        return createdReadable;
    }

    public void setCreatedReadable(String createdReadable) {
        this.createdReadable = createdReadable;
    }

    public List<RegionList> getRegionList() {
        return regionList;
    }

    public void setRegionList(List<RegionList> regionList) {
        this.regionList = regionList;
    }

    public List<TagList> getTagList() {
        return tagList;
    }

    public void setTagList(List<TagList> tagList) {
        this.tagList = tagList;
    }

    public Object getReportSlug() {
        return reportSlug;
    }

    public void setReportSlug(Object reportSlug) {
        this.reportSlug = reportSlug;
    }

    public String getGetArticleTypeDisplay() {
        return getArticleTypeDisplay;
    }

    public void setGetArticleTypeDisplay(String getArticleTypeDisplay) {
        this.getArticleTypeDisplay = getArticleTypeDisplay;
    }

    public String getGetStatusDisplay() {
        return getStatusDisplay;
    }

    public void setGetStatusDisplay(String getStatusDisplay) {
        this.getStatusDisplay = getStatusDisplay;
    }

    public List<SubscriptionPackage> getSubscriptionPackage() {
        return subscriptionPackage;
    }

    public void setSubscriptionPackage(List<SubscriptionPackage> subscriptionPackage) {
        this.subscriptionPackage = subscriptionPackage;
    }

}