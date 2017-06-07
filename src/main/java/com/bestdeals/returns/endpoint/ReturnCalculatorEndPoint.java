package com.bestdeals.returns.endpoint;

import com.bestdeals.returns.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.math.BigDecimal;

@Path("/calculate")
public class ReturnCalculatorEndPoint {

    private final CalculatorService calculatorService;

    @Autowired
    public ReturnCalculatorEndPoint(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public BigDecimal calculateReturn(CalculateParams calculateParams) {

        BigDecimal interestReturn = calculatorService.calculateAndConvert(calculateParams);
        return interestReturn;
    }



}
