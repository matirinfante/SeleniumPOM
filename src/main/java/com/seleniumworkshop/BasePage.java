package com.seleniumworkshop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public abstract class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void performWait(int seconds) {
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
    }
}
