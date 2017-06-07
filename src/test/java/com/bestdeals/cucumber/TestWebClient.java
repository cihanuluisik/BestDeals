package com.bestdeals.cucumber;

import com.bestdeals.returns.endpoint.CalculateParams;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

@Lazy
@Component
public class TestWebClient {

    @Value("${local.server.port}")
    private String port;

    private final Client client = ClientBuilder.newClient();
    private WebTarget target;

    public <T> T callCalculate(CalculateParams entity, Class<T> returnType, String servicePath) {
        target = client.target("http://localhost:"+ port+ servicePath);
        return target.request(MediaType.APPLICATION_JSON_TYPE)
                                        .post(Entity.entity(entity,  MediaType.APPLICATION_JSON_TYPE))
                                        .readEntity(returnType);
    }


}
