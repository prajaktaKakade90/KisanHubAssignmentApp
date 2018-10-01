package com.kisanhubassignmentapp.api.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class TagList implements Serializable{

@SerializedName("slug")
@Expose
private String slug;
@SerializedName("title")
@Expose
private String title;

public String getSlug() {
return slug;
}

public void setSlug(String slug) {
this.slug = slug;
}

public String getTitle() {
return title;
}

public void setTitle(String title) {
this.title = title;
}

}