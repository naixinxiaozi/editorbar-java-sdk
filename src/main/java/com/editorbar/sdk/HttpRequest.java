package com.editorbar.sdk;

import okhttp3.MediaType;

import java.util.HashMap;
import java.util.Map;

public abstract class HttpRequest<T extends HttpResponse> {
    private final Map<String, String> pathParams = new HashMap<>();
    private final Map<String, String> queryParams = new HashMap<>();
    private final Map<String, String> headParams = new HashMap<>();

    private MediaType mediaType = MediaType.parse("application/json; charset=utf-8");
    private Method method;
    private String path;

    public HttpRequest(String path) {
        this(path, Method.GET);
    }

    public HttpRequest(String path, Method method) {
        this.path = path;
        this.method = method;
    }

    public FilePart filePart() {
        return null;
    }

    public Map<String, String> getPathParams() {
        return pathParams;
    }

    public void putPathParam(String key, String val) {
        this.pathParams.put(key, val);
    }

    public Map<String, String> getQueryParams() {
        return queryParams;
    }

    public void putQueryParam(String key, String val) {
        this.queryParams.put(key, val);
    }

    public Map<String, String> getHeadParams() {
        return headParams;
    }

    public void putHeader(String key, String val) {
        this.headParams.put(key, val);
    }

    public MediaType getMediaType() {
        return mediaType;
    }

    public Method getMethod() {
        return method;
    }

    public String getPath() {
        return path;
    }

    public void setMethod(Method method) {
        this.method = method;
    }

    public void setMediaType(MediaType mediaType) {
        this.mediaType = mediaType;
    }

    public abstract Class<T> getResponseClass();
}
