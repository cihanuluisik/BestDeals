package com.bestdeals.returns.service.validator;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

public class ClientValidatorTest {


    private final ClientValidator clientValidator = new ClientValidator();

    @Test
    public void givenAnInvalidClientThenCalculateAllReturnsForClientDealsThrowsRuntime() throws Exception {
        assertThat(catchThrowable(() -> clientValidator.validateClientId(-1)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Invalid client id");
    }


}
