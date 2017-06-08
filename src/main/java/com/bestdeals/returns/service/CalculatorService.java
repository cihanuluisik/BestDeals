package com.bestdeals.returns.service;

import com.bestdeals.returns.endpoint.CalculateParams;
import com.bestdeals.returns.service.calculator.Calculator;
import com.bestdeals.returns.service.calculator.Rounder;
import com.bestdeals.returns.service.calculator.factory.CalculatorFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CalculatorService {

    private final CalculatorFactory calculatorFactory;
    private final FxConverterService fxConverterService;
    private final Rounder rounder;

    @Autowired
    public CalculatorService(CalculatorFactory calculatorFactory, FxConverterService fxConverterService, Rounder rounder) {
        this.calculatorFactory = calculatorFactory;
        this.fxConverterService = fxConverterService;
        this.rounder = rounder;
    }

    public BigDecimal calculateAndConvert(CalculateParams calculateParams){

        Calculator calculator           = calculatorFactory.newCalculator(calculateParams);

        BigDecimal calculatedReturn     = calculator.calculate();

        BigDecimal returnInUsd          = fxConverterService.convertToUsd(calculateParams.getCurrency(), calculatedReturn);

        BigDecimal returnInUsdRounded   = rounder.roundTo2Decimal(returnInUsd);

        return returnInUsdRounded;
    }

}
