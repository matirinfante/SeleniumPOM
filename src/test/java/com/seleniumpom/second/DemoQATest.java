package com.seleniumpom.second;

import com.seleniumpom.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DemoQATest extends BaseTest {

    DemoQAPage demoQAPage;
    FormPage formPage;
    PracticeFormPage practiceFormPage;
    List<String> data;

    @BeforeTest
    public void setupPage() {
        demoQAPage = new DemoQAPage(this.driver);
        formPage = new FormPage(this.driver);
        practiceFormPage = new PracticeFormPage(this.driver);
        data = new ArrayList<String>();
        data.add("Matias Infante");
        data.add("un_mail@mail.com");
        data.add("Male");
        data.add("123456789");
        data.add("07 January,2022");
        data.add("Maths");
        data.add("Music");
        data.add("bird.jpg");
        data.add("an address 123");
        data.add("NCR Noida");
    }


    @Test
    public void goToForms() throws InterruptedException {
        demoQAPage.launchSite("https://demoqa.com/");
        String urlForm = demoQAPage.checkGoToForm();
        Assert.assertEquals(urlForm, "https://demoqa.com/forms");
        String selectionUrl = formPage.checkGoToPracticeForm();
        Assert.assertEquals(selectionUrl, "https://demoqa.com/automation-practice-form");
        practiceFormPage.preparePage();
        practiceFormPage.fillFormInputs("Matias", "Infante", "un_mail@mail.com", "1234567890", "Maths", "an address 123");
        practiceFormPage.selectGender("Male");
        practiceFormPage.pickBirthDate("07", "1", "1997");
        practiceFormPage.pickHobbie("3"); //fix
        practiceFormPage.uploadImage("C:/Users/Matias/Desktop/bird.jpg");
        practiceFormPage.selectStateCity(1, 3);
        practiceFormPage.submitAndCheck(data);
        Thread.sleep(5000);

    }

}