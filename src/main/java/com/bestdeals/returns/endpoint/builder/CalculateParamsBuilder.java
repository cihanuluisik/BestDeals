package com.bestdeals.returns.endpoint.builder;

import com.bestdeals.returns.domain.enums.DealType;
import com.bestdeals.returns.domain.enums.IntervalType;
import com.bestdeals.returns.endpoint.CalculateParams;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class CalculateParamsBuilder {

    private String currency;
    private BigDecimal amount;
    private Double rate;
    private Integer period;
    private IntervalType intervalType;
    private DealType dealType;

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

    public CalculateParamsBuilder withInterval(IntervalType intervalType) {

        this.intervalType = intervalType;
        return this;
    }

    public CalculateParams build() {
        return new CalculateParams(dealType, currency, amount, intervalType, rate, period);
    }

    public CalculateParamsBuilder withDeal(DealType dealType) {

        this.dealType = dealType;
        return this;
    }
}
