package com.editorbar.sdk.model.v1;

import com.editorbar.sdk.HttpRequest;
import com.editorbar.sdk.Method;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AfterSaleRequest extends HttpRequest<AfterSaleResponse> {

    public static final String PATH = "/orders/aftersale";

    @SerializedName("identifier")
    @Expose
    private String identifier;

    @SerializedName("orderId")
    @Expose
    private Long orderId;

    @SerializedName("cause")
    @Expose
    private Integer cause;

    @SerializedName("remark")
    @Expose
    private String remark;

    @SerializedName("suggestion")
    @Expose
    private String suggestion;

    @SerializedName("attachment")
    @Expose
    private String attachment;


    public AfterSaleRequest(String identifier) {
        super(PATH, Method.POST);
        if (identifier == null || identifier.isEmpty()) {
            throw new IllegalArgumentException("identifier can't be empty");
        }
        this.identifier = identifier;
    }

    public AfterSaleRequest(String identifier, Long orderId, Integer cause, String remark, String suggestion, String attachment) {
        super(PATH, Method.POST);
        if (identifier == null || identifier.isEmpty()) {
            throw new IllegalArgumentException("identifier can't be empty");
        }

        this.identifier = identifier;
        this.orderId = orderId;
        this.cause = cause;
        this.remark = remark;
        this.suggestion = suggestion;
        this.attachment = attachment;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Integer getCause() {
        return cause;
    }

    public void setCause(Integer cause) {
        this.cause = cause;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getSuggestion() {
        return suggestion;
    }

    public void setSuggestion(String suggestion) {
        this.suggestion = suggestion;
    }

    public String getAttachment() {
        return attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment;
    }

    @Override
    public Class<AfterSaleResponse> getResponseClass() {
        return AfterSaleResponse.class;
    }
}
