package com.bestdeals.returns.config;

import com.bestdeals.returns.endpoint.ReturnCalculatorEndPoint;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

@Component
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        register(ReturnCalculatorEndPoint.class);
    }

}