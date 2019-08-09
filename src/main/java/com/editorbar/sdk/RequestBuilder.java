package com.editorbar.sdk;

import com.editorbar.sdk.util.DateUtils;
import com.editorbar.sdk.util.GsonUtils;
import com.editorbar.sdk.util.DateUtils;
import com.editorbar.sdk.util.GsonUtils;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class RequestBuilder {

    public static Request build(String endpoint, HttpRequest request, Credential cred) throws UnsupportedEncodingException {
        String fullUrl = composeUrl(endpoint, request);

        request.putHeader("Date", DateUtils.getRFC2616Date(new Date()));
        request.putHeader("Accept", request.getMediaType().toString());
        request.putHeader("x-eb-signature-method", "HMAC-SHA1");
        request.putHeader("x-eb-signature-version", "1.0");
        request.putHeader("x-eb-signature-nonce", UUID.randomUUID().toString());
        request.putHeader("User-Agent", "Editorbar (Windows 10; amd64) Java/1.8.0_212-b10 editorbar-sdk/1.0.1 HTTPClient/ApacheHttpClient");

        //GET 请求
        if (request.getMethod().equals(Method.GET)) {
            String strToSign = SignatureComposer.composeStringToSign(request);
            String signature = HmacSHA1Signer.signStr(strToSign, cred.getAppSecret());
            System.out.println("strToSign=" + strToSign);
            System.out.println("signature=" + signature);
            request.putHeader("Authorization", "eb " + cred.getAppKey() + ":" + signature);

            Map<String, String> headParams = request.getHeadParams();
            Set<Map.Entry<String, String>> entries = headParams.entrySet();
            for (Map.Entry<String, String> entry : entries) {
                System.out.println(entry.getKey() + "    " + entry.getValue());
            }

            return new Request.Builder().url(fullUrl).headers(buildHeaders(request.getHeadParams())).get().build();
        }

        //POST 请求
        byte[] contents;
        if (request.filePart() == null) {
            String bodyStr = GsonUtils.gson.toJson(request);
            contents = bodyStr != null ? bodyStr.getBytes(StandardCharsets.UTF_8) : new byte[0];
            request.putHeader("Content-Type", request.getMediaType().toString());
        } else {
            //文件上传
            String boundary = UUID.randomUUID().toString();
            String contentType = "multipart/form-data; charset=utf-8" + "; boundary=" + boundary;
            request.setMediaType(MediaType.parse(contentType));
            request.putHeader("Content-Type", contentType);
            contents = getMultipartPayload(request.filePart(), boundary);
        }

        request.putHeader("Content-MD5", SignatureComposer.md5Sum(contents));
        request.putHeader("Content-Length", String.valueOf(contents.length));

        String strToSign = SignatureComposer.composeStringToSign(request);
        String signature = HmacSHA1Signer.signStr(strToSign, cred.getAppSecret());
        System.out.println("strToSign=" + strToSign);
        System.out.println("signature=" + signature);

        request.putHeader("Authorization", "eb " + cred.getAppKey() + ":" + signature);

        RequestBody body = RequestBody.create(request.getMediaType(), contents);

        Map<String, String> headParams = request.getHeadParams();
        Set<Map.Entry<String, String>> entries = headParams.entrySet();
        for (Map.Entry<String, String> entry : entries) {
            System.out.println(entry.getKey() + "    " + entry.getValue());
        }
        return new Request.Builder().url(fullUrl).headers(buildHeaders(request.getHeadParams())).post(body).build();
    }

    private static String composeUrl(String endpoint, HttpRequest request) {
        StringBuilder urlBuilder = new StringBuilder(endpoint);
        String path = request.getPath();
        if (null != path) {
            urlBuilder.append(SignatureComposer.replaceOccupiedParameters(path, request.getPathParams()));
        }

        if (-1 == urlBuilder.indexOf("?")) {
            urlBuilder.append("?");
        } else if (!urlBuilder.toString().endsWith("?")) {
            urlBuilder.append("&");
        }

        String query = SignatureComposer.concatQueryString(request.getQueryParams());
        String url = urlBuilder.append(query).toString();
        if (url.endsWith("?") || url.endsWith("&")) {
            url = url.substring(0, url.length() - 1);
        }
        return url;
    }

    private static Headers buildHeaders(Map<String, String> headParams) {
        Headers.Builder hBuilder = new Headers.Builder();
        Set<Map.Entry<String, String>> entries = headParams.entrySet();
        for (Map.Entry<String, String> entry : entries) {
            hBuilder.add(entry.getKey(), entry.getValue());
        }

        return hBuilder.build();
    }

    private static byte[] getMultipartPayload(FilePart filePart, String boundary) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            baos.write("--".getBytes());
            baos.write(boundary.getBytes());
            baos.write("\r\n".getBytes());
            baos.write("Content-Disposition: form-data; name=\"".getBytes());
            baos.write(filePart.getName().getBytes());

            baos.write("\"; filename=\"".getBytes());
            baos.write(filePart.getOriginalFilename().getBytes());
            baos.write("\"\r\n".getBytes());
            baos.write("; Content-Type: ".getBytes());
            baos.write(filePart.getContentType().getBytes());
            baos.write("\r\n".getBytes());

            baos.write("\r\n".getBytes());
            baos.write(filePart.getFile());
            baos.write("\r\n".getBytes());

            if (baos.size() != 0) {
                baos.write("--".getBytes());
                baos.write(boundary.getBytes());
                baos.write("--\r\n".getBytes());
            }

            return baos.toByteArray();
        } catch (IOException e) {
            //TODO
            e.printStackTrace();
            return new byte[0];
        } finally {
            try {
                baos.close();
            } catch (IOException e) {
            }
        }

    }
}
