package com.jerikho.learnjunit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class BankAccountTestWithMockito {
    @Mock
    BankAccount bankAccount;

    @BeforeEach
    void setupMocks() {
        Mockito.when(bankAccount.getMinimumBalance()).thenReturn(100.0);
    }

    @Test
    void testMinimumBalance() {
        assertEquals(100.0, bankAccount.getMinimumBalance());
    }
}
