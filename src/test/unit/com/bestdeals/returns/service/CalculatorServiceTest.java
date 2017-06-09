package com.bestdeals.returns.service;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

public class CalculatorServiceTest {

    @Test
    public void givenNullDealThenCalculateReturnShouldReturnZero() throws Exception {
        assertThat(catchThrowable(() -> new CalculatorService(null, null, null, null).calculateReturnForDeal(null) ))
                                    .isInstanceOf(NullPointerException.class);
    }


}