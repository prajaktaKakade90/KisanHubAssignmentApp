package com.kisanhubassignmentapp.api.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ArticleResponse {

@SerializedName("count")
@Expose
private Integer count;
@SerializedName("total_count")
@Expose
private Integer totalCount;
@SerializedName("page_size")
@Expose
private Integer pageSize;
@SerializedName("total_pages")
@Expose
private Double totalPages;
@SerializedName("next")
@Expose
private String next;
@SerializedName("previous")
@Expose
private Object previous;
@SerializedName("current_page")
@Expose
private Integer currentPage;
@SerializedName("metadata")
@Expose
private Metadata metadata;
@SerializedName("message")
@Expose
private String message;
@SerializedName("data")
@Expose
private List<Datum> data = null;

public Integer getCount() {
return count;
}

public void setCount(Integer count) {
this.count = count;
}

public Integer getTotalCount() {
return totalCount;
}

public void setTotalCount(Integer totalCount) {
this.totalCount = totalCount;
}

public Integer getPageSize() {
return pageSize;
}

public void setPageSize(Integer pageSize) {
this.pageSize = pageSize;
}

public Double getTotalPages() {
return totalPages;
}

public void setTotalPages(Double totalPages) {
this.totalPages = totalPages;
}

public String getNext() {
return next;
}

public void setNext(String next) {
this.next = next;
}

public Object getPrevious() {
return previous;
}

public void setPrevious(Object previous) {
this.previous = previous;
}

public Integer getCurrentPage() {
return currentPage;
}

public void setCurrentPage(Integer currentPage) {
this.currentPage = currentPage;
}

public Metadata getMetadata() {
return metadata;
}

public void setMetadata(Metadata metadata) {
this.metadata = metadata;
}

public String getMessage() {
return message;
}

public void setMessage(String message) {
this.message = message;
}

public List<Datum> getData() {
return data;
}

public void setData(List<Datum> data) {
this.data = data;
}

}