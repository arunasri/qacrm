package com.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ForgoPasswordPO extends BasePO{
    @FindBy(how= How.ID, using="email")
    public WebElement email;

    @FindBy(how= How.ID, using="passwords_submit")
    public WebElement resetPasswordButton;

    @FindBy(how= How.CLASS_NAME, using="title")
    public WebElement title;

    @FindBy(how= How.CLASS_NAME, using="intro")
    public WebElement intro;

    public static final String INTRO_TEXT="Please specify your email address, and the instructions to reset your password will be sent to you.";

    public ForgoPasswordPO(WebDriver driver){
        super(driver);
    }
}
