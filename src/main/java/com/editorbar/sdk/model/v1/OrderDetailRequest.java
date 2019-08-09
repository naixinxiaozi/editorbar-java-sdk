package com.editorbar.sdk.model.v1;

import com.editorbar.sdk.HttpRequest;

public class OrderDetailRequest extends HttpRequest<OrderDetailResponse> {
    public static final String ORDERS_DETAIL = "/orders/detail";
    private final String identifier;
    private final Long orderId;

    public OrderDetailRequest(String identifier, Long orderId) {
        super(ORDERS_DETAIL);
        if (identifier == null || identifier.isEmpty()) {
            throw new IllegalArgumentException("identifier can't be empty");
        }
        this.identifier = identifier;
        this.putQueryParam("identifier", identifier);

        if (orderId == null) {
            throw new IllegalArgumentException("orderId can't be null");
        }

        this.orderId = orderId;
        this.putQueryParam("orderId", orderId.toString());
    }

    public String getIdentifier() {
        return identifier;
    }

    public Long getOrderId() {
        return orderId;
    }

    @Override
    public Class<OrderDetailResponse> getResponseClass() {
        return OrderDetailResponse.class;
    }
}
