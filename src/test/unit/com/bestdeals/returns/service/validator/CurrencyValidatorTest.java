package com.bestdeals.returns.service.validator;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

public class CurrencyValidatorTest {


    private final CurrencyValidator currencyValidator = new CurrencyValidator();

    @Test
    public void givenEmptyCurrencyThenConvertToUsdThrowsIllegal() throws Exception {
        assertThat(catchThrowable(() -> currencyValidator.validateCurrency(null, null)))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("Currency can not be empty");
        assertThat(catchThrowable(() -> currencyValidator.validateCurrency("", null)))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("Currency can not be empty");

        assertThat(catchThrowable(() -> currencyValidator.validateCurrency(" ", null)))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("Currency can not be empty");
    }

    @Test
    public void givenEmptyAmountThenConvertToUsdThrowsIllegal() throws Exception {
        assertThat(catchThrowable(() -> currencyValidator.validateCurrency("USD", null)))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("Amount can not be empty");
    }


}
