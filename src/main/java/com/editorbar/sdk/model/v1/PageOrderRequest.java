package com.editorbar.sdk.model.v1;

import com.editorbar.sdk.HttpRequest;

public class PageOrderRequest extends HttpRequest<PageOrderResponse> {
    public static final String ORDERS_LIST = "/orders/list";
    private final String identifier;
    private final Integer status;
    private final Integer pageNumber;
    private final Integer pageSize;

    public PageOrderRequest(String identifier, Integer status, Integer pageNumber, Integer pageSize) {
        super(ORDERS_LIST);
        if (identifier == null || identifier.isEmpty()) {
            throw new IllegalArgumentException("identifier can't be empty");
        }
        this.identifier = identifier;
        this.status = status;
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
        this.putQueryParam("identifier", identifier);
        if (status != null) {
            this.putQueryParam("status", status.toString());
        }
        this.putQueryParam("pageNumber", pageNumber.toString());
        this.putQueryParam("pageSize", pageSize.toString());
    }

    public String getIdentifier() {
        return identifier;
    }

    public Integer getStatus() {
        return status;
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    @Override
    public Class<PageOrderResponse> getResponseClass() {
        return PageOrderResponse.class;
    }
}
