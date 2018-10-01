package com.kisanhubassignmentapp.api.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Author implements Serializable{

@SerializedName("picture")
@Expose
private String picture;
@SerializedName("full_name")
@Expose
private String fullName;
@SerializedName("profile_slug")
@Expose
private String profileSlug;

public String getPicture() {
return picture;
}

public void setPicture(String picture) {
this.picture = picture;
}

public String getFullName() {
return fullName;
}

public void setFullName(String fullName) {
this.fullName = fullName;
}

public String getProfileSlug() {
return profileSlug;
}

public void setProfileSlug(String profileSlug) {
this.profileSlug = profileSlug;
}

}