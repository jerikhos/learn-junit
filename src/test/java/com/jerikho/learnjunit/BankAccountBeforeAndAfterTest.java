package com.jerikho.learnjunit;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BankAccountBeforeAndAfterTest {
    static BankAccount bankAccount;

    @BeforeAll
    public static void prepTest() {
        System.out.println("Hi!");
        bankAccount = new BankAccount(500, 0);
    }

//    @BeforeEach
//    public void prepTest() {
//        System.out.println("Hi!");
//        bankAccount = new BankAccount(500, 0);
//    }

    @Test
    void testWithdraw() {
        bankAccount.withdraw(300);
        assertEquals(200, bankAccount.getBalance());
    }

    @Test
     void testDeposit() {
        bankAccount.deposit(500);
        assertEquals(700, bankAccount.getBalance());
//        assertEquals(1000, bankAccount.getBalance());
    }

    @AfterAll
    public static void endTest() {
        System.out.println("Bye!");
    }
}
