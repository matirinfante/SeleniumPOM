package com.seleniumpom;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

public class BaseTest {

    protected WebDriver driver;


    public void setUp() {
        this.driver = WebDriverManager.edgedriver().create();
        this.driver.manage().window().maximize();
    }

    public WebDriver getDriver() {
        return this.driver;
    }

    @After
    public void teardown() {
        this.driver.quit();
    }

}
