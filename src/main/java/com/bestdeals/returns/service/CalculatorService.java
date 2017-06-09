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

    @Autowired
    public CalculatorService(CalculatorFactory calculatorFactory, FxConverterService fxConverterService
                            , DealRepository dealRepository, Rounder rounder) {
        this.calculatorFactory = calculatorFactory;
        this.fxConverterService = fxConverterService;
        this.dealRepository = dealRepository;
        this.rounder = rounder;
    }

    public BigDecimal calculateReturnForDeal(Deal deal){

        Calculator calculator           = calculatorFactory.newCalculator(deal);

        BigDecimal calculatedReturn     = calculator.calculate();

        BigDecimal returnInUsd          = fxConverterService.convertToUsd(deal.getCurrency(), calculatedReturn);

        BigDecimal returnInUsdRounded   = rounder.roundTo2Decimal(returnInUsd);

        return returnInUsdRounded;
    }

    public BigDecimal calculateAllReturnsForClientDeals(Integer clientId) {
        List<Deal> deals = dealRepository.findByClientId(clientId);
        BigDecimal totalInUsd = BigDecimal.ZERO;
        for (Deal deal : deals) {
            totalInUsd = totalInUsd.add(calculateReturnForDeal(deal));
        }
        return totalInUsd;
    }
}

