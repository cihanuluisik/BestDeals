package com.bestdeals.returns.config;

import com.bestdeals.returns.endpoint.EndPointCalculateClientDeals;
import com.bestdeals.returns.endpoint.EndPointCalculateDeal;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

@Component
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        register(EndPointCalculateDeal.class);
        register(EndPointCalculateClientDeals.class);
    }

}