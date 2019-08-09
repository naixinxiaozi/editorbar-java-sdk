package com.editorbar.sdk;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import okhttp3.Response;

public class HttpResponse {
    private Response okResponse;

    @SerializedName("code")
    @Expose
    private int code;

    @SerializedName("msg")
    @Expose
    private String msg;


    public HttpResponse() {
    }

    public Response getOkResponse() {
        return okResponse;
    }

    public void setOkResponse(Response okResponse) {
        this.okResponse = okResponse;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
