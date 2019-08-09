package com.editorbar.sdk;

public class Config {
    private int connectTimeout = 10;
    private int readTimeout = 20;
    private int writeTimeout = 20;

    private int maxIdleConnections = 10;
    private long keepAliveDuration = 5L;

    public Config() {
    }

    public Config(int connectTimeout, int readTimeout, int writeTimeout, int maxIdleConnections, long keepAliveDuration) {
        this.connectTimeout = connectTimeout;
        this.readTimeout = readTimeout;
        this.writeTimeout = writeTimeout;
        this.maxIdleConnections = maxIdleConnections;
        this.keepAliveDuration = keepAliveDuration;
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
