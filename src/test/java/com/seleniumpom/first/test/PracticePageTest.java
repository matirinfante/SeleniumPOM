package com.seleniumpom.first.test;

import com.seleniumpom.BaseTest;
import com.seleniumpom.first.PracticePage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PracticePageTest extends BaseTest {

    PracticePage practicePage;

    @BeforeTest
    public void setupPage() {
        practicePage = new PracticePage(this.driver);
    }

    @BeforeMethod
    public void visitSite() {
        practicePage.launchSite("https://rahulshettyacademy.com/AutomationPractice/");
    }

    @Test(priority = 1)
    public void firstTest() {
        practicePage.radioButtonSelect();
        practicePage.showRadioStatus();
    }

    @Test(priority = 2)
    public void secondTest() throws InterruptedException {
        String placeholderText = practicePage.printPlaceholder();
        Assert.assertEquals(placeholderText, "Type to Select Countries");
        practicePage.typeAndSelectSuggestionText("");
        String suggestionValue = practicePage.getSuggestionValue();
        Assert.assertEquals(suggestionValue, "El Salvador");
    }

    @Test(priority = 3)
    public void thirdTest() {
        String selectedText = practicePage.selectDropdownOption2();
        Assert.assertEquals(selectedText, "Option2");
        String newSelectedText = practicePage.selectDropdownOption3();
        Assert.assertEquals(newSelectedText, "Option3");
    }

    @Test(priority = 4)
    public void fourthTest() {
        practicePage.checkButtons();
    }

    @Test(priority = 5)
    public void fifthTest() {
        practicePage.tabsHandling(9);
    }
}
