package com.bestdeals.returns.service;

import com.bestdeals.returns.domain.Deal;

import java.math.BigDecimal;

/**
 * Created on 10/06/2017.
 */
public interface CalculatorService {
    BigDecimal calculateReturnForDeal(Deal deal);

    BigDecimal calculateAllReturnsForClientDeals(Integer clientId);
}
