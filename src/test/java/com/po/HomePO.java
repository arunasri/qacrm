package com.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePO extends BasePO{
    public HomePO(WebDriver driver) {
        super(driver);
    }


    @FindBy(how= How.ID, using="welcome_username")
    public WebElement welcomeUser;

    @FindBy(how= How.LINK_TEXT, using="Logout")
    public WebElement logoutLink;

    @FindBy(how= How.LINK_TEXT, using="Admin")
    public WebElement adminLink;

    @FindBy(how= How.LINK_TEXT, using="Profile")
    public WebElement profileLink;










}
