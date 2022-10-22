package com.cucumber.demoQA.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(tags = "", features = {"src/test/resources/features/"}, glue = {"com.cucumber.demoQA.stepDefinition", "com.cucumber.automationpractice.stepDefinition"},
        plugin = {"pretty", "html:target/report.html"})

public class MyRunner_DemoQA extends AbstractTestNGCucumberTests {

}

