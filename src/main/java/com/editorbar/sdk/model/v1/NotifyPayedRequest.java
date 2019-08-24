package com.editorbar.sdk.model.v1;

import com.editorbar.sdk.HttpRequest;
import com.editorbar.sdk.Method;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.math.BigDecimal;

public class NotifyPayedRequest extends HttpRequest<NotifyPayedResponse> {

    public static final String PATH = "/orders/notifyPayed";

    @SerializedName("orderCode")
    @Expose
    private String orderCode;

    @SerializedName("payedFee")
    @Expose
    private BigDecimal payedFee;

    @SerializedName("remark")
    @Expose
    private String remark;

    public NotifyPayedRequest(String orderCode) {
        super(PATH, Method.POST);
        if (orderCode == null) {
            throw new IllegalArgumentException("orderCode can't be empty");
        }
        this.orderCode = orderCode;
    }

    public NotifyPayedRequest(String orderCode, BigDecimal payedFee, String remark) {
        super(PATH, Method.POST);
        if (orderCode == null) {
            throw new IllegalArgumentException("orderCode can't be empty");
        }
        this.orderCode = orderCode;
        this.payedFee = payedFee;
        this.remark = remark;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public BigDecimal getPayedFee() {
        return payedFee;
    }

    public void setPayedFee(BigDecimal payedFee) {
        this.payedFee = payedFee;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public Class<NotifyPayedResponse> getResponseClass() {
        return NotifyPayedResponse.class;
    }
}
