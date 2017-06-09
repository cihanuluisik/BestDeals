package com.bestdeals.returns.service;

import com.bestdeals.returns.domain.Deal;
import com.bestdeals.returns.repository.DealRepository;
import com.bestdeals.returns.service.calculator.Calculator;
import com.bestdeals.returns.service.calculator.Rounder;
import com.bestdeals.returns.service.calculator.factory.CalculatorFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class CalculatorService {

    private final CalculatorFactory calculatorFactory;
    private final FxConverterService fxConverterService;
    private final DealRepository dealRepository;
    private final Rounder rounder;
    private final Validator validator;

    @Autowired
    public CalculatorService(CalculatorFactory calculatorFactory, FxConverterService fxConverterService
                            , DealRepository dealRepository, Rounder rounder, Validator validator) {
        this.calculatorFactory = calculatorFactory;
        this.fxConverterService = fxConverterService;
        this.dealRepository = dealRepository;
        this.rounder = rounder;
        this.validator = validator;
    }

    public BigDecimal calculateReturnForDeal(Deal deal){

        validator.validateDeal(deal);

        Calculator calculator           = calculatorFactory.newCalculator(deal);

        BigDecimal calculatedReturn     = calculator.calculate();

        BigDecimal returnInUsd          = fxConverterService.convertToUsd(deal.getCurrency(), calculatedReturn);

        BigDecimal returnInUsdRounded   = rounder.roundTo2Decimal(returnInUsd);

        return returnInUsdRounded;
    }

    public BigDecimal calculateAllReturnsForClientDeals(Integer clientId) {

        validator.validateClientId(clientId);

        List<Deal> deals = dealRepository.findByClientId(clientId);

        BigDecimal totalInUsd = deals.stream()
                                    .map(this::calculateReturnForDeal)
                                    .reduce(BigDecimal.ZERO, BigDecimal::add);
        return totalInUsd;
    }

}

