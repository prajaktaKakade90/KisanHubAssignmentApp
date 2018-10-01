package com.kisanhubassignmentapp.api.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class RegionList implements Serializable{

@SerializedName("name")
@Expose
private String name;
@SerializedName("slug")
@Expose
private String slug;

public String getName() {
return name;
}

public void setName(String name) {
this.name = name;
}

public String getSlug() {
return slug;
}

public void setSlug(String slug) {
this.slug = slug;
}

}