package com.seleniumpom;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {

    protected WebDriver driver;

    @BeforeTest
    public void setup() {
        this.driver = WebDriverManager.chromedriver().create();
        this.driver.manage().window().maximize();
    }

    @AfterTest
    public void teardown() {
        this.driver.quit();
    }

}
