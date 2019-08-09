package com.editorbar.sdk.model.v1;

import com.editorbar.sdk.HttpResponse;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ListFieldResponse extends HttpResponse {
    @SerializedName("data")
    @Expose
    private Object data;

    public ListFieldResponse() {
    }

    public Object getData() {
        return data;
    }
}
