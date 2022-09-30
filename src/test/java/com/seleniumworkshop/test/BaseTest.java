package com.seleniumworkshop.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.Scanner;

public class BaseTest {

    protected WebDriver driver;

    @BeforeTest
    public void setup() {
        System.out.println("** SELECT BROWSER TO PERFORM THE TESTS **");
        System.out.println("1 - Chrome\n2 - Firefox\n 3 - Edge");
        //Scanner sc = new Scanner(System.in);
        //String option = sc.nextLine();
        String option = "1";
        switch (option) {
            case "2":
                this.driver = WebDriverManager.firefoxdriver().create();
                break;
            case "3":
                this.driver = WebDriverManager.edgedriver().create();
                break;
            default:
                this.driver = WebDriverManager.chromedriver().create();
                break;
        }
        driver.manage().window().maximize();
    }

    @AfterTest
    public void teardown() {
        this.driver.quit();
    }
}
