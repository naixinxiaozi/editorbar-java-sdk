package com.editorbar.sdk.model.v1;

import com.editorbar.sdk.HttpRequest;

public class ListInvoiceTypesRequest extends HttpRequest<ListInvoiceTypesResponse> {
    public ListInvoiceTypesRequest() {
        super("/invoice/types");
    }

    @Override
    public Class<ListInvoiceTypesResponse> getResponseClass() {
        return ListInvoiceTypesResponse.class;
    }
}
