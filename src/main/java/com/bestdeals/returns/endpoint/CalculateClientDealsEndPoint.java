package com.bestdeals.returns.endpoint;

import com.bestdeals.returns.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.math.BigDecimal;
@Path("/calculate/all/client/{id}")
public class CalculateClientDealsEndPoint {

    private final CalculatorService calculatorService;

    @Autowired
    public CalculateClientDealsEndPoint(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public BigDecimal calculateClientDeals(@PathParam("id") Integer clientId) {
        BigDecimal interestReturn = calculatorService.calculateAllReturnsForClientDeals(clientId);
        return interestReturn;
    }


}