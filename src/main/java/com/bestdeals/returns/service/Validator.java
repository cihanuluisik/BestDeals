package com.bestdeals.returns.service;

import com.bestdeals.returns.domain.Deal;
import org.springframework.stereotype.Component;

@Component
public class Validator {

    void validateDeal(Deal deal) {

        throwErrorIfTrue(deal ==null,                   "Deal can not be empty");
        throwErrorIfTrue(deal.getDealType() ==null,      "Deal type can not be empty");
        throwErrorIfTrue(deal.getCurrency()==null,      "Currency can not be empty");
        throwErrorIfTrue(deal.getAmount()==null,        "Amount can not be empty");
        throwErrorIfTrue(deal.getIntervalType() ==null, "Interval type can not be empty");
        throwErrorIfTrue(deal.getRate() <= 0,           "Rate must be non negative");
        throwErrorIfTrue(deal.getRate() * 100 - Math.round( deal.getRate() * 100 ) >  0, "Rate must have two decimals");
        throwErrorIfTrue(deal.getPeriod() < 1,          "Period must be greater than zero");
    }

    private void throwErrorIfTrue(boolean check, String errorMessage) {
        if (check)  {
            throw new IllegalArgumentException(errorMessage);
        }
    }


}
