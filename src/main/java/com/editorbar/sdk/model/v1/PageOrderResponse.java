package com.editorbar.sdk.model.v1;

import com.editorbar.sdk.HttpResponse;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PageOrderResponse extends HttpResponse {
    @SerializedName("data")
    @Expose
    private Object data;

    public PageOrderResponse() {
    }

    public Object getData() {
        return data;
    }
}
