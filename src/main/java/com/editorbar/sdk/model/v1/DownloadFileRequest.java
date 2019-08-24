package com.editorbar.sdk.model.v1;

import com.editorbar.sdk.HttpRequest;

public class DownloadFileRequest extends HttpRequest<DownloadFileResponse> {
    public static final String DOWNLOAD = "/download";
    private final String url;
    private final String identifier;

    public DownloadFileRequest(String url, String identifier) {
        super(DOWNLOAD);
        if (identifier == null || identifier.isEmpty()) {
            throw new IllegalArgumentException("identifier can't be empty");
        }
        this.identifier = identifier;
        this.putQueryParam("identifier", identifier);

        this.url = url;
        this.putQueryParam("url", url);
    }

    public String getUrl() {
        return url;
    }

    public String getIdentifier() {
        return identifier;
    }

    @Override
    public Class<DownloadFileResponse> getResponseClass() {
        return DownloadFileResponse.class;
    }
}
