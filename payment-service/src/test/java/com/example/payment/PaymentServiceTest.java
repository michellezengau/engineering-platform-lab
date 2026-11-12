
package com.example.payment;

import org.junit.jupiter.api.Test;
import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class PaymentServiceTest {

    private final PaymentService paymentService =
            new PaymentService();

    @Test
    void shouldCalculateFee() {
        BigDecimal amount = new BigDecimal("100.00");

        BigDecimal fee = paymentService.calculateFee(amount);

        assertEquals(
                0,
                new BigDecimal("1.00").compareTo(fee)
        );
    }

    // add some comments
    @Test
    void shouldRejectInvalidAmount() {
        BigDecimal amount = new BigDecimal("-100");

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> paymentService.calculateFee(amount)
        );

        assertEquals("Invalid amount", exception.getMessage());
    }

    @Test
    void shouldRejectZeroAmount() {
        assertThrows(
                IllegalArgumentException.class,
                () -> paymentService.calculateFee(BigDecimal.ZERO)
        );
    }

    @Test
    void shouldFailIntentionally() {
        BigDecimal fee = paymentService.calculateFee(
                new BigDecimal("100")
        );

        assertEquals(
                0,
                new BigDecimal("999").compareTo(fee)
        );
    }
}
