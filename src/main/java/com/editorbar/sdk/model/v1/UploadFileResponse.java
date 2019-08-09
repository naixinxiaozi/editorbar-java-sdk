package com.editorbar.sdk.model.v1;

import com.editorbar.sdk.HttpResponse;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UploadFileResponse extends HttpResponse {

    @SerializedName("data")
    @Expose
    private String data;

    public UploadFileResponse() {
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
