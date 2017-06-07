package com.bestdeals.returns.endpoint;

import com.bestdeals.returns.domain.Deal;
import com.bestdeals.returns.domain.Interval;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class CalculateParams {
    private Deal deal;
    private String currency;
    private BigDecimal amount;
    private Interval interval;
    private Double rate;
    private Integer period;


    public CalculateParams() {
    }

    public CalculateParams(Deal deal, String currency, BigDecimal amount, Interval interval, Double rate, Integer period) {
        this.deal           = deal;
        this.currency       = currency;
        this.amount         = amount;
        this.interval       = interval;
        this.rate           = rate;
        this.period         = period;
    }

    public Deal getDeal() {
        return deal;
    }

    public String getCurrency() {
        return currency;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Interval getInterval() {
        return interval;
    }

    public Double getRate() {
        return rate;
    }

    public Integer getPeriod() {
        return period;
    }



}
