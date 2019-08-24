package com.editorbar.sdk.model.v1;

import com.editorbar.sdk.HttpRequest;
import com.editorbar.sdk.Method;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class QueryOrderStatusRequest extends HttpRequest<QueryOrderStatusResponse> {

    public static final String PATH = "/orders/status";

    /**
     *  订单号
     */
    private String code;

    public QueryOrderStatusRequest(String code) {
        super(PATH);
        if (code == null || code.isEmpty()) {
            throw new IllegalArgumentException("code can't be empty");
        }
        this.code = code;
        this.putQueryParam("code", code);
    }

    public String getCode() {
        return code;
    }

    @Override
    public Class<QueryOrderStatusResponse> getResponseClass() {
        return QueryOrderStatusResponse.class;
    }
}
