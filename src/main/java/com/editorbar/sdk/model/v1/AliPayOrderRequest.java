package com.editorbar.sdk.model.v1;

import com.editorbar.sdk.HttpRequest;

public class AliPayOrderRequest extends HttpRequest<AliPayOrderResponse> {
    public static final String ORDERS_PAY = "/orders/alipay";
    private final Long orderId;
    private final String payReturnUrl;

    public AliPayOrderRequest(Long orderId, String payReturnUrl) {
        super(ORDERS_PAY);
        this.orderId = orderId;
        this.payReturnUrl = payReturnUrl;

        this.putQueryParam("orderId", orderId.toString());
        this.putQueryParam("payReturnUrl", payReturnUrl);
    }

    public Long getOrderId() {
        return orderId;
    }

    public String getPayReturnUrl() {
        return payReturnUrl;
    }

    @Override
    public Class<AliPayOrderResponse> getResponseClass() {
        return AliPayOrderResponse.class;
    }
}
