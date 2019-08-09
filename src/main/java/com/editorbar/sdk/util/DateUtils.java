package com.editorbar.sdk.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.SimpleTimeZone;

public class DateUtils {
    private final static String TIME_ZONE = "GMT";
    private final static String FORMAT_RFC2616 = "EEE, dd MMM yyyy HH:mm:ss zzz";

    public static String getRFC2616Date(Date date) {
        SimpleDateFormat df = new SimpleDateFormat(FORMAT_RFC2616, Locale.ENGLISH);
        df.setTimeZone(new SimpleTimeZone(0, TIME_ZONE));
        return df.format(date);
    }
}
