package com.jerikho.learnjunit;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(BankAccountParameterResolver.class)
@DisplayName("Test with repeated test")
class BankAccountRepeatedTest {
    @RepeatedTest(3)
    @DisplayName("Deposit 500 successfully")
    void testDeposit(BankAccount bankAccount) {
        assertEquals(500, bankAccount.deposit(500));
    }

    @RepeatedTest(3)
    @DisplayName("Deposit 500 successfully")
    void testDepositRepetitionInfo(BankAccount bankAccount, RepetitionInfo repetitionInfo) {
        assertEquals(500, bankAccount.deposit(500));
        System.out.println("Nr: " + repetitionInfo.getCurrentRepetition());
    }
}
