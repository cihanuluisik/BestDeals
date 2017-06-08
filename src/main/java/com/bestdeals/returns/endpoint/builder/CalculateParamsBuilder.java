package com.bestdeals.returns.endpoint.builder;

import com.bestdeals.returns.domain.Deal;
import com.bestdeals.returns.domain.Interval;
import com.bestdeals.returns.endpoint.CalculateParams;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class CalculateParamsBuilder {

    private String currency;
    private BigDecimal amount;
    private Double rate;
    private Integer period;
    private Interval interval;
    private Deal deal;

    public CalculateParamsBuilder() {
    }

    public CalculateParamsBuilder withCurrency(String currency) {
        this.currency = currency;
        return this;
    }

    public CalculateParamsBuilder withAmount(BigDecimal amount) {

        this.amount = amount;
        return this;
    }

    public CalculateParamsBuilder withRate(Double rate) {

        this.rate = rate;
        return this;
    }

    public CalculateParamsBuilder withPeriod(Integer period) {
        this.period = period;
        return this;
    }

    public CalculateParamsBuilder withInterval(Interval interval) {

        this.interval = interval;
        return this;
    }

    public CalculateParams build() {
        return new CalculateParams(deal, currency, amount, interval, rate, period);
    }

    public CalculateParamsBuilder withDeal(Deal deal) {

        this.deal = deal;
        return this;
    }
}
