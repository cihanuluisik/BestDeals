package com.bestdeals.returns.service.validator;

public abstract  class BaseValidator {
    protected void throwIllegalIfTrue(boolean check, String errorMessage) {
        if (check)  {
            throw new IllegalArgumentException(errorMessage);
        }
    }

}
