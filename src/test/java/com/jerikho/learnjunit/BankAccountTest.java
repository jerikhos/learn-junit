package com.jerikho.learnjunit;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Test BankAccount Class")
class BankAccountTest {
    @Test
    @DisplayName("Withdraw 4000 successfully")
    void testWithdraw() {
        BankAccount bankAccount = new BankAccount(5000, 100);
        assertEquals(4000, bankAccount.withdraw(1000));
    }

    @Test
    @DisplayName(("Deposit 1000 successfully"))
    void testDeposit() {
        BankAccount bankAccount = new BankAccount(5000, 100);
        assertEquals(6000, bankAccount.deposit(1000));
    }

    @Test
    @DisplayName("Withdraw will become negative")
    void testWithdrawNotStuckAtZero() {
        BankAccount bankAccount = new BankAccount(500, -1000);
        assertNotEquals(0, bankAccount.withdraw(800));
    }

    @Test
    @DisplayName("Test activation account after creation")
    void testActive() {
        BankAccount bankAccount = new BankAccount(500, 0);
        assertTrue(bankAccount.isActive());
    }

    @Test
    @DisplayName("Test set holder name")
    void testHolderNameSet() {
        BankAccount bankAccount = new BankAccount(500, 0);
        bankAccount.setHolderName("User1");
        assertNotNull(bankAccount.getHolderName());
        assertEquals("User1", bankAccount.getHolderName());
    }

    @Test
    @DisplayName("Test that we can't withdraw below minimum")
    void testNoWithdrawBelowMinimum() {
        BankAccount bankAccount = new BankAccount(500, -1000);
        assertThrows(RuntimeException.class, () -> bankAccount.withdraw(2000));
    }

    @Test
    @DisplayName(("Test no exceptions for withdraw deposit"))
    void testWithdrawANdDepositWithoutException() {
        BankAccount bankAccount = new BankAccount(500, -1000);
        assertAll(
                () -> bankAccount.deposit(200), () -> bankAccount.withdraw(450)
        );
    }

    @Test
    @DisplayName("Test speed deposit")
    void testDepositTimeout() {
        BankAccount bankAccount = new BankAccount(400, 0);
        assertTimeout(Duration.ofNanos(1), () -> bankAccount.deposit(200));
    }
}