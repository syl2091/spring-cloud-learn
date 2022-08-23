package com.lege.rate.spi;

import com.lege.rate.api.QuoteManager;

public interface ExchangeRateProvider {
    QuoteManager create();
}