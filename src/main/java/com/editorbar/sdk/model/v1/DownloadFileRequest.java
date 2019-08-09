package com.editorbar.sdk.model.v1;

import com.editorbar.sdk.HttpRequest;

public class DownloadFileRequest extends HttpRequest<DownloadFileResponse> {
    public static final String DOWNLOAD = "/download";
    private final String url;

    public DownloadFileRequest(String url) {
        super(DOWNLOAD);
        this.url = url;
        this.putQueryParam("url", url);
    }

    public String getUrl() {
        return url;
    }

    @Override
    public Class<DownloadFileResponse> getResponseClass() {
        return DownloadFileResponse.class;
    }
}
