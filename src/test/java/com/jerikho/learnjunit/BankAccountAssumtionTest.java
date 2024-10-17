package com.jerikho.learnjunit;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Test Assumption on BankAccount Class")
class BankAccountAssumtionTest {

    @Test
    @DisplayName("Test activation account after creation")
    void testActive() {
        BankAccount bankAccount = new BankAccount(500, 0);
        assumingThat(bankAccount != null, () -> assertTrue(bankAccount.isActive()));
    }
}
