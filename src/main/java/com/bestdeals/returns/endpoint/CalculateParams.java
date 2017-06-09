package com.bestdeals.returns.endpoint;

import com.bestdeals.returns.domain.enums.DealType;
import com.bestdeals.returns.domain.enums.IntervalType;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class CalculateParams {
    private DealType dealType;
    private String currency;
    private BigDecimal amount;
    private IntervalType intervalType;
    private Double rate;
    private Integer period;


    public CalculateParams() {
    }

    public CalculateParams(DealType dealType, String currency, BigDecimal amount, IntervalType intervalType, Double rate, Integer period) {
        this.dealType = dealType;
        this.currency       = currency;
        this.amount         = amount;
        this.intervalType = intervalType;
        this.rate           = rate;
        this.period         = period;
    }

    public DealType getDealType() {
        return dealType;
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

    public IntervalType getIntervalType() {
        return intervalType;
    }

    public Double getRate() {
        return rate;
    }

    public Integer getPeriod() {
        return period;
    }



}
