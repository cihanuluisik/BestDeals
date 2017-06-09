package com.bestdeals.returns.service.calculator.factory;


import com.bestdeals.returns.domain.Deal;
import com.bestdeals.returns.service.calculator.Calculator;
import com.bestdeals.returns.service.calculator.CalculatorAnnualSimple;
import com.bestdeals.returns.service.calculator.CalculatorSimpleCompound;
import org.springframework.stereotype.Component;

@Component
public class CalculatorFactory {

    public Calculator newCalculator(Deal deal){
        switch (deal.getDealType()){
            case  Simple: return new CalculatorSimpleCompound(deal.getAmount(), deal.getRate(), deal.getPeriod(), deal.getIntervalType());
            default     : return new CalculatorAnnualSimple(deal.getAmount(), deal.getRate(), deal.getPeriod());
        }
    }


}
