package com.bestdeals.returns.service;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

public class CalculatorServiceTest {

    private final CalculatorService calculatorService = new CalculatorService(null, null, null, null, new Validator());

    @Test
    public void givenNullDealThenCalculateReturnShouldReturnZero() throws Exception {
        assertThat(catchThrowable(() -> calculatorService.calculateReturnForDeal(null) ))
                                    .isInstanceOf(IllegalArgumentException.class)
                                    .hasMessage("Deal can not be empty");
    }



}