package com.lege.rate.app;

import com.lege.rate.ExchangeRate;
import com.lege.rate.api.Quote;

import java.time.LocalDate;
import java.util.List;

/**
 * @author lege
 * @Description
 * @create 2022-08-23 11:23
 */
public class MainApp {
    public static void main(String... args) {
        ExchangeRate.providers().forEach(provider -> {
            System.out.println("Retreiving USD quotes from provider :" + provider);
            List<Quote> quotes = provider.create().getQuotes("USD", LocalDate.now());
            System.out.println(String.format("%14s%12s|%12s", "","Ask", "Bid"));
            System.out.println("----------------------------------------");
            quotes.forEach(quote -> {
                System.out.println("USD --> " + quote.getCurrency() + " : " + String.format("%12f|%12f", quote.getAsk(), quote.getBid()));
            });
        });
    }
}
