package com.bestdeals.returns.service.validator;

import org.junit.Test;

import static com.bestdeals.returns.service.validator.BaseValidator.ERR_MSG_CURRENCY_CAN_NOT_BE_EMPTY;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

public class CurrencyValidatorTest {


    private final CurrencyValidator currencyValidator = new CurrencyValidator();

    @Test
    public void givenEmptyCurrencyThenConvertToUsdThrowsIllegal() throws Exception {
        assertThat(catchThrowable(() -> currencyValidator.validateCurrency(null, null)))
                .isInstanceOf(RuntimeException.class)
                .hasMessage(ERR_MSG_CURRENCY_CAN_NOT_BE_EMPTY);
        assertThat(catchThrowable(() -> currencyValidator.validateCurrency("", null)))
                .isInstanceOf(RuntimeException.class)
                .hasMessage(ERR_MSG_CURRENCY_CAN_NOT_BE_EMPTY);
        assertThat(catchThrowable(() -> currencyValidator.validateCurrency(" ", null)))
                .isInstanceOf(RuntimeException.class)
                .hasMessage(ERR_MSG_CURRENCY_CAN_NOT_BE_EMPTY);
    }

    @Test
    public void givenEmptyAmountThenConvertToUsdThrowsIllegal() throws Exception {
        assertThat(catchThrowable(() -> currencyValidator.validateCurrency("USD", null)))
                .isInstanceOf(RuntimeException.class)
                .hasMessage(BaseValidator.ERR_MSG_AMOUNT_CAN_NOT_BE_EMPTY);
    }


}
