package com.bestdeals.repository;


import com.bestdeals.ReturnCalculatorApplication;
import com.bestdeals.returns.domain.Client;
import com.bestdeals.returns.repository.ClientRepository;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
@ContextConfiguration(classes = ReturnCalculatorApplication.class)
public class ClientRepositoryIntegrationTest {

    @Autowired
    private ClientRepository clientRepository;


    @Test
    public void givenTheSameNameSurnameTwiceForDifferentClientsShouldGiveConstraintError() throws Exception {

        Client client = new Client(1, "alex", "carter");

        clientRepository.save(client);

        assertThat(Assertions.catchThrowable(() -> {
                    clientRepository.save(new Client(2, "alex", "carter"));
                    clientRepository.findAll();
                }

        ))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("ConstraintViolationException");
    }


}
