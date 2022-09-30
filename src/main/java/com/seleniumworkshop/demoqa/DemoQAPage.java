package com.seleniumworkshop.demoqa;

import com.fasterxml.jackson.databind.ser.Serializers;
import com.seleniumworkshop.BasePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DemoQAPage extends BasePage {


    @FindBy(xpath = "//div[@id='draggable']")
    private WebElement draggableComponent;

    @FindBy(xpath = "//div[@id='simpleDropContainer']//div[@id='droppable']")
    protected WebElement droppableComponent;

    public DemoQAPage(final WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void launchSite() {
        this.driver.get("https://demoqa.com/droppable");
    }

    public void dragElementToDrop() {
        Actions actions = new Actions(this.driver);
        actions.dragAndDrop(draggableComponent, droppableComponent).build().perform();
    }

    public boolean droppableChange() {
        return droppableComponent.getAttribute("class").contains("ui-state-highlight");
    }

    public void highlightDroppable() {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) this.driver;
        jsExecutor.executeScript("arguments[0].style.background='yellow'", droppableComponent);
    }

}
