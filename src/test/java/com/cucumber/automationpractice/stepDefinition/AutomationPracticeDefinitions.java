package com.cucumber.automationpractice.stepDefinition;

import com.seleniumpom.BaseTest;
import com.seleniumpom.first.PracticePage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;


public class AutomationPracticeDefinitions {

    PracticePage practicePage;
    BaseTest baseTest;
    String url;

    public AutomationPracticeDefinitions(BaseTest baseTest) {
        this.baseTest = baseTest;
    }

    @Before("not @demoqa")
    public void setupPage(Scenario scenario) {
        this.url = "https://rahulshettyacademy.com/AutomationPractice/";
        this.baseTest.setUp(scenario);
        practicePage = new PracticePage(this.baseTest.getDriver());
    }

    @After("not @demoqa")
    public void teardown() {
        this.baseTest.teardown();
    }

    @Given("User is on homepage")
    public void visitSite() {
        practicePage.launchSite(url);
    }

    @When("user clicks on a radio button")
    public void clicOnRadioButton() {
        practicePage.radioButtonSelect();
    }

    @Then("radio button status is changed")
    public void showRadioButtonStatus() {
        practicePage.showRadioStatus();
    }

    @When("user types and selects {string}")
    public void userTypeAndSelect(String string) {
        String placeholderText = practicePage.printPlaceholder();
        Assert.assertEquals(placeholderText, "Type to Select Countries");
        practicePage.typeAndSelectSuggestionText(string);
    }

    @Then("search box should contain {string}")
    public void verifySearchBoxText(String string) {
        String suggestionValue = practicePage.getSuggestionValue();
        Assert.assertEquals(suggestionValue, string);
    }

    @When("user selects {string}")
    public void userSelectsOption(String option) {
        practicePage.selectDropdownOption(option);
    }

    @Then("selection must be {string}")
    public void verifyDropdownSelection(String expectedOption) {
        String selectedText = practicePage.getDropdownSelectedText();
        Assert.assertEquals(selectedText, expectedOption);
    }

    @When("user clicks on {string}")
    public void clickHeaderButton(String btnToClick) {
        practicePage.clickHeaderBtn(btnToClick);
    }

    @Then("user is redirected to {string} page")
    public void checkIfDifferentPage(String btnClicked) {
        String currentUrl = practicePage.getUrl();
        if (currentUrl.equals(url)) {
            System.out.println("Same URL - Btn: " + btnClicked);
        } else {
            System.out.println("Different URL - Btn: " + btnClicked);
        }
    }

    @When("user clicks new tab button {int} times")
    public void userClicksNewTabButtonTimes(int times) {
        practicePage.tabsHandling(times);
    }

    @Then("a {int} new tab is opened")
    public void verifyNewTabIsOpened(int times) {
        int tabsOpened = practicePage.getNumberOfCurrentTabs();
        Assert.assertEquals(tabsOpened, times);
    }


}

