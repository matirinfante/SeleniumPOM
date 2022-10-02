package com.seleniumpom.second;

import com.seleniumpom.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FormPage extends BasePage {


    By pPracticeForm = By.xpath("//span[contains(text(),'Practice Form')]");

    public FormPage(WebDriver driver) {
        super(driver);
    }

    public String checkGoToPracticeForm() {
        click(pPracticeForm);
        return getUrl();
    }
}
