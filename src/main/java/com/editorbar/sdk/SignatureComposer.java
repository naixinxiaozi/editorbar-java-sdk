package com.editorbar.sdk;

import com.editorbar.sdk.util.Base64Helper;
import com.editorbar.sdk.util.URLEncodeUtils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.util.Map;
import java.util.TreeMap;

public final class SignatureComposer {
    public final static String QUERY_SEPARATOR = "&";
    public final static String HEADER_SEPARATOR = "\n";

    public static String replaceOccupiedParameters(String url, Map<String, String> paths) {
        String result = url;
        for (Map.Entry<String, String> entry : paths.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            String target = "[" + key + "]";
            result = result.replace(target, value);
        }

        return result;
    }

    public static String composeStringToSign(HttpRequest request) throws UnsupportedEncodingException {
        StringBuilder sb = new StringBuilder();
        sb.append(request.getMethod().toString()).append(HEADER_SEPARATOR);
        Map<String, String> headers = request.getHeadParams();
        if (headers.get("Accept") != null) {
            sb.append(headers.get("Accept"));
            sb.append(HEADER_SEPARATOR);
        }

        if (headers.get("Content-MD5") != null) {
            sb.append(headers.get("Content-MD5"));
            sb.append(HEADER_SEPARATOR);
        }

        if (headers.get("Content-Type") != null) {
            sb.append(headers.get("Content-Type"));
            sb.append(HEADER_SEPARATOR);
        }

        if (headers.get("Date") != null) {
            sb.append(headers.get("Date"));
            sb.append(HEADER_SEPARATOR);
        }

        sb.append(buildCanonicalHeaders(headers, "x-eb-"));

        String uri = replaceOccupiedParameters(request.getPath(), request.getPathParams());
        sb.append(buildQueryString(uri, request.getQueryParams()));
        return sb.toString();
    }

    public static String md5Sum(byte[] buff) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(buff);
            return Base64Helper.encode(messageDigest);
        } catch (Exception e) {
            // TODO: should not eat the excepiton
        }
        return null;
    }

    public static String concatQueryString(Map<String, String> parameters) {
        if (parameters.isEmpty()) {
            return "";
        }

        StringBuilder urlBuilder = new StringBuilder();
        try {
            for (Map.Entry<String, String> entry : parameters.entrySet()) {
                String key = entry.getKey();
                String val = entry.getValue();
                urlBuilder.append(URLEncoder.encode(key, "UTF-8"));
                if (val != null) {
                    urlBuilder.append("=").append(URLEncoder.encode(val, "UTF-8"));
                }
                urlBuilder.append("&");
            }
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }


        int strIndex = urlBuilder.length();
        if (parameters.size() > 0) {
            urlBuilder.deleteCharAt(strIndex - 1);
        }

        return urlBuilder.toString();
    }

    private static String buildCanonicalHeaders(Map<String, String> headers, String headerBegin) {
        Map<String, String> sortMap = new TreeMap<String, String>();
        for (Map.Entry<String, String> e : headers.entrySet()) {
            String key = e.getKey().toLowerCase();
            String val = e.getValue();
            if (key.startsWith(headerBegin)) {
                sortMap.put(key, val);
            }
        }
        StringBuilder headerBuilder = new StringBuilder();
        for (Map.Entry<String, String> e : sortMap.entrySet()) {
            headerBuilder.append(e.getKey());
            headerBuilder.append(':').append(e.getValue());
            headerBuilder.append(HEADER_SEPARATOR);
        }
        return headerBuilder.toString();
    }

    private static String buildQueryString(String uri, Map<String, String> queries) throws UnsupportedEncodingException {
        String[] uriParts = splitSubResource(uri);
        Map<String, String> sortMap = new TreeMap<>(queries);
        if (null != uriParts[1]) {
            sortMap.put(uriParts[1], null);
        }
        StringBuilder queryBuilder = new StringBuilder(uriParts[0]);
        if (0 < sortMap.size()) {
            queryBuilder.append("?");
        }
        for (Map.Entry<String, String> e : sortMap.entrySet()) {
            queryBuilder.append(URLEncodeUtils.encode(e.getKey()));

            String value = e.getValue();
            if (value != null) {
                queryBuilder.append("=").append(URLEncodeUtils.encode(e.getValue()));
            }
            queryBuilder.append(QUERY_SEPARATOR);
        }
        String queryString = queryBuilder.toString();
        if (queryString.endsWith(QUERY_SEPARATOR)) {
            queryString = queryString.substring(0, queryString.length() - 1);
        }

        return queryString;
    }

    private static String[] splitSubResource(String uri) {
        int queIndex = uri.indexOf("?");
        String[] uriParts = new String[2];
        if (-1 != queIndex) {
            uriParts[0] = uri.substring(0, queIndex);
            uriParts[1] = uri.substring(queIndex + 1);
        } else {
            uriParts[0] = uri;
        }
        return uriParts;
    }
}
