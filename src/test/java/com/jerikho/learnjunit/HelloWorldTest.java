package com.jerikho.learnjunit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HelloWorldTest {

    @Test
    void helloWorld() {
        HelloWorld helloWorld = new HelloWorld();
        assertEquals("Hello World!", helloWorld.helloWorld());
    }
}