package com.testing.runner;

import org.testng.TestNG;

import java.util.ArrayList;
import java.util.List;

public class TestRunner {
    public static void main(String[] args) {
        TestNG testng = new TestNG();

        // Create list of test classes
        List<Class<?>> testClasses = new ArrayList<>();
        testClasses.add(com.testing.tests.retrofit.BoardTestsRetrofit.class);
        testClasses.add(com.testing.tests.restassured.boardTestsRestAssured.class);
        testClasses.add(com.testing.tests.okhttp.BoardTestsOkHttp.class);


        testng.setTestClasses(testClasses.toArray(new Class[0]));

        // Add Allure listener
        testng.addListener(new io.qameta.allure.testng.AllureTestNg());

        System.out.println("Starting TestNG Execution...");
        System.out.println("Running " + testClasses.size() + " test classes");

        testng.run();

        boolean success = !testng.hasFailure() && !testng.hasSkip();
        System.out.println("Execution completed! " + (success ? "ALL TESTS PASSED" : "SOME TESTS FAILED"));

        System.exit(success ? 0 : 1);
    }
}

/*Notes for me
TestRunner (Application config): Good for debugging, custom test execution logic

Debugging multiple test classes at once

Custom test execution logic

Running specific test patterns programmatically

Integration with other tools*/