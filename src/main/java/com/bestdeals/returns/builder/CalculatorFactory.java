package com.bestdeals.returns.builder;


import com.bestdeals.returns.calculator.Calculator;
import com.bestdeals.returns.calculator.CalculatorAnnualSimple;
import com.bestdeals.returns.calculator.CalculatorSimpleCompound;
import com.bestdeals.returns.endpoint.CalculateParams;
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
