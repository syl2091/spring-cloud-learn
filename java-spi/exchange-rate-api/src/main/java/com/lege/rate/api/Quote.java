package com.lege.rate.api;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * @author lege
 * @Description
 * @create 2022-08-23 9:48
 */
@Data
public class Quote {
    private String currency;
    private BigDecimal ask;
    private BigDecimal bid;
    private LocalDate date;
}
