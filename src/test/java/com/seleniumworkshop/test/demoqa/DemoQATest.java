package com.seleniumworkshop.test.demoqa;

import com.seleniumworkshop.demoqa.DemoQAPage;
import com.seleniumworkshop.test.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DemoQATest extends BaseTest {

    private DemoQAPage demoQAPage;

    @BeforeTest
    public void setupPage() {
        this.demoQAPage = new DemoQAPage(driver);
    }

    @Test
    public void checkIfDrop() {
        demoQAPage.launchSite();
        demoQAPage.dragElementToDrop();
        Assert.assertTrue(demoQAPage.droppableChange());
        demoQAPage.highlightDroppable();
    }

}
