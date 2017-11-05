package com.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPO extends BasePO{
    public LoginPO(WebDriver driver) {
        super(driver);
    }

    @FindBy(how=How.ID, using="authentication_username")
    public WebElement username;

    @FindBy(how=How.ID, using="authentication_password")
    public WebElement password;

    @FindBy(how=How.NAME, using="commit")
    public WebElement submit;

    @FindBy(how=How.ID, using="authentication_remember_me")
    public WebElement rememberMeRadioButton;

    @FindBy(how=How.LINK_TEXT, using="Forgot Password?")
    public WebElement forgotPasswordLink;

    @FindBy(how=How.LINK_TEXT, using="Login")
    public WebElement loginLink;

    @FindBy(how=How.LINK_TEXT, using="About")
    public WebElement aboutLink;

    @FindBy(how=How.ID, using="flash")
    public WebElement warning;



    public void login(String usernameValue, String passwdValue) {
        this.username.sendKeys(usernameValue);
        this.password.sendKeys(passwdValue);
        this.submit.click();
    }
}
