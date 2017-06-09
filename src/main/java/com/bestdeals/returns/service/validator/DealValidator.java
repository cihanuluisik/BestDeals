package com.bestdeals.returns.service.validator;

import com.bestdeals.returns.domain.Deal;
import org.springframework.stereotype.Component;

@Component
public class DealValidator extends BaseValidator {

    public void validateDeal(Deal deal) {
        throwIllegalIfTrue(deal ==null,                   "Deal can not be empty");
        throwIllegalIfTrue(deal.getDealType() ==null,      "Deal type can not be empty");
        throwIllegalIfTrue(deal.getCurrency()==null,      "Currency can not be empty");
        throwIllegalIfTrue(deal.getAmount()==null,        "Amount can not be empty");
        throwIllegalIfTrue(deal.getIntervalType() ==null, "Interval type can not be empty");
        throwIllegalIfTrue(deal.getRate() <= 0,           "Rate must be non negative");
        throwIllegalIfTrue(deal.getRate() * 100 - Math.round( deal.getRate() * 100 ) >  0, "Rate must have two decimals");
        throwIllegalIfTrue(deal.getPeriod() < 1,          "Period must be greater than zero");
    }

    public void validateClientId(Integer clientId) {
        throwIllegalIfTrue(clientId <= 0,           "Invalid client id");
    }

}
