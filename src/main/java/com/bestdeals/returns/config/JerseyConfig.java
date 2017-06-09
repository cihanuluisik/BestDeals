package com.bestdeals.returns.config;

import com.bestdeals.returns.endpoint.CalculateClientDealsEndPoint;
import com.bestdeals.returns.endpoint.CalculateDealEndPoint;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

@Component
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        register(CalculateDealEndPoint.class);
        register(CalculateClientDealsEndPoint.class);
    }

}