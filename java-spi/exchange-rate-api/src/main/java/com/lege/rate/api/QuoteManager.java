package com.lege.rate.api;

import java.time.LocalDate;
import java.util.List;

/**
 * @author lege
 * @Description
 * @create 2022-08-23 9:51
 */
public interface QuoteManager {
    List<Quote> getQuotes(String baseCurrency, LocalDate date);
}
