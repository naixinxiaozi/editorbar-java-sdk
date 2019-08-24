package com.editorbar.sdk.model.v1;

import com.editorbar.sdk.HttpResponse;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class QueryOrderStatusResponse extends HttpResponse {
    @SerializedName("data")
    @Expose
    private Integer data;

    public Integer getData() {
        return data;
    }
}
