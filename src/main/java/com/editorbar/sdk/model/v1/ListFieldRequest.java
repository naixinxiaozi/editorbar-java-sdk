package com.editorbar.sdk.model.v1;

import com.editorbar.sdk.HttpRequest;

public class ListFieldRequest extends HttpRequest<ListFieldResponse> {
    public ListFieldRequest() {
        super("/fields");
    }

    @Override
    public Class<ListFieldResponse> getResponseClass() {
        return ListFieldResponse.class;
    }
}
