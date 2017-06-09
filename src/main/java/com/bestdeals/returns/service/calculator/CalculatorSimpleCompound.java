package com.bestdeals.returns.service.calculator;

import com.bestdeals.returns.domain.enums.IntervalType;

import java.math.BigDecimal;
import java.math.MathContext;

public class CalculatorSimpleCompound extends Calculator {

    private final int intervalValue;

    public CalculatorSimpleCompound(BigDecimal amount, Double rate, Integer period, IntervalType intervalType) {
        super(amount, period, rate);
        this.intervalValue   = intervalType.getValue();
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
