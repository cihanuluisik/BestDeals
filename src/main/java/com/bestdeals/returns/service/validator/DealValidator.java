package com.bestdeals.returns.service.validator;

import com.bestdeals.returns.domain.Deal;
import org.springframework.stereotype.Component;

@Component
public class DealValidator extends BaseValidator {

    public static final String ERR_MSG_DEAL_TYPE_CAN_NOT_BE_EMPTY = "Deal type can not be empty";
    public static final String ERR_MSG_INTERVAL_TYPE_CAN_NOT_BE_EMPTY = "Interval type can not be empty";
    public static final String ERR_MSG_RATE_MUST_BE_NON_NEGATIVE = "Rate must be non negative";
    public static final String ERR_MSG_RATE_MUST_HAVE_TWO_DECIMALS = "Rate must have two decimals";
    public static final String ERR_MSG_PERIOD_MUST_BE_GREATER_THAN_ZERO = "Period must be greater than zero";
    public static final String ERR_MSG_DEAL_CAN_NOT_BE_EMPTY = "Deal can not be empty";

    public void validateDeal(Deal deal) {
        throwIllegalIfTrue(deal ==null,                     ERR_MSG_DEAL_CAN_NOT_BE_EMPTY);
        throwIllegalIfTrue(deal.getDealType() ==null,      ERR_MSG_DEAL_TYPE_CAN_NOT_BE_EMPTY);
        throwIllegalIfTrue(deal.getCurrency()==null,      ERR_MSG_CURRENCY_CAN_NOT_BE_EMPTY);
        throwIllegalIfTrue(deal.getAmount()==null,        ERR_MSG_AMOUNT_CAN_NOT_BE_EMPTY);
        throwIllegalIfTrue(deal.getIntervalType() ==null, ERR_MSG_INTERVAL_TYPE_CAN_NOT_BE_EMPTY);
        throwIllegalIfTrue(deal.getRate() <= 0,           ERR_MSG_RATE_MUST_BE_NON_NEGATIVE);
        throwIllegalIfTrue(deal.getRate() * 100 - Math.round( deal.getRate() * 100 ) >  0, ERR_MSG_RATE_MUST_HAVE_TWO_DECIMALS);
        throwIllegalIfTrue(deal.getPeriod() < 1,          ERR_MSG_PERIOD_MUST_BE_GREATER_THAN_ZERO);
    }

}
