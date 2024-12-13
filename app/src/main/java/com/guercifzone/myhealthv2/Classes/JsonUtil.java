package com.guercifzone.myhealthv2.Classes;

import android.content.Context;
import com.google.gson.Gson;


import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class JsonUtil {
    public static Product parseProductJson(Context context, String fileName) {
        try {
            InputStream is = context.getAssets().open(fileName);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            String json = new String(buffer, StandardCharsets.UTF_8);

            // Parse JSON into Product object
            Gson gson = new Gson();
            return gson.fromJson(json, Product.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}

