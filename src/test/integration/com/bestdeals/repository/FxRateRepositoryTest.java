package com.bestdeals.repository;


import com.bestdeals.ReturnCalculatorApplication;
import com.bestdeals.returns.domain.FxRate;
import com.bestdeals.returns.repository.FxRateRepository;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
@ContextConfiguration(classes = ReturnCalculatorApplication.class)
public class FxRateRepositoryTest {

    @Autowired
    private FxRateRepository fxRateRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void givenARateExistsInRepoThenFindItByCurrencyAndDate() throws Exception {

        FxRate trlRateForToday = new FxRate("TRL", BigDecimal.valueOf(2.98), LocalDate.now());

        entityManager.persistAndFlush(trlRateForToday);

        FxRate rateFromDb = this.fxRateRepository.findByCurrencyAndDate(trlRateForToday.getCurrency(), trlRateForToday.getDate()).get();

        assertThat(rateFromDb).isEqualTo(trlRateForToday);
    }


    @Test
    public void givenTheSameRateToBeSavedShouldGiveConstraintError() throws Exception {

        FxRate trlRateForToday = new FxRate("TRL", BigDecimal.valueOf(2), LocalDate.now());

        fxRateRepository.save(trlRateForToday);

        assertThat(Assertions.catchThrowable(() -> fxRateRepository.save(new FxRate("TRL", BigDecimal.valueOf(1), LocalDate.now()))))
                                                        .isInstanceOf(RuntimeException.class)
                                                        .hasMessageContaining("ConstraintViolationException");
    }

}
