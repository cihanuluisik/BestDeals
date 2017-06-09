package com.bestdeals.returns.service.validator;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class CurrencyValidator extends  BaseValidator{

    public void validateCurrency(String currency, BigDecimal amount) {
        throwIllegalIfTrue(currency==null,                   "Currency can not be empty");
        throwIllegalIfTrue(currency.trim().equals(""),       "Currency can not be empty");
        throwIllegalIfTrue(amount==null,                     "Amount can not be empty");
    }
}
