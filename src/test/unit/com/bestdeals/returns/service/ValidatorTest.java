package com.bestdeals.returns.service;

import com.bestdeals.returns.domain.Deal;
import com.bestdeals.returns.domain.enums.DealType;
import com.bestdeals.returns.domain.enums.IntervalType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

@RunWith(Parameterized.class)
public class ValidatorTest {

    Validator validator = new Validator();


    public ValidatorTest(DealType dealType, String currency, BigDecimal amount, IntervalType intervalType, Double rate, Integer period, String message) {
        this.dealType = dealType;
        this.currency = currency;
        this.amount = amount;
        this.intervalType = intervalType;
        this.rate = rate;
        this.period = period;
        this.message = message;
    }

    private  DealType     dealType;
    private  String       currency;
    private  BigDecimal   amount;
    private  IntervalType intervalType;
    private  Double       rate;
    private  Integer      period;
    private  String        message;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                 { null,            "GBP"   , BigDecimal.TEN, IntervalType.none, 2.0, 1, "Deal type can not be empty"}
                ,{ DealType.Annual, null    , BigDecimal.TEN, IntervalType.none, 2.0, 1, "Currency can not be empty"}
                ,{ DealType.Annual, "GBP"    , null         , IntervalType.none, 2.0, 1, "Amount can not be empty"}
                ,{ DealType.Annual, "GBP"    ,BigDecimal.TEN, null             , 2.0, 1, "Interval type can not be empty"}
                ,{ DealType.Annual, "GBP"    ,BigDecimal.TEN, IntervalType.none, -2.0, 1,"Rate must be non negative"}
                ,{ DealType.Annual, "GBP"    ,BigDecimal.TEN, IntervalType.none, 0.0, 1, "Rate must be non negative"}
                ,{ DealType.Annual, "GBP"    ,BigDecimal.TEN, IntervalType.none, 0.123, 1,"Rate must have two decimals"}
                ,{ DealType.Annual, "GBP"    ,BigDecimal.TEN, IntervalType.none, 1.9, 0, "Period must be greater than zero"}
        });
    }

    @Test
    public void givenADoubleWhenRoundedThenReturnsExpected() {
        Deal deal = new Deal(dealType, currency, amount, intervalType, rate, period);
        assertThat(catchThrowable(() -> validator.validateDeal(deal)))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(message);
    }


}