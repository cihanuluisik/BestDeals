package com.bestdeals.returns.service;

import com.bestdeals.returns.domain.Deal;
import com.bestdeals.returns.repository.DealRepository;
import com.bestdeals.returns.service.calculator.BaseCalculator;
import com.bestdeals.returns.service.calculator.factory.CalculatorFactory;
import com.bestdeals.returns.service.validator.ClientValidator;
import com.bestdeals.returns.service.validator.DealValidator;
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
    private final DealValidator dealValidator;
    private final ClientValidator clientValidator;

    @Autowired
    public CalculatorService(CalculatorFactory calculatorFactory, FxConverterService fxConverterService
                            , DealRepository dealRepository, Rounder rounder, DealValidator dealValidator, ClientValidator clientValidator) {
        this.calculatorFactory = calculatorFactory;
        this.fxConverterService = fxConverterService;
        this.dealRepository = dealRepository;
        this.rounder = rounder;
        this.dealValidator = dealValidator;
        this.clientValidator = clientValidator;
    }

    public BigDecimal calculateReturnForDeal(Deal deal){

        dealValidator.validateDeal(deal);

        BaseCalculator calculator           = calculatorFactory.newCalculator(deal);

        BigDecimal calculatedReturn     = calculator.calculate();

        BigDecimal returnInUsd          = fxConverterService.convertToUsd(deal.getCurrency(), calculatedReturn);

        BigDecimal returnInUsdRounded   = rounder.roundTo2Decimal(returnInUsd);

        return returnInUsdRounded;
    }

    public BigDecimal calculateAllReturnsForClientDeals(Integer clientId) {

        clientValidator.validateClientId(clientId);

        List<Deal> deals = dealRepository.findByClientId(clientId);

        BigDecimal totalInUsd = deals.stream()
                                    .map(this::calculateReturnForDeal)
                                    .reduce(BigDecimal.ZERO, BigDecimal::add);
        return totalInUsd;
    }

}

