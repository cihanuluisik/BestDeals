package com.bestdeals.cucumber.end2end;

import com.bestdeals.returns.domain.Deal;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.math.BigDecimal;

@Lazy
@Component
public class TestWebClient {

    @Value("${local.server.port}")
    private String port;

    private final Client client = ClientBuilder.newClient();
    private WebTarget target;

    public BigDecimal callCalculate(String servicePath, Deal entity) {
        target = client.target("http://localhost:"+ port+ servicePath);
        return target.request(MediaType.APPLICATION_JSON_TYPE)
                                        .post(Entity.entity(entity,  MediaType.APPLICATION_JSON_TYPE))
                                        .readEntity(BigDecimal.class);
    }


    public BigDecimal callCalculateAll(String servicePath, String clientId) {
        target = client.target("http://localhost:"+ port+ servicePath+ "/id/"+clientId);
        return target.request(MediaType.APPLICATION_JSON_TYPE).get().readEntity(BigDecimal.class);
    }
}
