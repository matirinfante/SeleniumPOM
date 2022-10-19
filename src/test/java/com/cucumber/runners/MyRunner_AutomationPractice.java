package com.cucumber.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(tags = "", features = {"src/test/resources/features/AutomationPractice.feature"}, glue = {"com.cucumber.stepDefinition"},
        plugin = {})

public class MyRunner_AutomationPractice extends AbstractTestNGCucumberTests {

}
