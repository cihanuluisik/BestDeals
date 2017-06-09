package com.bestdeals.returns.service;

import com.bestdeals.ReturnCalculatorApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration( classes = ReturnCalculatorApplication.class)
public class FxConverterServiceIntegrationTest {

    @Autowired
    FxConverterService fxConverterService;

    @Test
    public void givenNonExistingCurrencyThenConvertToUsdReturnsTheGivenAmount() throws Exception {
        assertThat(catchThrowable(() -> fxConverterService.convertToUsd("XXXXXXX ", BigDecimal.TEN)))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("Currency is not found");
    }


}