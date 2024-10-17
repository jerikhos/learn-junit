package com.jerikho.learnjunit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;

public class BankAccountConditionalTest {

    @Test
    @EnabledOnOs({OS.MAC})
    void testMac() {

    }

    @Test
    @EnabledOnOs({OS.WINDOWS})
    void testWindows() {

    }

    @Test
    @EnabledOnOs({OS.LINUX})
    void testLinux() {

    }

    @Test
    @EnabledOnJre({JRE.JAVA_21})
    void testJRE21() {

    }

    @Test
    @DisabledOnJre({JRE.JAVA_21})
    void testNoJRE21() {

    }


}
