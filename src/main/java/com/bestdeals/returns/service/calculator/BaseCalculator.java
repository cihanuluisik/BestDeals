package com.bestdeals.returns.service.calculator;

import java.math.BigDecimal;

public abstract class BaseCalculator {

    protected  BigDecimal percentRate;
    protected  BigDecimal amount;
    protected  Integer period;

    public BaseCalculator(BigDecimal amount, Integer period, Double rate) {
        this.amount         = amount;
        this.period = period;
        this.percentRate    = convertToPercentRate(rate);
    }

    public BaseCalculator() {
    }

    public abstract BigDecimal calculate();

    protected BigDecimal BIG_DECIMAL_HUNDRED = BigDecimal.valueOf(100);

    protected BigDecimal convertToPercentRate(Double rate) {
        return BigDecimal.valueOf(rate).divide(BIG_DECIMAL_HUNDRED);
    }

}
