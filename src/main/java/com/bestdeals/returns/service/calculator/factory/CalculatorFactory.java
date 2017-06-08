package com.bestdeals.returns.service.calculator.factory;


import com.bestdeals.returns.endpoint.CalculateParams;
import com.bestdeals.returns.service.calculator.Calculator;
import com.bestdeals.returns.service.calculator.CalculatorAnnualSimple;
import com.bestdeals.returns.service.calculator.CalculatorSimpleCompound;
import org.springframework.stereotype.Component;

@Component
public class CalculatorFactory {

    public Calculator newCalculator(CalculateParams calculateParams){
        switch (calculateParams.getDeal()){
            case  Simple: return new CalculatorSimpleCompound(calculateParams.getAmount(), calculateParams.getRate(), calculateParams.getPeriod(), calculateParams.getInterval());
            default     : return new CalculatorAnnualSimple(calculateParams.getAmount(), calculateParams.getRate(), calculateParams.getPeriod());
        }
    }


}
