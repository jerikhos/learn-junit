package com.jerikho.learnjunit;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Test to use nested test on BankAccount Class")
class BankAccountNestedTest {
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

    @Nested
    class whenBalanceEqualsZero {
        @Test
        @DisplayName("Withdrawing below minimum balance: exception")
        void testWithdrawMinimumBalanceIs0() {
            BankAccount bankAccount = new BankAccount(0, 0);
            assertThrows(RuntimeException.class, () -> bankAccount.withdraw(500));
        }

        @Test
        @DisplayName("Withdrawing and getting a negative balance")
        void testWithdrawMinimumBalanceNegative1000() {
            BankAccount bankAccount = new BankAccount(0, -1000);
            bankAccount.withdraw(500);
            assertEquals(-500, bankAccount.getBalance());
        }
    }
}
