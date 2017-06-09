package com.bestdeals.returns.service.validator;

import org.springframework.stereotype.Component;

@Component
public class ClientValidator extends BaseValidator {


    public void validateClientId(Integer clientId) {
        throwIllegalIfTrue(clientId <= 0,           "Invalid client id");
    }

}
