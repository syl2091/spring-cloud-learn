package com.lege.rate.impl;


import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.junit.Test;

import java.io.IOException;

/**
 * @author lege
 * @Description
 * @create 2022-08-23 11:00
 */
public class TianQuoteManagerTest {
    static final String URL_PROVIDER = "http://api.tianapi.com/fxrate/index";

    @Test
    public void getTian() {
        OkHttpClient client = new OkHttpClient();
        String queryString = "key=9367063b2bb88b9597c1703ab6486097&fromcoin=USD&tocoin=CNY&money=1";
        String fullUrl = URL_PROVIDER + "?" + queryString;
        Request request = new Request.Builder()
                .url(fullUrl)
                .build();
        Response response = null;
        try {
            response = client.newCall(request).execute();
            System.out.println(response.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
