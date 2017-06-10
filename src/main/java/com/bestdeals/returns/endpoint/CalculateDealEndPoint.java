package com.bestdeals.returns.endpoint;

import com.bestdeals.returns.domain.Deal;
import com.bestdeals.returns.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;


public class CalculateDealEndPoint implements CalculateDeal {

    private final CalculatorService calculatorService;

    @Autowired
    public CalculateDealEndPoint(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @Override
    public BigDecimal calculateReturn(Deal deal) {
        BigDecimal interestReturnInUsd = calculatorService.calculateReturnForDeal(deal);
        return interestReturnInUsd;
    }


}
