package com.editorbar.sdk.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonUtils {
    public static Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
}
