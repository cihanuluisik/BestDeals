package com.bestdeals.returns.repository;

import com.bestdeals.returns.domain.FxRate;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Optional;

@Component
public interface FxRateRepository extends CrudRepository<FxRate, Integer> {
    Optional<FxRate> findByCurrencyAndDate(String currency, LocalDate date);
}
