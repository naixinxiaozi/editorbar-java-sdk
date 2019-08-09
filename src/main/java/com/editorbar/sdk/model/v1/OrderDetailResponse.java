package com.editorbar.sdk.model.v1;

import com.editorbar.sdk.HttpResponse;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OrderDetailResponse extends HttpResponse {

    @SerializedName("data")
    @Expose
    private Object data;

    public OrderDetailResponse() {
    }

    public Object getData() {
        return data;
    }
}
