package com.bestdeals.returns.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(uniqueConstraints={@UniqueConstraint(columnNames = {"currency" , "date"})})
public class FxRate {

    @Id @GeneratedValue
    private Integer id;

    private String      currency;

    private BigDecimal  rate;

    private LocalDate   date = LocalDate.now();

    public FxRate() {
    }

    public FxRate(String currency, BigDecimal rate, LocalDate date) {
        this.currency = currency;
        this.rate = rate;
        this.date = date;
    }

    @Override
    public String toString() {
        return "FxRate{" +
                "currency='" + currency + '\'' +
                ", rate=" + rate +
                ", date=" + date +
                '}';
    }

    public String getCurrency() {
        return currency;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public LocalDate getDate() {
        return date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FxRate fxRate = (FxRate) o;
        return Objects.equals(currency, fxRate.currency) &&
                Objects.equals(rate, fxRate.rate) &&
                Objects.equals(date, fxRate.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(currency, rate, date);
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
