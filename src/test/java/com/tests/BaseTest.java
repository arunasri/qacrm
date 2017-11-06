package com.tests;

import com.po.HomePO;
import com.po.LoginPO;
import org.apache.commons.logging.impl.Log4JLogger;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    public Logger logger = Logger.getLogger(this.getClass().getName());
    protected WebDriver driver;

    //static final means constant
    //All constants needs to be capital
    public static final String BASE_URL = "http://qacrm.herokuapp.com";
    public final static String SAUCE_LABS = "https://arunasri:5eff05a3-a91a-41aa-90ff-0a54533fe9ba@ondemand.saucelabs.com:443/wd/hub";

    @BeforeClass
    public static void Setup() {
        DOMConfigurator.configure("log4j.xml");
    }

    @BeforeMethod(alwaysRun = true)
    public void loadHomePage() throws MalformedURLException {
        this.driver = setRemoteDriver();
        //this.driver = setLocalDriver();
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

    public void loginAsAdmin() {
        LoginPO loginPO = new LoginPO(this.driver);
        loginPO.login("heather", "heather");
        HomePO homePO = new HomePO(this.driver);
        Assert.assertNotNull(homePO.welcomeUser);
    }

    public void loginAsNonAdmin() {
        LoginPO loginPO = new LoginPO(this.driver);
        loginPO.login("george", "george");
        HomePO homePO = new HomePO(this.driver);
        Assert.assertNotNull(homePO.welcomeUser);
    }


    //isElementPresent used for assert whether element is on the page
    //if it is not present it is going to throw exception which return false
    //when found it checks whether is dispalyed
    public boolean isElementPresent(WebElement element) {
        try{
            return element.isDisplayed();
        }catch (RuntimeException e){
            return false;
        }
    }
}
