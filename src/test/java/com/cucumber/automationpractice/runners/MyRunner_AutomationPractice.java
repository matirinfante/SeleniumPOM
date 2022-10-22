package com.cucumber.automationpractice.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(tags = "", features = {"src/test/resources/features/AutomationPractice/AutomationPractice.feature"}, glue = {"com.cucumber.automationpractice.stepDefinition"},
        plugin = {})

public class MyRunner_AutomationPractice extends AbstractTestNGCucumberTests {

}
