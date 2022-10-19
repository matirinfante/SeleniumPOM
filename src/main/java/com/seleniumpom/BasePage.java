package com.seleniumpom;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.security.Key;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

public class BasePage {

    public static final int SECONDS = 20;

    protected WebDriver driver;
    private WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(SECONDS));

    }

    public void visit(String url) {
        this.driver.get(url);
    }

    protected void waitForVisibility(By locator) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (TimeoutException e) {
            Assert.fail(e.getMessage());
        }
    }

    protected void waitEnabled(By locator) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(locator));
        } catch (TimeoutException e) {
            Assert.fail(e.getMessage());
        }
    }

    protected void waitAndClick(By locator) {
        waitForVisibility(locator);
        this.driver.findElement(locator).click();
    }

    public WebElement getElement(By locator) {
        return this.driver.findElement(locator);
    }

    public List<WebElement> getElements(By locator) {
        return this.driver.findElements(locator);
    }

    public void click(By locator) {
        getElement(locator).click();
    }

    public void click(WebElement element) {
        element.click();
    }

    public int randomInteger() {
        Random random = new Random();
        return random.nextInt(3) + 1;
    }

    public boolean isSelected(By locator) {
        return this.driver.findElement(locator).isSelected();
    }

    public boolean isSelected(WebElement element) {
        return element.isSelected();
    }

    public String getText(By locator) {
        waitForVisibility(locator);
        return this.driver.findElement(locator).getText();
    }

    public String getValue(By locator) {
        waitForVisibility(locator);
        return this.driver.findElement(locator).getAttribute("value");
    }

    public String getValue(WebElement element) {
        return element.getAttribute("value");
    }

    public String getText(WebElement element) {
        return element.getText();
    }

    public String getPlaceholder(By locator) {
        return this.driver.findElement(locator).getAttribute("placeholder");
    }

    public void type(By locator, String text) {
        this.driver.findElement(locator).sendKeys(text);
    }

    public void typeKey(By locator, Keys key) {
        getElement(locator).sendKeys(key);
    }

    public void selectOption(By locator, int index) {
        Select select = new Select(this.driver.findElement(locator));
        select.selectByIndex(index);
    }

    public void selectOptionByValue(By locator, String value) {
        Select select = new Select(this.driver.findElement(locator));
        select.selectByValue(value);
    }

    public String getFirstSelectedOption(By locator) {
        Select select = new Select(this.driver.findElement(locator));
        WebElement webElement = select.getFirstSelectedOption();
        return webElement.getText();
    }

    public List<WebElement> getOptions(By locator) {
        Select select = new Select(this.driver.findElement(locator));
        return select.getOptions();
    }

    public void selectOptionNormal(By locator, int index) {
        WebElement webElement = this.driver.findElement(locator);
        webElement.click();

        for (int i = 0; i < index; i++) {
            webElement.sendKeys(Keys.ARROW_DOWN);
        }
        webElement.sendKeys(Keys.ENTER);
    }

    public String getFirstSelectedOptionNormal(By locator) {
        WebElement webElement = this.driver.findElement(locator);
        List<WebElement> options = webElement.findElements(By.tagName("option"));
        WebElement selected = (WebElement) options.stream().filter(WebElement::isSelected).findFirst().orElse(webElement);
        return selected.getText();
    }

    public String getUrl() {
        return this.driver.getCurrentUrl();
    }

    public void backToParent() {
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(0));
    }

    public int getOpenTabs() {
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        return tabs.size();
    }

    public void goBack() {
        this.driver.navigate().back();
    }

    public void hideElement(By locator) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement element = this.getElement(locator);
        js.executeScript("arguments[0].style = 'display:none'", element);
    }

    public void clickOnRadioByText(By locator, String radioText) {
        List<WebElement> radios = getElements(locator);
        for (WebElement radio : radios) {
            if (getValue(radio).equals(radioText)) {
                clickByExecutor(radio);
            }
        }
    }

    public void clickByExecutor(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()", element);
    }

    public void clickByExecutorAndDay(WebElement element, String day) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.querySelector('.react-datepicker__day.react-datepicker__day--0" + day + "').click()", element);

    }

    public void selectDropdownOption(By locator, int index) {
        WebElement element = getElement(locator);
        for (int i = 0; i < index; i++) {
            type(locator, "" + Keys.ARROW_DOWN);
        }
        type(locator, "" + Keys.ENTER);

    }
}
