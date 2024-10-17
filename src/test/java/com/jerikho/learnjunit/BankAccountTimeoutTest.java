package com.jerikho.learnjunit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.extension.ExtendWith;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(BankAccountParameterResolver.class)
class BankAccountTimeoutTest {

    @Test
    @Timeout(value = 500, unit = TimeUnit.MILLISECONDS)
    void testDepositTimeoutAssertion(BankAccount bankAccount) {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        bankAccount.deposit(300);
        assertEquals(300, bankAccount.getBalance());
    }

    @Test
    void testDepositTimeoutAnnotation(BankAccount bankAccount) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        bankAccount.deposit(300);

        assertTimeout(
                Duration.ofMillis(500), () -> {
                    Thread.sleep(10);
                }
        );
    }
}
