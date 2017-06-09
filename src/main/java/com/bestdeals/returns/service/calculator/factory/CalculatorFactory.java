package com.bestdeals.returns.service.calculator.factory;


import com.bestdeals.returns.domain.Deal;
import com.bestdeals.returns.service.calculator.AnnualSimpleCalculator;
import com.bestdeals.returns.service.calculator.BaseCalculator;
import com.bestdeals.returns.service.calculator.SimpleCompoundCalculator;
import org.springframework.stereotype.Component;

@Component
public class CalculatorFactory {

    public BaseCalculator newCalculator(Deal deal){
        switch (deal.getDealType()){
            case  Simple: return new SimpleCompoundCalculator(deal.getAmount(), deal.getRate(), deal.getPeriod(), deal.getIntervalType());
            default     : return new AnnualSimpleCalculator(deal.getAmount(), deal.getRate(), deal.getPeriod());
        }
    }


}
