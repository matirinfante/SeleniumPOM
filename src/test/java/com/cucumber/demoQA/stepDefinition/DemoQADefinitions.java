package com.cucumber.demoQA.stepDefinition;

import com.saucelabs.saucebindings.Browser;
import com.saucelabs.saucebindings.SaucePlatform;
import com.saucelabs.saucebindings.SauceSession;
import com.saucelabs.saucebindings.options.SauceOptions;
import com.seleniumpom.BaseTest;
import com.seleniumpom.second.DemoQAPage;
import com.seleniumpom.second.FormPage;
import com.seleniumpom.second.PracticeFormPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

import java.util.List;
import java.util.Map;

public class DemoQADefinitions {

    BaseTest baseTest;
    DemoQAPage demoQAPage;
    FormPage formPage;
    PracticeFormPage practiceFormPage;
    List<String> data;

    public DemoQADefinitions(BaseTest baseTest) {
        this.baseTest = baseTest;
    }


    @Before("@demoqa")
    public void setupPage(Scenario scenario) {
        this.baseTest.setUp(scenario);
        demoQAPage = new DemoQAPage(this.baseTest.getDriver());
        formPage = new FormPage(this.baseTest.getDriver());
        practiceFormPage = new PracticeFormPage(this.baseTest.getDriver());
    }

    @After("@demoqa")
    public void teardown() {
        this.baseTest.teardown();
    }

    @Given("user is in DemoQA page")
    public void userIsInDemoQAFormPage() {
        demoQAPage.launchSite("https://demoqa.com/");
    }

    @When("user clicks on Forms card")
    public void userClicksOnFormsCard() {
        demoQAPage.clickFormCard();
    }

    @Then("user should be redirected to Forms page")
    public void userIsRedirectedToFormsPage() {
        String currentUrl = demoQAPage.getUrl();
        Assert.assertEquals(currentUrl, "https://demoqa.com/forms");
    }

    @Given("user is in DemoQA Forms page")
    public void userIsInDemoQAFormsPage() {
        formPage.launchSite("https://demoqa.com/forms");
    }

    @When("user clicks on practice form")
    public void userClicksOnPracticeForm() {
        formPage.clickPracticeForm();
    }

    @Then("user is should be redirected to Practice Form page")
    public void userIsShouldBeRedirectedToPracticeFormPage() {
        String currentUrl = formPage.getUrl();
        Assert.assertEquals(currentUrl, "https://demoqa.com/automation-practice-form");
    }

    @Given("user is in DemoQA Practice Form page")
    public void userIsInDemoQAPracticeFormPage() {
        practiceFormPage.launchSite("https://demoqa.com/automation-practice-form");
        practiceFormPage.preparePage();
    }

    @When("user enters {string} and {string}")
    public void userEntersFirstNameAndLastName(String firstName, String lastName) {
        practiceFormPage.enterName(firstName);
        practiceFormPage.enterLastName(lastName);
    }

    @And("user enters {string} in email")
    public void userEntersEmail(String email) {
        practiceFormPage.enterEmail(email);
    }

    @And("user enters {string} in mobile")
    public void userEntersMobileNumber(String mobileNumber) {
        practiceFormPage.enterMobile(mobileNumber);
    }

    @And("user enters {string} in current address")
    public void userEntersAddress(String address) {
        practiceFormPage.enterAddress(address);
    }

    @And("user enters {string} in subject")
    public void userEntersSubject(String subject) {
        practiceFormPage.enterSubjects(subject);
    }

    @And("user selects {string} in gender")
    public void userSelectsInGender(String gender) {
        practiceFormPage.selectGender(gender);
    }

    @And("user selects {string} {string} {string} in calendar")
    public void userSelectsInCalendar(String day, String month, String year) {
        practiceFormPage.pickBirthDate(day, month, year);
    }

    @And("user selects {string} in hobbies")
    public void userSelectsInHobbies(String hobbie) {
        practiceFormPage.pickHobbies(hobbie);

    }

    @And("user uploads {string}")
    public void userUploadsImage(String imgPath) {
        practiceFormPage.uploadImage(imgPath);
    }

    @And("user selects {int} and {int}")
    public void userSelectsStateAndCity(int state, int city) {
        practiceFormPage.selectStateCity(state, city);
    }

    @And("user clicks submit button")
    public void userClicksSubmitButton() {
        practiceFormPage.clickSubmit();
    }

    @Then("modal shows data")
    public void modalShowsData(DataTable data) {
        List<String> dataToCheck = data.row(0);
        practiceFormPage.checkModalTable(dataToCheck);
    }


}
