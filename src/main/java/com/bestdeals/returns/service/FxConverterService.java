package com.bestdeals.returns.service;

import java.math.BigDecimal;

public interface FxConverterService {
    BigDecimal convertToUsd(String currency, BigDecimal amount);
}
