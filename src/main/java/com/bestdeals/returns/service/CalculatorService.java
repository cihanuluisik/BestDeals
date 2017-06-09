package com.bestdeals.returns.service;

import com.bestdeals.returns.domain.Deal;
import com.bestdeals.returns.endpoint.CalculateParams;
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

    public BigDecimal calculateAndConvertToUsd(CalculateParams calculateParams){

        Calculator calculator           = calculatorFactory.newCalculator(calculateParams);

        BigDecimal calculatedReturn     = calculator.calculate();

        BigDecimal returnInUsd          = fxConverterService.convertToUsd(calculateParams.getCurrency(), calculatedReturn);

        BigDecimal returnInUsdRounded   = rounder.roundTo2Decimal(returnInUsd);

        return returnInUsdRounded;
    }


    public BigDecimal calculateAllReturnsForClient(Integer cliientId) {
        List<Deal> deals = dealRepository.findByClientId(cliientId);
        BigDecimal total = BigDecimal.ZERO;
        for (Deal deal : deals) {
            CalculateParams params = new CalculateParams(deal.getDealType(), deal.getCurrency(), deal.getAmount(), deal.getIntervalType(), deal.getRate(), deal.getPeriod());
            total = total.add(calculateAndConvertToUsd(params));
        }
        return total;
    }
}

