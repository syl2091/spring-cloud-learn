package com.lege.rate.impl;

import com.lege.rate.api.Quote;
import com.lege.rate.api.QuoteManager;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

/**
 * @author lege
 * @Description
 * @create 2022-08-23 10:38
 */
public class TianQuoteManagerImpl implements QuoteManager {
    static final String URL_PROVIDER = "http://api.tianapi.com/fxrate/index";
    OkHttpClient client = new OkHttpClient();
    @Override
    public List<Quote> getQuotes(String baseCurrency, LocalDate date) {
        return null;
    }

    String doGet(String queryString){
        String fullUrl = URL_PROVIDER+"?"+queryString;
        System.out.println(fullUrl);
        Request request = new Request.Builder()
                .url(fullUrl)
                .build();
        Response response = null;
        try {
            response = client.newCall(request).execute();
            return response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
