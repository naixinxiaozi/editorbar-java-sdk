package com.editorbar.sdk.model.v1;

import com.editorbar.sdk.HttpResponse;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ListInvoiceTypesResponse extends HttpResponse {
    @SerializedName("data")
    @Expose
    private Object data;

    public ListInvoiceTypesResponse() {
    }

    public Object getData() {
        return data;
    }

    /*public static class InvoiceType {
        @SerializedName("key")
        @Expose
        private Integer key;

        @SerializedName("value")
        @Expose
        private String value;

        public Integer getKey() {
            return key;
        }

        public void setKey(Integer key) {
            this.key = key;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }*/
}
