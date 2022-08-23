package com.lege.rate.impl;

import com.lege.rate.api.QuoteManager;
import com.lege.rate.spi.ExchangeRateProvider;

public class TianFinanceExchangeRateProvider implements ExchangeRateProvider {

    @Override
    public QuoteManager create() {
        return new TianQuoteManagerImpl();
    }

}