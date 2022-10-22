package com.seleniumpom;

import com.saucelabs.saucebindings.Browser;
import com.saucelabs.saucebindings.SaucePlatform;
import com.saucelabs.saucebindings.SauceSession;
import com.saucelabs.saucebindings.options.SauceOptions;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.asserts.SoftAssert;

public class BaseTest {

    protected WebDriver driver;
    protected SoftAssert softAssert;

    protected static ThreadLocal<SauceSession> session = new ThreadLocal<>();
    protected static ThreadLocal<SauceOptions> options = new ThreadLocal<>();

    public SauceSession getSession() {
        return session.get();
    }

    public RemoteWebDriver getDriver() {
        return getSession().getDriver();
    }

    public final void setUp(Scenario scenario) {
        options.set(new SauceOptions());

        options.get().sauce().setName(scenario.getName());

        if (System.getenv("START_TIME") != null) {
            options.get().sauce().setBuild("Build Time: " + System.getenv("START_TIME"));
        }
        options.get();
        String platform;
        if (System.getProperty("platform") != null) {
            platform = System.getProperty("platform");
        } else {
            platform = "windows_10_edge";
        }
        switch (platform) {
            case "windows_10_edge":
                options.get().setPlatformName(SaucePlatform.WINDOWS_10);
                options.get().setBrowserName(Browser.EDGE);
                options.get().setCapability("screenResolution", "1400x1050");
                break;
            case "mac_sierra_chrome":
                options.get().setPlatformName(SaucePlatform.MAC_SIERRA);
                options.get().setBrowserName(Browser.CHROME);
                break;
            case "windows_8_ff":
                options.get().setPlatformName(SaucePlatform.WINDOWS_8);
                options.get().setBrowserName(Browser.FIREFOX);
                break;
            case "windows_8_1_ie":
                options.get().setPlatformName(SaucePlatform.WINDOWS_8_1);
                options.get().setBrowserName(Browser.INTERNET_EXPLORER);
                break;
            case "mac_mojave_safari":
                options.get().setPlatformName(SaucePlatform.MAC_MOJAVE);
                options.get().setBrowserName(Browser.SAFARI);
                break;
            default:
                // accept Sauce defaults
                break;
        }

        session.set(new SauceSession(options.get()));

        getSession().start();
        this.getDriver().setFileDetector(new LocalFileDetector());
        //this.driver = WebDriverManager.chromedriver().create();
        //this.driver.manage().window().maximize();
        //this.softAssert = new SoftAssert();
    }

//    public WebDriver getDriver() {
//        return this.driver;
//    }

    public SoftAssert getSoftAssert() {
        return this.softAssert;
    }

    public void teardown() {
        this.getSession().stop(true);
    }
}
