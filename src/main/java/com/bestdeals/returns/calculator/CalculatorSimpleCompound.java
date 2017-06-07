package com.bestdeals.returns.calculator;

import com.bestdeals.returns.domain.Interval;

import java.math.BigDecimal;
import java.math.MathContext;

public class CalculatorSimpleCompound extends Calculator {

    private final int intervalValue;

    public CalculatorSimpleCompound(BigDecimal amount, Double rate, Integer period, Interval interval) {
        super(amount, period, rate);
        this.intervalValue   = interval.getValue();
    }

    @Override
    public BigDecimal calculate() {
        return  BigDecimal.ONE
                .add(percentRate.divide(BigDecimal.valueOf(intervalValue), MathContext.DECIMAL32))
                .pow(intervalValue * period)
                .subtract(BigDecimal.ONE)
                .multiply(amount);
    }

}
