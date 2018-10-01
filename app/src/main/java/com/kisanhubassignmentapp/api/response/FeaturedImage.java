package com.kisanhubassignmentapp.api.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class FeaturedImage implements Serializable{

@SerializedName("image_file")
@Expose
private String imageFile;

public String getImageFile() {
return imageFile;
}

public void setImageFile(String imageFile) {
this.imageFile = imageFile;
}

}