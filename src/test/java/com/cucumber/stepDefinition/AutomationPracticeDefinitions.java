package com.cucumber.stepDefinition;

import com.seleniumpom.BaseTest;
import com.seleniumpom.first.PracticePage;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;


public class AutomationPracticeDefinitions {

    PracticePage practicePage;
    BaseTest baseTest;

    public AutomationPracticeDefinitions(BaseTest baseTest) {
        this.baseTest = baseTest;
    }

    @Before
    public void setupPage() {
        this.baseTest.setUp();
        practicePage = new PracticePage(this.baseTest.getDriver());
    }

    @Given("User is on homepage")
    public void visitSite() {
        practicePage.launchSite("https://rahulshettyacademy.com/AutomationPractice/");
    }

    @When("user clicks on a radio button")
    public void clicOnRadioButton() {
        practicePage.radioButtonSelect();
    }

    @Then("radio button status is changed")
    public void showRadioButtonStatus() {
        practicePage.showRadioStatus();
    }

    public void secondTest() throws InterruptedException {
        String placeholderText = practicePage.printPlaceholder();
        Assert.assertEquals(placeholderText, "Type to Select Countries");
        practicePage.typeAndSelectSuggestionText();
        String suggestionValue = practicePage.getSuggestionValue();
        Assert.assertEquals(suggestionValue, "El Salvador");
    }

    public void thirdTest() {
        String selectedText = practicePage.selectDropdownOption2();
        Assert.assertEquals(selectedText, "Option2");
        String newSelectedText = practicePage.selectDropdownOption3();
        Assert.assertEquals(newSelectedText, "Option3");
    }

    public void fourthTest() {
        practicePage.checkButtons();
    }

    public void fifthTest() {
        practicePage.tabsHandling();
    }
}

