package com.bestdeals.returns.service.validator;

import org.springframework.stereotype.Component;

@Component
public class ClientValidator extends BaseValidator {

    public static final String ERR_MSG_INVALID_CLIENT_ID = "Invalid client id";

    public void validateClientId(Integer clientId) {
        throwIllegalIfTrue(clientId <= 0, ERR_MSG_INVALID_CLIENT_ID);
    }

}
