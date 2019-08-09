package com.editorbar.sdk.model.v1;

import com.editorbar.sdk.FilePart;
import com.editorbar.sdk.HttpRequest;
import com.editorbar.sdk.Method;

public class UploadFileRequest extends HttpRequest<UploadFileResponse> {

    private final String identifier;
    private FilePart filePart;

    public UploadFileRequest(String identifier) {
        super("/uploadFile", Method.POST);
        if (identifier == null || identifier.isEmpty()) {
            throw new IllegalArgumentException("identifier can't be empty");
        }
        this.identifier = identifier;
        this.putQueryParam("identifier", identifier);
    }

    public FilePart getFilePart() {
        return filePart;
    }

    public void setFilePart(FilePart filePart) {
        this.filePart = filePart;
    }

    @Override
    public FilePart filePart() {
        return this.filePart;
    }

    public String getIdentifier() {
        return identifier;
    }

    @Override
    public Class<UploadFileResponse> getResponseClass() {
        return UploadFileResponse.class;
    }
}
