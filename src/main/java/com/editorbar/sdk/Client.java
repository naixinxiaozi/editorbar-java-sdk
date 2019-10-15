package com.editorbar.sdk;

import com.editorbar.sdk.exception.SdkException;
import com.editorbar.sdk.util.GsonUtils;
import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import javax.net.ssl.*;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.concurrent.TimeUnit;

public class Client {
    private Credential credential;
    private OkHttpClient conn;
    private Config config;

    public Client(Credential credential) {
        this(new Config(), credential);
    }

    public Client(Config config, Credential credential) {
        this.credential = credential;
        this.config = config;
        this.initHttpClient(config);
    }

    public <T extends HttpResponse> T execute(HttpRequest<T> request) throws IOException {
        Request req = RequestBuilder.build(this.config.getEndpoint(), request, credential);

        Response response = conn.newCall(req).execute();

        if (response.isSuccessful()) {
            String string = response.body().string();
            T t = GsonUtils.gson.fromJson(string, request.getResponseClass());
            t.setOkResponse(response);
            return t;
        } else {
            throw new SdkException("http network status code: " + response.code());
        }
    }

    public <T extends HttpResponse> T getResponse(HttpRequest<T> request) throws IOException, IllegalAccessException, InstantiationException {
        Request req = RequestBuilder.build(this.config.getEndpoint(), request, credential);
        Response response = conn.newCall(req).execute();

        if (response.isSuccessful()) {
            T t = request.getResponseClass().newInstance();
            t.setCode(0);
            t.setOkResponse(response);
            return t;
        } else {
            throw new SdkException("http network status code: " + response.code());
        }
    }

    private void initHttpClient(Config config) {
        ConnectionPool connectionPool = new ConnectionPool(config.getMaxIdleConnections(), config.getKeepAliveDuration(), TimeUnit.MINUTES);

        TrustAllManager trustAllManager = new TrustAllManager();
        conn = new OkHttpClient.Builder()
                .connectTimeout(config.getConnectTimeout(), TimeUnit.SECONDS)
                .readTimeout(config.getReadTimeout(), TimeUnit.SECONDS)
                .writeTimeout(config.getWriteTimeout(), TimeUnit.SECONDS)
                .connectionPool(connectionPool)
                .sslSocketFactory(createTrustAllSSLFactory(trustAllManager), trustAllManager)
                .hostnameVerifier(createTrustAllHostnameVerifier())
                .build();
    }

    private SSLSocketFactory createTrustAllSSLFactory(TrustAllManager trustAllManager) {
        SSLSocketFactory ssfFactory = null;
        try {
            SSLContext sc = SSLContext.getInstance("TLS");
            sc.init(null, new TrustManager[]{trustAllManager}, new SecureRandom());
            ssfFactory = sc.getSocketFactory();
        } catch (Exception ignored) {
            ignored.printStackTrace();
        }

        return ssfFactory;
    }

    private HostnameVerifier createTrustAllHostnameVerifier() {
        return (hostname, session) -> true;
    }

}
