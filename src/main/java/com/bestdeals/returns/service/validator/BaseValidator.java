package com.bestdeals.returns.service.validator;

public abstract  class BaseValidator {

    public static final String ERR_MSG_CURRENCY_CAN_NOT_BE_EMPTY = "Currency can not be empty";
    public static final String ERR_MSG_AMOUNT_CAN_NOT_BE_EMPTY = "Amount can not be empty";

    protected void throwIllegalIfTrue(boolean check, String errorMessage) {
        if (check)  {
            throw new IllegalArgumentException(errorMessage);
        }
    }

}
