package com.seleniumworkshop.rahulshetty;

import com.seleniumworkshop.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PracticePage extends BasePage {

    @FindBy(xpath = "//table[@class='table-display']//tr")
    private List<WebElement> productTableRows;


    public void launchSite() {
        this.driver.get("https://rahulshettyacademy.com/AutomationPractice/");
    }

    public PracticePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void highlightRowByIndex(int index) {
        WebElement row = productTableRows.get(index);
        JavascriptExecutor jsExecutor = (JavascriptExecutor) this.driver;
        jsExecutor.executeScript("arguments[0].style.border='4px solid red'", row);
    }

    public int tableSize() {
        return productTableRows.size();
    }

    public void highlightByValue(String value) {
        List<WebElement> productTableRows = driver.findElements(By.xpath("//td[contains(text(),25)]//ancestor::tr"));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
//        productTableRows.
//        forEach(element -> jsExecutor.executeScript("arguments[0].style.background='yellow'", element));

        for (int i = 0; i < productTableRows.size(); i++) {
            jsExecutor.executeScript("arguments[0].style.background='yellow'", productTableRows.get(i));
        }
    }
}
