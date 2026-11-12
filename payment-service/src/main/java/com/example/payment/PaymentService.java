
package com.example.payment;

import java.math.BigDecimal;

public class PaymentService {

    public BigDecimal calculateFee(BigDecimal amount) {
        if (amount == null || amount.signum() <= 0) {
            throw new IllegalArgumentException("Invalid amount");
        }

        return amount.multiply(new BigDecimal("0.01"));
    }
}
