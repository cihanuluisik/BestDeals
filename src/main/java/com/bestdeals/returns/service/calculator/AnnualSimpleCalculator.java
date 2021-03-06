package com.bestdeals.returns.service.calculator;

import java.math.BigDecimal;

public class AnnualSimpleCalculator extends BaseCalculator {

    public AnnualSimpleCalculator(BigDecimal amount, Double rate, Integer period) {
        super(amount, period, rate);
    }

    @Override
    public BigDecimal calculate() {
        return  amount.multiply(percentRate).multiply( BigDecimal.valueOf(period)) ;
    }

}
