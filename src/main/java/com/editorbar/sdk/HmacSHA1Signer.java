package com.editorbar.sdk;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

public class HmacSHA1Signer {
    private static final String ALGORITHM_NAME = "HmacSHA1";
    private static final String ENCODING = "UTF-8";

    public static String signStr(String strToSign, String secretKey) {
        try {
            Mac mac = Mac.getInstance(ALGORITHM_NAME);
            mac.init(new SecretKeySpec(secretKey.getBytes(ENCODING), ALGORITHM_NAME));
            byte[] signData = mac.doFinal(strToSign.getBytes(ENCODING));
            return DatatypeConverter.printBase64Binary(signData);
        } catch (Exception e) {
            throw new IllegalArgumentException(e.toString());
        }
    }
}
