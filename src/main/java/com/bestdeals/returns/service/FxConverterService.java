package com.bestdeals.returns.service;

import com.bestdeals.returns.domain.FxRate;
import com.bestdeals.returns.repository.FxRateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;

@Service
public class FxConverterService {

    public static final FxRate UNIT_FX_RATE = new FxRate("USD", BigDecimal.ONE, LocalDate.now());
    private final FxRateRepository  fxRateRepository;

    @Autowired
    public FxConverterService(FxRateRepository fxRateRepository) {
        this.fxRateRepository = fxRateRepository;
    }

    public BigDecimal convertToUsd(String currency, BigDecimal amount){
        BigDecimal fxRate = getRate(currency);
        return amount.multiply(fxRate);
    }

    private BigDecimal getRate(String currency) {
        return fxRateRepository.findByCurrencyAndDate(currency, LocalDate.now())
                .orElse(UNIT_FX_RATE)
                .getRate();
    }

}
