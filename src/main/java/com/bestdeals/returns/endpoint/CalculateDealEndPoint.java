package com.bestdeals.returns.endpoint;

import com.bestdeals.returns.domain.Deal;
import com.bestdeals.returns.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.math.BigDecimal;

@Path("/calculate")
public class CalculateDealEndPoint {

    private final CalculatorService calculatorService;

    @Autowired
    public CalculateDealEndPoint(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public BigDecimal calculateReturn(Deal deal) {
        BigDecimal interestReturnInUsd = calculatorService.calculateReturnForDeal(deal);
        return interestReturnInUsd;
    }


}
