package com.bestdeals.returns.endpoint;

import com.bestdeals.returns.domain.Deal;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.math.BigDecimal;

@Path("/calculate")
public interface CalculateDeal {
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    BigDecimal calculateReturn(Deal deal);
}
