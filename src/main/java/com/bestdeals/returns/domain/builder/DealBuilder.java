package com.bestdeals.returns.domain.builder;

import com.bestdeals.returns.domain.Deal;
import com.bestdeals.returns.domain.enums.DealType;
import com.bestdeals.returns.domain.enums.IntervalType;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class DealBuilder {

    private String currency;
    private BigDecimal amount;
    private Double rate;
    private Integer period;
    private IntervalType intervalType;
    private DealType dealType;

    public DealBuilder() {
    }

    public DealBuilder withCurrency(String currency) {
        this.currency = currency;
        return this;
    }

    public DealBuilder withAmount(BigDecimal amount) {

        this.amount = amount;
        return this;
    }

    public DealBuilder withRate(Double rate) {

        this.rate = rate;
        return this;
    }

    public DealBuilder withPeriod(Integer period) {
        this.period = period;
        return this;
    }

    public DealBuilder withInterval(IntervalType intervalType) {

        this.intervalType = intervalType;
        return this;
    }

    public Deal build() {
        return new Deal(dealType, currency, amount, intervalType, rate, period);
    }

    public DealBuilder withDeal(DealType dealType) {

        this.dealType = dealType;
        return this;
    }
}
