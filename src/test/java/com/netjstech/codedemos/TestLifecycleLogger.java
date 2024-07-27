package com.netjstech.codedemos;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class TestLifecycleLogger {
    @BeforeAll
    void beforeAllTests() {
        System.out.println("Before all tests");
    }

    @AfterAll
    void afterAllTests() {
        System.out.println("After all tests");
    }
    @Test
    void testMethod() {
    	System.out.println("this is test method...");
    }
}

