package com.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    protected WebDriver driver;

    //static final means constant
    //All constants needs to be capital
    public static final String BASE_URL = "http://qacrm.herokuapp.com";
    public final static String SAUCE_LABS = "https://arunasri:5eff05a3-a91a-41aa-90ff-0a54533fe9ba@ondemand.saucelabs.com:443/wd/hub";


    @BeforeMethod(alwaysRun = true)
    public void loadHomePage() throws MalformedURLException {
        this.driver = setRemoteDriver();
        this.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        this.driver.get(BASE_URL);
    }

    @AfterMethod(alwaysRun = true)
    public void closeBrowser() {
        this.driver.quit();
    }

    private WebDriver setLocalDriver() {
        return new ChromeDriver();
    }

    private WebDriver setRemoteDriver() throws MalformedURLException {
        return new RemoteWebDriver(new URL(SAUCE_LABS), DesiredCapabilities.chrome());
    }
}
