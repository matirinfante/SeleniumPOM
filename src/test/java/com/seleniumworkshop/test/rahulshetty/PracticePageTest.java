package com.seleniumworkshop.test.rahulshetty;

import com.seleniumworkshop.rahulshetty.PracticePage;
import com.seleniumworkshop.test.BaseTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PracticePageTest extends BaseTest {

    private PracticePage practicePage;

    @BeforeTest
    public void setupPage() {
        this.practicePage = new PracticePage(driver);
    }

    @Test
    public void highlightingTable() {
        practicePage.launchSite();
        practicePage.highlightRowByIndex(1);
        practicePage.highlightByValue("25");
    }

}
