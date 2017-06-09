package com.bestdeals.cucumber.end2end.all;

import com.bestdeals.ReturnCalculatorApplication;
import com.bestdeals.cucumber.end2end.TestWebClient;
import com.bestdeals.returns.domain.Client;
import com.bestdeals.returns.domain.Deal;
import com.bestdeals.returns.domain.FxRate;
import com.bestdeals.returns.repository.ClientRepository;
import com.bestdeals.returns.repository.DealRepository;
import com.bestdeals.returns.repository.FxRateRepository;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.assertj.core.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration( classes = ReturnCalculatorApplication.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CalculateAllByRestServiceSteps {

    @Autowired
    private TestWebClient testWebClient;

    @Autowired
    FxRateRepository fxRateRepository;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    DealRepository dealRepository;

    private Client client;
    private BigDecimal serviceResultAmount;

    @And("^Following cross usd fx rates exist :$")
    public void followingCrossUsdFxRatesExistForTheDay(List<FxRate> testRates) throws Throwable {
        fxRateRepository.deleteAll();
        testRates.forEach(fxRate-> fxRate.setDate(LocalDate.now()));
        fxRateRepository.save(testRates);
    }

    @And("^following client exists :$")
    public void followingCustomerExists(List<Client> clients) throws Throwable {
        this.client = clients.get(0);
        clientRepository.deleteAll();
        clientRepository.save(client);
    }

    @And("^following deals exist for the client :$")
    public void followingDealsExistForTheClient(List<Deal> deals) throws Throwable {
        dealRepository.deleteAll();
        deals.forEach( deal -> deal.setClientId(client.getId()));
        dealRepository.save(deals);
    }

    @When("^I call calculate all service with client id as parameter$")
    public void iCallCalculateAllServiceWithClientIdAsParameter() throws Throwable {
        serviceResultAmount = testWebClient.callCalculateAll("/calculate/all", client.getId() + "");
    }

    @Then("^the service should calculate to (.*) USD$")
    public void theServiceShouldCalculateToUSD(BigDecimal amountExpected) throws Throwable {
        Assertions.assertThat(serviceResultAmount).isEqualTo(amountExpected);
    }
}
