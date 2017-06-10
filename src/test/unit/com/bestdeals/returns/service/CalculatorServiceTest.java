package com.bestdeals.returns.service;

import com.bestdeals.returns.service.validator.ClientValidator;
import com.bestdeals.returns.service.validator.DealValidator;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

public class CalculatorServiceTest {

    private final CalculatorService calculatorService = new CalculatorServiceImpl(null, null, null, null, new DealValidator(), new ClientValidator());

    @Test
    public void givenNullDealThenCalculateReturnShouldReturnZero() throws Exception {
        assertThat(catchThrowable(() -> calculatorService.calculateReturnForDeal(null) ))
                                    .isInstanceOf(IllegalArgumentException.class)
                                    .hasMessage(DealValidator.ERR_MSG_DEAL_CAN_NOT_BE_EMPTY);
    }


}