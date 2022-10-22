package com.seleniumpom.second;

import com.seleniumpom.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PracticeFormPage extends BasePage {

    By pInputName = By.id("firstName");
    By pInputLastName = By.id("lastName");
    By pInputEmail = By.id("userEmail");
    By pInputMobile = By.id("userNumber");
    By pInputSubject = By.id("subjectsInput");
    By pInputCurrentAddress = By.id("currentAddress");
    By pRadioGender = By.xpath("//input[@name=\"gender\"]");
    By pCheckboxHobbies = By.xpath("//input[@type=\"checkbox\"]");
    By pDatePickerInput = By.id("dateOfBirthInput");
    By pDatePickerCalendar = By.className("react-datepicker");
    By pSelectMonth = By.className("react-datepicker__month-select");
    By pSelectYear = By.className("react-datepicker__year-select");
    By pDaysButtons = By.className("react-datepicker__month");
    By pImagePicker = By.id("uploadPicture");
    By pDropdownState = By.id("react-select-3-input");
    By pDropdownCity = By.id("react-select-4-input");
    By pSubmitButton = By.id("submit");
    By pAlertPopup = By.xpath("//div[@class=\"modal-body\"]");
    By pTableData = By.xpath("//div[@class='modal-body']//td//following-sibling::td");
    By pButtonCloseModal = By.id("closeLargeModal");
    By pFooter = By.tagName("footer");
    By pAdBanner = By.id("fixedban");

    public PracticeFormPage(WebDriver driver) {
        super(driver);
    }

    public void launchSite(String url) {
        visit(url);
    }

    public void preparePage() {
        hideElement(pFooter);
        hideElement(pAdBanner);
    }

    public void fillFormInputs(String name, String lastName, String email, String mobile, String subjects, String currentAddress) {
        SoftAssert softAssert = new SoftAssert();

        type(pInputName, name);
        softAssert.assertEquals(getValue(pInputName), name);

        type(pInputLastName, lastName);
        softAssert.assertEquals(getValue(pInputLastName), lastName);

        type(pInputEmail, email);
        softAssert.assertEquals(getValue(pInputEmail), email);

        type(pInputMobile, mobile);
        softAssert.assertEquals(getValue(pInputMobile), mobile);

        type(pInputSubject, subjects);
        typeKey(pInputSubject, Keys.ARROW_DOWN);
        typeKey(pInputSubject, Keys.ENTER);
        softAssert.assertEquals(getValue(pInputSubject), subjects);

        type(pInputCurrentAddress, currentAddress);
        softAssert.assertEquals(getValue(pInputCurrentAddress), currentAddress);

    }

    public void enterName(String name) {
        type(pInputName, name);
    }

    public void enterLastName(String lastName) {
        type(pInputLastName, lastName);
    }

    public void enterEmail(String email) {
        type(pInputEmail, email);
    }

    public void enterMobile(String mobile) {
        type(pInputMobile, mobile);
    }

    public void enterAddress(String currentAddress) {
        type(pInputCurrentAddress, currentAddress);
    }

    public void enterSubjects(String subjectsString) {
        String[] subjects = subjectsString.split(",");
        for (String subject : subjects) {
            enterSubject(subject);
        }
    }

    public void enterSubject(String subject) {
        type(pInputSubject, subject);
        typeKey(pInputSubject, Keys.ARROW_DOWN);
        typeKey(pInputSubject, Keys.ENTER);
    }

    public void selectGender(String genderText) {
        clickOnRadioByText(pRadioGender, genderText);
    }

    public void pickBirthDate(String day, String month, String year) {
        click(pDatePickerInput);
        waitForVisibility(pDatePickerCalendar);
        selectOption(pSelectMonth, Integer.parseInt(month) - 1);
        selectOptionByValue(pSelectYear, year);
        By dayLocator = By.xpath("//div[@class ='react-datepicker__month']//div[contains(@class,day) and not(contains(@class, 'react-datepicker__day--outside-month'))]");
        clickByExecutorAndDay(getElement(dayLocator), day);
    }

    public void pickHobbies(String hobbiesString) {
        String[] hobbies = hobbiesString.split(",");
        for (String hobbie : hobbies) {
            pickHobbie(hobbie);
        }
    }

    public void pickHobbie(String hobbiePick) {
        clickOnRadioByText(pCheckboxHobbies, hobbiePick);
    }

    public void uploadImage(String path) {
        type(pImagePicker, path);
    }

    public void selectStateCity(int state, int city) {
        selectDropdownOption(pDropdownState, state);
        waitEnabled(pDropdownCity);
        selectDropdownOption(pDropdownCity, city);
    }

    public void clickSubmit() {
        click(pSubmitButton);
    }

    public void checkModalTable(List<String> data) {
        checkTable(pTableData, data);
    }

    public void submitAndCheck(List<String> data) {
        click(pSubmitButton);
        waitForVisibility(pAlertPopup);
        checkTable(pTableData, data);
    }

    private void checkTable(By locator, List<String> data) {
        List<WebElement> tRowsData = getElements(locator);
        boolean correctData = false;
        int i = 0;
        SoftAssert softAssert = new SoftAssert();
        for (WebElement row : tRowsData) {
            System.out.println("actual: " + getText(row) + " expected: " + data.get(i));
            softAssert.assertEquals(getText(row), data.get(i));
            i++;
        }
    }

    private void checkTableRow(By locator, String data) {
        List<WebElement> tRowsData = getElements(locator);

        WebElement checkRow = tRowsData.stream().filter(element -> getText(element).equals(data)).findFirst().get();
    }
}
