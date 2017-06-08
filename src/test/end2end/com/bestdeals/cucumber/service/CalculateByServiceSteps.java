package com.bestdeals.cucumber.service;

import com.bestdeals.ReturnCalculatorApplication;
import com.bestdeals.returns.domain.Deal;
import com.bestdeals.returns.domain.FxRate;
import com.bestdeals.returns.domain.Interval;
import com.bestdeals.returns.endpoint.CalculateParams;
import com.bestdeals.returns.endpoint.builder.CalculateParamsBuilder;
import com.bestdeals.returns.repository.FxRateRepository;
import com.bestdeals.returns.service.CalculatorService;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration( classes = ReturnCalculatorApplication.class)
public class CalculateByServiceSteps {

    @Autowired
    private FxRateRepository fxRateRepository;

    @Autowired
    private CalculatorService calculatorService;

    @Autowired
    private CalculateParamsBuilder calculateParamsBuilder;


    @And("^Following cross usd fx rates exist for the day :$")
    public void followingCrossUsdFxRatesExistForTheDay(List<FxRate> testRates) throws Throwable {
        fxRateRepository.deleteAll();
        testRates.forEach(fxRate-> fxRate.setDate(LocalDate.now()));
        fxRateRepository.save(testRates);
    }

    @When("^I call calculator service with ([^\"]*) ([^\"]*) as amount$")
    public void iCallCalculatorServiceWithCurrencyAmountAmount(String currency, BigDecimal amount) throws Throwable {
        calculateParamsBuilder.withCurrency(currency).withAmount(amount);
    }

    @Given("^with annual rate ([^\"]*)$")
    public void annualRateRate(Double rate) throws Throwable {
        calculateParamsBuilder.withRate(rate);
    }

    @And("^with ([^\"]*) years period$")
    public void forPeriodYearsPeriod(Integer period) throws Throwable {
        calculateParamsBuilder.withPeriod(period);
    }

    @And("^with ([^\"]*) compound interval$")
    public void withIntervalCompoundInterval(Interval interval) throws Throwable {
        calculateParamsBuilder.withInterval(interval);
    }

    @Then("^the service should calculate to ([^\"]*) ([^\"]*) return for ([^\"]*) interest deal$")
    public void theServiceShouldCalculateToCurrencyReturnReturnForDealInterestDeal(BigDecimal usdReturn, String currency, Deal deal) throws Throwable {
        calculateParamsBuilder.withDeal(deal);
        CalculateParams calculateParams = calculateParamsBuilder.build();
        BigDecimal calculatedReturn = calculatorService.calculateAndConvert(calculateParams);
        assertThat(calculatedReturn.doubleValue()).isEqualTo(usdReturn.doubleValue());
    }

    @Given("^No rates exist$")
    public void noRatesExist() throws Throwable {
        fxRateRepository.deleteAll();
    }
}