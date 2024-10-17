package com.jerikho.learnjunit;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(BankAccountParameterResolver.class)
class BankAccountDisabledTest {

    @Test
    @Disabled("Temporarily disabled due to maintenance")
    @DisplayName(("Deposit 500 successfully"))
    void testDeposit(BankAccount bankAccount) {
        assertEquals(500, bankAccount.deposit(500));
    }
}
