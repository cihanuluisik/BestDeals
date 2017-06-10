package com.bestdeals.returns.endpoint;

import com.bestdeals.returns.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

public class CalculateClientDealsEndPoint implements CalculateClientDeals {

    private final CalculatorService calculatorService;

    @Autowired
    public CalculateClientDealsEndPoint(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @Override
    public BigDecimal calculateClientDeals(Integer clientId) {
        BigDecimal interestReturn = calculatorService.calculateAllReturnsForClientDeals(clientId);
        return interestReturn;
    }


}
