package com.bestdeals.returns.domain;

public enum Interval {
    daily(365), monthly(12), quarterly(4),biannually(2), yearly(1),  none(-1);

    private final int value;

    Interval(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
