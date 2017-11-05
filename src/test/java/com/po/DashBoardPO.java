package com.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class DashBoardPO extends BasePO{
    public DashBoardPO(WebDriver driver) {
        super(driver);
    }

    @FindBy(how= How.PARTIAL_LINK_TEXT, using="Dashboard")
    public WebElement dashboardLink;

    @FindBy(how= How.PARTIAL_LINK_TEXT, using="Tasks")
    public WebElement tasksLink;

    @FindBy(how= How.PARTIAL_LINK_TEXT, using="Campaigns")
    public WebElement campaignsLink;

    @FindBy(how= How.PARTIAL_LINK_TEXT, using="Leads")
    public WebElement leadsLink;

    @FindBy(how= How.PARTIAL_LINK_TEXT, using="Accounts")
    public WebElement accountsLink;

    @FindBy(how= How.PARTIAL_LINK_TEXT, using="Contacts")
    public WebElement contactsLink;

    @FindBy(how= How.PARTIAL_LINK_TEXT, using="Opportunities")
    public WebElement opportunityLink;

    @FindBy(how= How.PARTIAL_LINK_TEXT, using="Team")
    public WebElement teamLink;

    @FindBy(how= How.LINK_TEXT, using="Admin")
    public WebElement adminLink;
}
