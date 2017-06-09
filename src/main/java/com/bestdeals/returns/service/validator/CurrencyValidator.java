package com.bestdeals.returns.service.validator;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class CurrencyValidator extends  BaseValidator{

    public static final String ERR_MSG_CURRENCY_IS_NOT_FOUND = "Currency is not found";

    public void validateCurrency(String currency, BigDecimal amount) {
        throwIllegalIfTrue(currency==null,                  ERR_MSG_CURRENCY_CAN_NOT_BE_EMPTY);
        throwIllegalIfTrue(currency.trim().equals(""),      ERR_MSG_CURRENCY_CAN_NOT_BE_EMPTY);
        throwIllegalIfTrue(amount==null,                    ERR_MSG_AMOUNT_CAN_NOT_BE_EMPTY);
    }
}
