package com.jerikho.learnjunit;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Execution(ExecutionMode.CONCURRENT)
@ExtendWith(BankAccountParameterResolver.class)
public class BankAccountParallelExecutionTest {

    @Test
    @DisplayName(("Deposit 500 successfully"))
    void testDeposit1(BankAccount bankAccount) {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        assertEquals(500, bankAccount.deposit(500));
    }

    @Test
    @DisplayName(("Deposit 500 successfully"))
    void testDeposit2(BankAccount bankAccount) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        assertEquals(500, bankAccount.deposit(500));
    }

    @Test
    @DisplayName(("Deposit 500 successfully"))
    void testDeposit3(BankAccount bankAccount) {
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        assertEquals(500, bankAccount.deposit(500));
    }
}
