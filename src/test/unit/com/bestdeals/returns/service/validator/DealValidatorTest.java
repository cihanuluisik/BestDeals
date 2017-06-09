package com.bestdeals.returns.service.validator;

import com.bestdeals.returns.domain.Deal;
import com.bestdeals.returns.domain.enums.DealType;
import com.bestdeals.returns.domain.enums.IntervalType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collection;

import static com.bestdeals.returns.service.validator.BaseValidator.ERR_MSG_AMOUNT_CAN_NOT_BE_EMPTY;
import static com.bestdeals.returns.service.validator.BaseValidator.ERR_MSG_CURRENCY_CAN_NOT_BE_EMPTY;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

@RunWith(Parameterized.class)
public class DealValidatorTest {

    DealValidator dealValidator = new DealValidator();


    public DealValidatorTest(DealType dealType, String currency, BigDecimal amount, IntervalType intervalType, Double rate, Integer period, String message) {
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
                 { null,            "GBP"   , BigDecimal.TEN, IntervalType.none, 2.0, 1, DealValidator.ERR_MSG_DEAL_TYPE_CAN_NOT_BE_EMPTY}
                ,{ DealType.Annual, null    , BigDecimal.TEN, IntervalType.none, 2.0, 1, ERR_MSG_CURRENCY_CAN_NOT_BE_EMPTY}
                ,{ DealType.Annual, "GBP"    , null         , IntervalType.none, 2.0, 1, ERR_MSG_AMOUNT_CAN_NOT_BE_EMPTY}
                ,{ DealType.Annual, "GBP"    ,BigDecimal.TEN, null             , 2.0, 1, DealValidator.ERR_MSG_INTERVAL_TYPE_CAN_NOT_BE_EMPTY}
                ,{ DealType.Annual, "GBP"    ,BigDecimal.TEN, IntervalType.none, -2.0, 1, DealValidator.ERR_MSG_RATE_MUST_BE_NON_NEGATIVE}
                ,{ DealType.Annual, "GBP"    ,BigDecimal.TEN, IntervalType.none, 0.0, 1,  DealValidator.ERR_MSG_RATE_MUST_BE_NON_NEGATIVE}
                ,{ DealType.Annual, "GBP"    ,BigDecimal.TEN, IntervalType.none, 0.123, 1, DealValidator.ERR_MSG_RATE_MUST_HAVE_TWO_DECIMALS}
                ,{ DealType.Annual, "GBP"    ,BigDecimal.TEN, IntervalType.none, 1.9, 0, DealValidator.ERR_MSG_PERIOD_MUST_BE_GREATER_THAN_ZERO}
        });
    }

    @Test
    public void givenADoubleWhenRoundedThenReturnsExpected() {
        Deal deal = new Deal(dealType, currency, amount, intervalType, rate, period);
        assertThat(catchThrowable(() -> dealValidator.validateDeal(deal)))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(message);
    }


}