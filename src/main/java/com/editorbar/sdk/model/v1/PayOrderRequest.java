package com.editorbar.sdk.model.v1;

import com.editorbar.sdk.HttpRequest;

public class PayOrderRequest extends HttpRequest<PayOrderResponse> {
    public static final String ORDERS_PAY = "/orders/pay";
    private final Long orderId;
    private final String payReturnUrl;

    public PayOrderRequest(Long orderId, String payReturnUrl) {
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
    public Class<PayOrderResponse> getResponseClass() {
        return PayOrderResponse.class;
    }
}
