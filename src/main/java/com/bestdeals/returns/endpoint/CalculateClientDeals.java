package com.bestdeals.returns.endpoint;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.math.BigDecimal;

@Path("/calculate/all/client/{id}")
public interface CalculateClientDeals {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    BigDecimal calculateClientDeals(@PathParam("id") Integer clientId);
}
