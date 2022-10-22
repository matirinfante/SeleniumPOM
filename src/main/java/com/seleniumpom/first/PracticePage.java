package com.seleniumpom.first;


import com.seleniumpom.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Optional;

public class PracticePage extends BasePage {

    private WebDriver driver;

    By pRadioButtons = By.xpath("//div[@id='radio-btn-example']//input");
    By pInputSuggestion = By.xpath("//input[@id='autocomplete']");
    By pSuggestion = By.xpath("//div[@class='ui-menu-item-wrapper']");
    By pDropdownSelect = By.xpath("//select[@id='dropdown-class-example']");

    By pOpenTabButton = By.xpath("//a[@id='opentab']");
    By pHomeButton = By.xpath("//button[contains(text(),'Home')]");
    By pPracticeButton = By.xpath("//button[contains(text(),'Practice')]");
    By pLoginButton = By.xpath("//button[contains(text(),'Login')]");
    By pSignupButton = By.xpath("//button[contains(text(),'Signup')]");

    By pHeaderButtons = By.xpath("//header//button[@class='btn btn-primary']");

    public PracticePage(final WebDriver driver) {
        super(driver);
    }

    public void launchSite(String url) {
        visit(url);
    }

    public void radioButtonSelect() {
        List<WebElement> radio = getElements(pRadioButtons);
        int radioIndex = randomInteger();
        System.out.println("El indice random es: " + radioIndex);
        WebElement radioSelected = radio.get(radioIndex - 1);
        click(radioSelected);
    }

    public void showRadioStatus() {
        List<WebElement> radioButtons = getElements(pRadioButtons);
        radioButtons.forEach((radio) -> {
                    if (isSelected(radio)) {
                        System.out.println("SELECTED RadioButton:" + getValue(radio));
                    } else {
                        System.out.println("NOT SELECTED RadioButton:" + getValue(radio));
                    }
                }
        );
    }

    public String printPlaceholder() {
        String suggestionPlaceholder = getPlaceholder(pInputSuggestion);
        System.out.println(suggestionPlaceholder);
        return suggestionPlaceholder;
    }

    public void typeAndSelectSuggestionText(String textToType) {
//        String textToType = "El Sal";
        type(pInputSuggestion, textToType);
        waitAndClick(pSuggestion);
    }

    public String getSuggestionValue() {
        String value = getValue(pInputSuggestion);
        System.out.println(value);
        return value;
    }

    public void selectDropdownOption(String value) {
        selectOption(pDropdownSelect, value);
    }

    public String getDropdownSelectedText() {
        String dropdownSelection = getFirstSelectedOption(pDropdownSelect);
        System.out.println(dropdownSelection);
        return dropdownSelection;
    }

    public String selectDropdownOption2() {
        selectOption(pDropdownSelect, 2);
        String dropdownSelection = getFirstSelectedOption(pDropdownSelect);
        System.out.println(dropdownSelection);
        return dropdownSelection;
    }

    public String selectDropdownOption3() {
        selectOptionNormal(pDropdownSelect, 3);
        String dropdownSelection = getFirstSelectedOptionNormal(pDropdownSelect);
        System.out.println(dropdownSelection);
        return dropdownSelection;
    }

    public void clickHeaderBtn(String buttonToClick) {
        List<WebElement> headerButtons = getElements(pHeaderButtons);
        WebElement btnSelected = headerButtons.stream().filter(element -> getText(element).equals(buttonToClick)).findFirst().get();
        click(btnSelected);
    }

    public void checkButtons() {
        String initialUrl = getUrl();
        checkButton(initialUrl, pHomeButton);
        checkButton(initialUrl, pPracticeButton);
        checkButton(initialUrl, pLoginButton);
        checkButton(initialUrl, pSignupButton);
    }

    private void checkButton(String initialUrl, By locator) {
        String buttonText = getText(locator);
        click(locator);
        String currentUrl = getUrl();
        boolean equalUrl = initialUrl.equals(currentUrl);
        System.out.println(((equalUrl) ? "Same URL" : "Different URL") + " - Btn: " + buttonText);
        if (!equalUrl) {
            goBack();
        }
    }

    public void tabsHandling(int times) {
        for (int i = 1; i < times; i++) {
            click(pOpenTabButton);
            backToParent();
        }
    }
    public int getNumberOfCurrentTabs() {
        return getOpenTabs();
    }

}
