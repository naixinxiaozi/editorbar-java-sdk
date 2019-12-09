package com.editorbar.sdk;

public class Config {
    public static String TEST_ENDPOINT = "http://link.113lab.cn";
    public static String ENDPOINT = "https://openapi.editorbar.com";

    private String endpoint;
    private int connectTimeout = 20;
    private int readTimeout = 180;
    private int writeTimeout = 120;

    private int maxIdleConnections = 10;
    private long keepAliveDuration = 5L;

    public Config() {
        this(ENDPOINT);
    }

    public Config(boolean isDev) {
        this(isDev ? TEST_ENDPOINT : ENDPOINT);
    }

    public Config(String endpoint) {
        this.endpoint = endpoint;
    }

    public Config(String endpoint, int connectTimeout, int readTimeout, int writeTimeout, int maxIdleConnections, long keepAliveDuration) {
        this.endpoint = endpoint;
        this.connectTimeout = connectTimeout;
        this.readTimeout = readTimeout;
        this.writeTimeout = writeTimeout;
        this.maxIdleConnections = maxIdleConnections;
        this.keepAliveDuration = keepAliveDuration;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public int getConnectTimeout() {
        return connectTimeout;
    }

    public void setConnectTimeout(int connectTimeout) {
        this.connectTimeout = connectTimeout;
    }

    public int getReadTimeout() {
        return readTimeout;
    }

    public void setReadTimeout(int readTimeout) {
        this.readTimeout = readTimeout;
    }

    public int getWriteTimeout() {
        return writeTimeout;
    }

    public void setWriteTimeout(int writeTimeout) {
        this.writeTimeout = writeTimeout;
    }

    public int getMaxIdleConnections() {
        return maxIdleConnections;
    }

    public void setMaxIdleConnections(int maxIdleConnections) {
        this.maxIdleConnections = maxIdleConnections;
    }

    public long getKeepAliveDuration() {
        return keepAliveDuration;
    }

    public void setKeepAliveDuration(long keepAliveDuration) {
        this.keepAliveDuration = keepAliveDuration;
    }
}
