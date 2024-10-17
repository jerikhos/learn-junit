package com.jerikho.learnjunit;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.time.DayOfWeek;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(BankAccountParameterResolver.class)
@DisplayName("Test with parameterized test")
class BankAccountParameterizedTest {
    @ParameterizedTest
    @ValueSource(ints = {100, 400, 800, 1000})
    @DisplayName("Deposit some amount successfully")
    void testDeposit(int amount,BankAccount bankAccount) {
        assertEquals(amount, bankAccount.deposit(amount));
    }

    @ParameterizedTest
    @EnumSource(value = DayOfWeek.class, names = {"TUESDAY", "THURSDAY"})
    @DisplayName("Test days of the week that start with 'T'")
    void testDayOfWeek(DayOfWeek day) {
        assertTrue(day.toString().startsWith("T"));
    }

    @ParameterizedTest
    @CsvSource({"100, Mary", "200, Rachid", "150, Ted"})
    void depositAndNameTest(double amount, String name, BankAccount bankAccount) {
        bankAccount.deposit(amount);
        bankAccount.setHolderName(name);
        assertEquals(amount, bankAccount.getBalance());
        assertEquals(name, bankAccount.getHolderName());
    }

    @ParameterizedTest
    @CsvFileSource(resources = "details.csv")
    void depositAndNameTest2(double amount, String name, BankAccount bankAccount) {
        bankAccount.deposit(amount);
        bankAccount.setHolderName(name);
        assertEquals(amount, bankAccount.getBalance());
        assertEquals(name, bankAccount.getHolderName());
    }
}
