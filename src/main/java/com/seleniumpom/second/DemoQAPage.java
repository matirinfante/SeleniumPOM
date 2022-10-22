package com.seleniumpom.second;

import com.seleniumpom.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DemoQAPage extends BasePage {

    By pFormCard = By.xpath("//div[@class='card-body']//h5[contains(text(),'Forms')]");

    public DemoQAPage(WebDriver driver) {
        super(driver);
    }

    public void launchSite(String url) {
        visit(url);
    }

    public String checkGoToForm() {
        click(pFormCard);
        return getUrl();
    }

    public void clickFormCard() {
        click(pFormCard);
    }
}
